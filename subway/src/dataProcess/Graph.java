package dataProcess;


public class Graph {

    public Vertex[] vertex;
    private Integer verNum;
    private Integer edgeNum;

    public Graph(Integer verNum, Integer edgeNum) {

        this.verNum = verNum;
        this.edgeNum = edgeNum;
        vertex = new Vertex[verNum];
    }

    public Vertex getVertex(String name) {
        for(Vertex v : vertex){
            if(v.getName().equals(name)){
                return v;
            }
        }
        return null;
    }


    public void setVertex(Vertex[] vertex) {
        this.vertex = vertex;
    }

    public Integer getVerNum() {
        return verNum;
    }

    public void setVerNum(Integer verNum) {
        this.verNum = verNum;
    }

    public Integer getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(Integer edgeNum) {
        this.edgeNum = edgeNum;
    }
}
