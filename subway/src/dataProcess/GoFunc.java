package dataProcess;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dataProcess.importData.preProcess;

/**
 * @ProjectName: subway
 * @Package: dataProcess
 * @ClassName: GoFunc
 * @Author: ZXG
 * @Date: 2020/3/10 10:18
 */
public class GoFunc {

    //存放距离
    private Integer[][] arr1;
    //存放线路
    // arr2[i][j] 是一个存放Integer的list
    private List<Integer>[][] arr2;

    private Map<Integer, String> station = new HashMap<>();
    private Map<String, List<Integer>> route = new HashMap<>();
    private List<String> routeNameList;
    private Integer n;
    private Integer max = 1000;

    public GoFunc() throws IOException {
        routeNameList = preProcess("static/station.txt", station, "static/route.txt", route);
        n = station.size();
        arr1 = new Integer[n + 1][n + 1];
        arr2 = new ArrayList[n + 1][n + 1];
        initArr();
        process();
    }

    public static void main(String[] args) throws IOException {
        new GoFunc();
    }

    public void initArr() {

        //arr1初始化
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                arr1[i][j] = max;
//                if (i == j) {
//                    arr1[i][j] = 0;
//                    continue;
//                }
//                for (String routeName : routeNameList) {
//                    List<Integer> routeList = route.get(routeName);
//                    for (int k = 0; k < routeList.size() - 1; k++) {
//                        if (routeList.get(k) == i && routeList.get(k + 1) == j) {
//                            arr1[i][j] = 1;
//                            arr1[j][i] = 1;
//                        }
//                    }
//                }
//            }
//        }

        //arr1初始化
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    arr1[i][j] = 0;
                else
                    arr1[i][j] = max;
            }
        }
        for (String routeName : routeNameList) {
            List<Integer> routeList = route.get(routeName);
            for (int i = 0; i < routeList.size() - 1; i++) {
                int a = routeList.get(i);
                int b = routeList.get(i + 1);
                arr1[a][b] = 1;
                arr1[b][a] = 1;
            }
        }

        //初始化arr2
        //arr2中的list放起始点
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr2[i][j] = new ArrayList();
                arr2[i][j].add(i);
            }
        }

    }

    public void process() {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    int distance = arr1[j][i] + arr1[i][k];

                    List<Integer> x = new ArrayList<>();
                    x.addAll(arr2[j][i]);
                    List<Integer> y = new ArrayList<>();
                    y.addAll(arr2[i][k]);
                    // x y 为完整线路 即包括起始站和终点站
                    x.add(i);
                    y.add(k);
                    //判断是否换乘
                    Integer a = x.get(x.size() - 2);
                    Integer b = x.get(x.size() - 1);
                    Integer c = y.get(0);
                    boolean flag = Switch(a, b, c);
                    if (flag)
                        distance++;

                    if (distance < arr1[j][k]) {
                        arr1[j][k] = distance;
                        List<Integer> list = new ArrayList<>();
                        list.addAll(arr2[j][i]);
                        list.addAll(arr2[i][k]);
                        arr2[j][k].clear();
                        arr2[j][k].addAll(list);
                    }
                }
//                System.out.print(i + " " + j + " ");
//                System.out.println(arr2[i][j]);
            }
            // System.out.println(i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                System.out.print(i + " " + j + " " + arr1[i][j] + "  ");
                for (int k = 0; k < arr2[i][j].size(); k++) {
                    System.out.print(arr2[i][j].get(k) + "-");
                }
                System.out.println();
            }
        }
    }

    //判断是否换乘
    public boolean Switch(Integer a, Integer b, Integer c) {

        String route1 = null;
        String route2 = null;

        for (String routeName : routeNameList) {
            List<Integer> list = route.get(routeName);
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).equals(a) && list.get(i + 1).equals(b)) {
                    route1 = routeName;
                } else if (list.get(i).equals(b) && list.get(i + 1).equals(a)) {
                    route1 = routeName;
                } else if (list.get(i).equals(b) && list.get(i + 1).equals(c)) {
                    route2 = routeName;
                } else if (list.get(i).equals(c) && list.get(i + 1).equals(b)) {
                    route2 = routeName;
                }
            }
            if (route1 != null && route2 != null)
                break;
        }


        return route1 != null && route1.equals(route2);
    }
}
