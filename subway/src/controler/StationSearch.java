/*
 * Created by JFormDesigner on Sun Feb 23 21:12:37 CST 2020
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
public class StationSearch extends JFrame {

    public Map<Integer, String> station;
    public Map<String, List<Integer>> route;
    public List<String> routeNameList;


    public StationSearch(Map<Integer, String> station1, Map<String, java.util.List<Integer>> route1, List<String> routeNameList1) {

        station = station1;
        route = route1;
        routeNameList = routeNameList1;
        initComponents();
    }

    public void function() {
        String stationName = textField1.getText();
        Integer stationNum = null;
        String content = "";
        boolean flag = false;
        for (Integer x : station.keySet()) {
            if (station.get(x).equals(stationName)) {
                flag = true;
                stationNum = x;
                break;
            }
        }

        if (!flag) {
            JOptionPane.showMessageDialog(null, "查询不到此站名，请重新输入");
            textField1.setText("");
        }

        for (String r : routeNameList) {

            List<Integer> routeList = route.get(r);
            for (Integer x : routeList) {
                if (x.equals(stationNum)) {
                    content += r;
                    content += "\n";
                }
            }
        }

        textArea1.setText(content);
    }

    private void button1MouseClicked(MouseEvent e) {
        function();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label2 = new JLabel();

        //======== this ========
        setTitle("StationSearch");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7ad9\u70b9\u67e5\u8be2");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- textField1 ----
        textField1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 20));

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
            textArea1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 22));
            scrollPane1.setViewportView(textArea1);
        }

        //---- label2 ----
        label2.setText("\u7ecf\u8fc7\u6b64\u7ad9\u70b9\u7684\u7ebf\u8def");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 18));
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(161, 161, 161)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(187, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 82, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane1)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addGap(131, 131, 131)
                            .addComponent(button1))
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(79, 79, 79))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
