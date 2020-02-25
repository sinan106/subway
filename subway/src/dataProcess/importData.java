package dataProcess;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class importData {


    public static List<String> preProcess(String stationFile, Map<Integer, String> stationMap, String routeFile, Map<String, List<Integer>> routeMap) throws IOException {

        // 读取所有站点，并将其存入HashMap
        File file1 = new File(stationFile);
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        String out1;
        while ((out1 = reader1.readLine()) != null) {

            String[] split = out1.split("\\s+");
            stationMap.put(Integer.valueOf(split[0]), split[1]);
        }
        reader1.close();

        //读取所有线路，每一个线路用一个List<Integer>数组保存，第0个元素表示几号线  -1 是阳逻线
        //所有的路线放在一个List里
        File file2 = new File(routeFile);
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        String out2;
        // 用来存放每条线路的名称
        List<String> routeNameList = new ArrayList<>();
        while ((out2 = reader2.readLine()) != null) {
            String[] split = out2.split("\\s+");
            //route.add(split);
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < split.length; i++) {
                list.add(Integer.valueOf(split[i]));
            }
            routeMap.put(split[0], list);
            routeNameList.add(split[0]);
        }
        reader2.close();

        return routeNameList;
    }
}
