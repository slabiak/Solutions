package com.tomek.slabiak.task2;

import java.util.*;


public class DijkstraAlgorithm {

    private final List<Edge> edges;
    private Set<String> settledNodes;
    private Set<String> unSettledNodes;
    private Map<String, String> predecessors;
    private Map<String, Long> distance;

    public DijkstraAlgorithm(List<Edge> edges) {
        this.edges = new ArrayList<Edge>(edges);
    }

    public void execute(String source) {
        settledNodes = new HashSet<String>();
        unSettledNodes = new HashSet<String>();
        distance = new HashMap<String, Long>();
        predecessors = new HashMap<String, String>();
        distance.put(source, (long) 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            String node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(String node) {
        List<String> adjacentNodes = getNeighbors(node);
        for (String target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private long getDistance(String node, String target) {
        for (Edge edge : edges) {
            if (edge.getFirstServer().equals(node)
                    && edge.getSecondServer().equals(target)) {
                return edge.getPing();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<String> getNeighbors(String node) {
        List<String> neighbors = new ArrayList<String>();
        for (Edge edge : edges) {
            if (edge.getFirstServer().equals(node)
                    && !isSettled(edge.getSecondServer())) {
                neighbors.add(edge.getSecondServer());
            }
        }
        return neighbors;
    }

    private String getMinimum(Set<String> vertexes) {
        String minimum = null;
        for (String vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(String vertex) {
        return settledNodes.contains(vertex);
    }

    public long getShortestDistance(String destination) {
        Long d = distance.get(destination);
        if (d == null) {
            return Long.MAX_VALUE;
        } else {
            return d;
        }
    }

    public LinkedList<String> getPath(String target) {
        LinkedList<String> path = new LinkedList<String>();
        String step = target;
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }

}