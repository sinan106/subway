package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dataProcess.importData.preProcess;

public class main {

    public static void main(String[] args) throws IOException {

        Map<Integer, String> station = new HashMap<>();
        Map<String, List<Integer>> route = new HashMap<>();
        List<String> routeNameList;
        routeNameList = preProcess("static/station.txt", station, "static/route.txt", route);




        Menu frame = new Menu(station, route, routeNameList);
        frame.setVisible(true);
    }
}



//    String content = "";
//            for (int i = 0; i < routeNameList.size(); i++) {
//        String routeName = routeNameList.get(i);
//        content += routeName;
//        content += " : ";
//        List<Integer> stationList = route.get(routeName);
//        for (int x : stationList) {
//        String name = station.get(x);
//        content += name;
//        content += "-->";
//        }
//        content = content.substring(0,content.length()-3);
//        content += "\n";
//        textArea1.setText(content);
//        }