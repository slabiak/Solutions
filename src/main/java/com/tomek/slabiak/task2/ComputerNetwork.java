package com.tomek.slabiak.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComputerNetwork {

    private List<String> vertices;
    private List<Edge> edges;

    public ComputerNetwork() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(String ip) {
        vertices.add(ip);
    }

    public void addEdge(String firstServer, String secondServer, long ping) {
        edges.add(new Edge(firstServer, secondServer, ping));
    }

    public Vertex getVertex(String ip) {
        Vertex vertex = new Vertex(ip);
        for (Edge e : edges) {
            if (e.getFirstServer().equals(ip)) {
                vertex.addAdjacentVertex(e.getSecondServer(),e.getPing());
            }
        }
        return vertex;
    }

    public List<Edge> getEdge(long ping) {
        List<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            if (e.getPing() == ping) {
                result.add(e);
            }
        }
        return result;
    }

    public Path getPath(String firstServer, String secondServer) {
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(this.edges);
        dijkstraAlgorithm.execute(firstServer);
        LinkedList<String> servers = dijkstraAlgorithm.getPath(secondServer);
        long combinedPing = dijkstraAlgorithm.getShortestDistance(secondServer);
        return new Path(combinedPing, servers);
    }

}
