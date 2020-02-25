/*
 * Created by JFormDesigner on Sun Feb 23 11:37:54 CST 2020
 */

package controler;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import javax.swing.*;

/**
 * @author 1
 */
class Menu extends JFrame {


    public Map<Integer, String> station;
    public Map<String, List<Integer>> route;
    public List<String> routeNameList;

    public Menu(Map<Integer, String> station1, Map<String, List<Integer>> route1, List<String> routeList1) {
        station = station1;
        route = route1;
        routeNameList = routeList1;
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {  //查询所有路线及站点

        Overview frame = new Overview(station, route, routeNameList);
        frame.setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e) { //查询经过某一站点的所有路线

        StationSearch frame = new StationSearch(station, route, routeNameList);
        frame.setVisible(true);
    }

    private void button3MouseClicked(MouseEvent e) {  //查询某一线路的所有站点

        RouteSearch frame = new RouteSearch(station, route, routeNameList);
        frame.setVisible(true);
    }

    private void button4MouseClicked(MouseEvent e) {  // 出发！！

        Go frame = new Go(station, route, routeNameList);
        frame.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setTitle("Menu");
        setBackground(new Color(51, 204, 255));
        setForeground(Color.pink);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6b66\u6c49\u5730\u94c1\u67e5\u8be2\u7cfb\u7edf");
        label1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 26));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- button1 ----
        button1.setText("\u6240\u6709\u7ad9\u70b9\u53ca\u7ebf\u8def");
        button1.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 19));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("\u7ad9\u70b9\u67e5\u8be2");
        button2.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 19));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText("\u7ebf\u8def\u67e5\u8be2");
        button3.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 19));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });

        //---- button4 ----
        button4.setText("\u6211\u8981\u51fa\u53d1\uff01");
        button4.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 19));
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(165, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(button3, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(button4, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(62, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
