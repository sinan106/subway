/*
 * Created by JFormDesigner on Sun Feb 23 22:25:46 CST 2020
 */

package controler;

import java.awt.event.*;

import dataProcess.GoFunc;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;


/**
 * @author 1
 */
public class Go extends JFrame {

    private Map<Integer, String> station;
    private Map<String, List<Integer>> route;
    private List<String> routeNameList;
    private GoFunc goFunc;

    public Go(Map<Integer, String> station1, Map<String, List<Integer>> route1, List<String> routeNameList1, GoFunc goFunc1) {
        station = station1;
        route = route1;
        routeNameList = routeNameList1;
        goFunc = goFunc1;

        initComponents();
    }


    private void button1MouseClicked(MouseEvent e) {
        //检查输入的地名是否正确
        String departure = textField1.getText();
        String destination = textField2.getText();
        Integer dep = null;
        Integer des = null;
        boolean flag1 = false;
        boolean flag2 = false;

        for (Integer x : station.keySet()) {
            if (station.get(x).equals(departure)) {
                dep = x;
                flag1 = true;
            }
            if (station.get(x).equals(destination)) {
                des = x;
                flag2 = true;
            }
            if (flag1 && flag2)
                break;
        }

        if (!flag1 && !flag2) {
            JOptionPane.showMessageDialog(null, "查找不到出发地和目的地，请重新输入");
            textField1.setText("");
            textField2.setText("");
        } else if (!flag1) {
            JOptionPane.showMessageDialog(null, "查找不到此出发地，请重新输入");
            textField1.setText("");
        } else if (!flag2) {
            JOptionPane.showMessageDialog(null, "查找不到此目的地，请重新输入");
            textField2.setText("");
        }

        if (flag1 && flag2) {

            String content = "";
            String Switch = "";

            List<Integer> list = goFunc.go(dep, des);

            for (int i = 0; i < list.size() - 1; i++) {

                String name = station.get(list.get(i));
                content += name;

                if ((i + 1) % 4 == 0)
                    content += "\n";

                content += "-->";

            }
            content += station.get(list.get(list.size() - 1)) + "\n";



            for (int i = 1; i < list.size()-1; i++) {

                String route1 = null;
                String route2 = null;

                Integer a = list.get(i-1);
                Integer b = list.get(i);
                Integer c = list.get(i+1);

                for (String routeName : routeNameList) {
                    List<Integer> list1 = route.get(routeName);
                    for (int j = 0; j < list1.size() - 1; j++) {
                        if (list1.get(j).equals(a) && list1.get(j + 1).equals(b)) {
                            route1 = routeName;
                        } else if (list1.get(j).equals(b) && list1.get(j + 1).equals(a)) {
                            route1 = routeName;
                        } else if (list1.get(j).equals(b) && list1.get(j + 1).equals(c)) {
                            route2 = routeName;
                        } else if (list1.get(j).equals(c) && list1.get(j + 1).equals(b)) {
                            route2 = routeName;
                        }
                    }
                    if (route1 != null && route2 != null)
                        break;
                }

                if (!route1.equals(route2)) {
                    Switch += "于 " + station.get(b) + " 从 " + route1 +" 换到 " + route2 + "\n";
                }

            }
            content += Switch;

            textArea1.setText(content);
        }

    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label4 = new JLabel();

        //======== this ========
        setTitle("Go");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Go Go Go !!!!");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 24));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setText("\u51fa\u53d1\u5730");
        label2.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 22));
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label3 ----
        label3.setText("\u76ee\u7684\u5730");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 22));

        //---- textField1 ----
        textField1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 22));

        //---- textField2 ----
        textField2.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 22));

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 22));
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

        //---- label4 ----
        label4.setText("\u63a8\u8350\u7ebf\u8def");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 24));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(217, 217, 217)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                            .addGap(66, 66, 66)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
                            .addGap(86, 86, 86)
                            .addComponent(button1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(284, 284, 284)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(147, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 7, Short.MAX_VALUE)))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(label4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
