package dataProcess;

import java.util.*;

/**
 * @ProjectName: subway
 * @Package: dataProcess
 * @ClassName: function
 * @Author: ZXG
 * @Date: 2020/2/24 22:44
 */
/*注意 ！！！！！！！！！！！！*/
/* nodes 从1开始 计数 不是从0开始！！！！！！！！！*/
public class Function {

    private Map<Integer, String> station = new HashMap<>();
    private Map<String, List<Integer>> route = new HashMap<>();
    private List<String> routeNameList;
    private Integer[][] matrix;
    Node[] nodes;


    /* 临时保存路径节点的栈 */
    public static Stack<Node> stack = new Stack<Node>();
    /* 存储路径的集合 */
    public static ArrayList<Object[]> sers = new ArrayList<Object[]>();


    public Function(String dep, String des, Map<Integer, String> station1, Map<String, List<Integer>> route1, List<String> routeNameList1) {

        for (Integer x : station1.keySet()) {
            String name = station1.get(x);
            station.put(x - 1, name);
        }

        for (String x : routeNameList1) {
            List<Integer> list = route1.get(x);
            List<Integer> newList = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                newList.add(list.get(i) - 1);
            }
            route.put(x, newList);
        }
        routeNameList = routeNameList1;

        nodes = new Node[station.size() + 1];
        matrix = new Integer[station.size() + 1][];

        init();
        System.out.println("--------------------");
        System.out.println(station.size());
        System.out.println(nodes.length);
        getPaths(nodes[79], null, nodes[79], nodes[82]);
    }


    public void init() {


        for (int i = 0; i <= station.size(); i++) {
            nodes[i] = new Node();
            nodes[i].setNum(i);
        }
        System.out.println("--------------------");
        System.out.println(station.size());
        System.out.println(nodes.length);


        for (String routeName : routeNameList) {

            List<Integer> routeList = route.get(routeName);

            for (int i = 0; i < routeList.size() - 1; i++) {
                Integer x = routeList.get(i);  // i的编号
                Integer y = routeList.get(i + 1);  // i+1的编号

                nodes[x].relationNodes.add(nodes[y]);
                nodes[y].relationNodes.add(nodes[x]);
            }
        }

        //node的list输出检测
//        for (int j = 0; j < nodes.length; j++) {
//            System.out.print(nodes[j].getNum() + ":");
//            for (int k = 0; k < nodes[j].relationNodes.size(); k++) {
//                System.out.print(nodes[j].relationNodes.get(k).getNum() + "---");
//            }
//            System.out.println();
//        }


        // 建立矩阵
        for (int i = 0; i < nodes.length; i++) {
            matrix[i] = new Integer[nodes[i].relationNodes.size()];
            for (int j = 0; j < nodes[i].relationNodes.size(); j++) {
                matrix[i][j] = nodes[i].relationNodes.get(j).getNum();
            }
        }

        //矩阵输出
//        for (int i = 0; i < nodes.length; i++) {
//            for (int j = 0; j < nodes[i].relationNodes.size(); j++) {
//                System.out.print(nodes[i].relationNodes.get(j).getNum() + " ");
//            }
//            System.out.println();
//        }
    }

    public static boolean isNodeInStack(Node node) {
        Iterator<Node> it = stack.iterator();
        while (it.hasNext()) {
            Node node1 = (Node) it.next();
            if (node == node1)
                return true;
        }
        return false;
    }

    public static void showAndSavePath() {
        Object[] o = stack.toArray();
        for (int i = 0; i < o.length; i++) {
            Node nNode = (Node) o[i];

            if (i < (o.length - 1))
                System.out.print(nNode.getNum() + "->");
            else
                System.out.print(nNode.getNum());
        }
        sers.add(o); /* 转储 */
        System.out.println();
    }

    public static boolean getPaths(Node cNode, Node pNode, Node sNode, Node eNode) {
        Node nNode = null;
        /* 如果符合条件判断说明出现环路，不能再顺着该路径继续寻路，返回false */
        if (cNode != null && pNode != null && cNode == pNode)
            return false;

        if (cNode != null) {
            int i = 0;
            /* 起始节点入栈 */
            stack.push(cNode);
            /* 如果该起始节点就是终点，说明找到一条路径 */
            if (cNode == eNode) {
                /* 转储并打印输出该路径，返回true */
                showAndSavePath();
                return true;
            }
            /* 如果不是,继续寻路 */
            else {
                /*
                 * 从与当前起始节点cNode有连接关系的节点集中按顺序遍历得到一个节点
                 * 作为下一次递归寻路时的起始节点
                 */
                nNode = cNode.getRelationNodes().get(i);
                while (nNode != null) {
                    /*
                     * 如果nNode是最初的起始节点或者nNode就是cNode的上一节点或者nNode已经在栈中 ，
                     * 说明产生环路 ，应重新在与当前起始节点有连接关系的节点集中寻找nNode
                     */
                    if (pNode != null
                            && (nNode == sNode || nNode == pNode || isNodeInStack(nNode))) {
                        i++;
                        if (i >= cNode.getRelationNodes().size())
                            nNode = null;
                        else
                            nNode = cNode.getRelationNodes().get(i);
                        continue;
                    }
                    /* 以nNode为新的起始节点，当前起始节点cNode为上一节点，递归调用寻路方法 */
                    if (getPaths(nNode, cNode, sNode, eNode))/* 递归调用 */ {
                        /* 如果找到一条路径，则弹出栈顶节点 */
                        stack.pop();
                    }
                    /* 继续在与cNode有连接关系的节点集中测试nNode */
                    i++;
                    if (i >= cNode.getRelationNodes().size())
                        nNode = null;
                    else
                        nNode = cNode.getRelationNodes().get(i);
                }
                /*
                 * 当遍历完所有与cNode有连接关系的节点后，
                 * 说明在以cNode为起始节点到终点的路径已经全部找到
                 */
                stack.pop();
                return false;
            }
        } else
            return false;
    }


}
