/*
 * Created by JFormDesigner on Sun Feb 23 21:50:10 CST 2020
 */

package controler;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 1
 */
public class RouteSearch extends JFrame {

    public Map<Integer, String> station;
    public Map<String, List<Integer>> route;
    public List<String> routeNameList;

    public RouteSearch(Map<Integer, String> station1, Map<String, java.util.List<Integer>> route1, List<String> routeNameList1) {

        station = station1;
        route = route1;
        routeNameList = routeNameList1;

        initComponents();

        for (String x : routeNameList) {
            comboBox1.addItem(x);
        }
    }

    private void button1MouseClicked(MouseEvent e) {

        String routeName = (String) comboBox1.getSelectedItem();

        List<Integer> stationList = route.get(routeName);
        String content = "";
        int index = 1;
        for (Integer x : stationList) {
            String temp = station.get(x);
            content += temp;
            if (index % 4 == 0)
                content += "\n";

            content += "<-->";

            index++;
        }
        if (content.charAt(content.length() - 1) == '\n') {
            content = content.substring(0, content.length() - 4);
        } else {
            content = content.substring(0, content.length() - 3);
        }

        textArea1.setText(content);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label2 = new JLabel();

        //======== this ========
        setTitle("RouteSearch");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7ebf\u8def\u67e5\u8be2");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 24));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- comboBox1 ----
        comboBox1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 18));

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 18));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 18));
            scrollPane1.setViewportView(textArea1);
        }

        //---- label2 ----
        label2.setText("\u6240\u542b\u7ad9\u70b9");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 20));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                    .addGap(107, 107, 107))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(163, 163, 163)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(59, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JComboBox comboBox1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
