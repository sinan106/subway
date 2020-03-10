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
    private List[][] arr2;

    private Map<Integer, String> station = new HashMap<>();
    private Map<String, List<Integer>> route = new HashMap<>();
    private List<String> routeNameList;
    private Integer n;
    private Integer max = Integer.MAX_VALUE;

    public GoFunc() throws IOException {
        routeNameList = preProcess("static/station.txt", station, "static/route.txt", route);
        n = station.size();
        arr1 = new Integer[n + 1][n + 1];
        arr2 = new ArrayList[n + 1][n + 1];
        initArr();
    }

    public static void main(String[] args) throws IOException {
        new GoFunc();
    }

    public void initArr() {

        //arr1初始化
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr1[i][j] = max;
                if (i == j) {
                    arr1[i][j] = 0;
                    continue;
                }
                for (String routeName : routeNameList) {
                    List<Integer> routeList = route.get(routeName);
                    for (int k = 0; k < routeList.size() - 1; k++) {
                        if (routeList.get(k) == i && routeList.get(k + 1) == j) {
                            arr1[i][j] = 1;
                            arr1[j][i] = 1;
                        }
                    }
                }
            }
        }
        //输出arr1
//        for (int i = 1; i <= n; i++) {
//            System.out.println(i);
//            for (int j = 1; j <= n; j++) {
//                System.out.print(arr1[i][j] + "");
//            }
//            System.out.println();
//        }

        //初始化arr2
        //arr2中的list放起始点
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                arr2[i][j] = new ArrayList();
                arr2[i][j].add(i);
            }
        }

    }



}
