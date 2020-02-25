package dataProcess;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private Vertex nextVertex = null;
    public List<Vertex> vertexList = new ArrayList<>();

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }


    public Vertex() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vertex getNextVertex() {
        return nextVertex;
    }

    public void setNextVertex(Vertex nextVertex) {
        this.nextVertex = nextVertex;
    }
}
