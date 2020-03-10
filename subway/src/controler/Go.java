/*
 * Created by JFormDesigner on Sun Feb 23 22:25:46 CST 2020
 */

package controler;

import java.awt.event.*;

import dataProcess.GoFunc;
import dataProcess.Graph;

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
    private Graph graph;
    private Integer verNum = 0;
    private Integer edgeNum = 0;

    public Go(Map<Integer, String> station1, Map<String, List<Integer>> route1, List<String> routeNameList1) {
        station = station1;
        route = route1;
        routeNameList = routeNameList1;

        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        //检查输入的地名是否正确
        String departure = textField1.getText();
        String destination = textField2.getText();

        boolean flag1 = false;
        boolean flag2 = false;

        for (Integer x : station.keySet()) {
            if (station.get(x).equals(departure)) {
                flag1 = true;
            }
            if (station.get(x).equals(destination)) {
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
            textField1.setText("");
        }

        if (flag1 && flag2) {
            String dep = textField1.getText();
            String des = textField2.getText();
        }
    }

    private void initComponents() {

        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label4 = new JLabel();
        label5 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();

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
            scrollPane1.setViewportView(textArea1);
        }

        //---- label4 ----
        label4.setText("\u6700\u5c11\u6362\u4e58");
        label4.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 22));
        label4.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label5 ----
        label5.setText("\u6700\u5c11\u505c\u9760");
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 22));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textArea2);
        }

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
                                                .addGap(61, 61, 61)
                                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(255, 255, 255)
                                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(103, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents


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
    private JLabel label5;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
