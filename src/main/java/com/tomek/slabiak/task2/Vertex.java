package com.tomek.slabiak.task2;

import java.util.HashMap;
import java.util.Map;

public class Vertex {

    String ip;
    Map<String, Long> adjacentVertices;

    public Vertex(String ip) {
        this.ip = ip;
        this.adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(String ip, Long ping){
        adjacentVertices.put(ip,ping);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Map<String, Long> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<String, Long> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Server "+ip+" has direct connections with: \n");
        for(String s : adjacentVertices.keySet()){
            sb.append(s+" with ping "+ adjacentVertices.get(s) + "ms \n");
        }
        return sb.toString();
    }
}
