package dataProcess;

import java.util.ArrayList;

/**
 * @ProjectName: subway
 * @Package: dataProcess
 * @ClassName: Node
 * @Author: ZXG
 * @Date: 2020/2/24 22:41
 */
public class Node {


    public Integer name = null;
    public ArrayList<Node> relationNodes = new ArrayList<Node>();

    public Node() {

    }

    public Node(Integer name) {
        this.name = name;
    }

    public Integer getNum() {
        return name;
    }

    public void setNum(Integer name) {
        this.name = name;
    }

    public ArrayList<Node> getRelationNodes() {
        return relationNodes;
    }

    public void setRelationNodes(ArrayList<Node> relationNodes) {
        this.relationNodes = relationNodes;
    }
}
