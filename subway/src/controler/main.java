package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dataProcess.importData.preProcess;

public class main {

    public static void main(String[] args) throws IOException {


        //数据预处理
        Map<Integer, String> station = new HashMap<>();
        Map<String, List<Integer>> route = new HashMap<>();
        List<String> routeNameList;
        routeNameList = preProcess("static/station.txt", station, "static/route.txt", route);


        //打开菜单可视化界面
        Menu frame = new Menu(station, route, routeNameList);
        frame.setVisible(true);
    }
}
