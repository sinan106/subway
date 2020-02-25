/*
 * Created by JFormDesigner on Sun Feb 23 15:08:47 CST 2020
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
public class Overview extends JFrame {

    private Map<Integer, String> station;
    private Map<String, List<Integer>> route;
    private List<String> routeNameList;


    public Overview(Map<Integer, String> station1, Map<String, List<Integer>> route1, List<String> routeNameList1) {
        station = station1;
        route = route1;
        routeNameList = routeNameList1;

        initComponents();
        String content = "";
        for (int i = 0; i < routeNameList.size(); i++) {
            String routeName = routeNameList.get(i);
            content += routeName;
            content += " : ";
            List<Integer> stationList = route.get(routeName);
            for (int x : stationList) {
                String name = station.get(x);
                content += name;
                content += "---";
            }
            content = content.substring(0, content.length() - 3);
            content += "\n";
            textArea1.setText(content);
        }
    }



    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("overview");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6240\u6709\u7ebf\u8def\u53ca\u7ad9\u70b9");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 24));

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 18));
            scrollPane1.setViewportView(textArea1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(72, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
