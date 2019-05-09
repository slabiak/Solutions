package com.tomek.slabiak.task2;

import java.util.Objects;

public class Edge {
    private String firstServer;
    private String secondServer;
    private long ping;

    public Edge(String firstServer, String secondServer, long ping) {
        this.firstServer = firstServer;
        this.secondServer = secondServer;
        this.ping = ping;
    }

    public String getFirstServer() {
        return firstServer;
    }

    public void setFirstServer(String firstServer) {
        this.firstServer = firstServer;
    }

    public String getSecondServer() {
        return secondServer;
    }

    public void setSecondServer(String secondServer) {
        this.secondServer = secondServer;
    }

    public long getPing() {
        return ping;
    }

    public void setPing(long ping) {
        this.ping = ping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return ping == edge.ping &&
                Objects.equals(firstServer, edge.firstServer) &&
                Objects.equals(secondServer, edge.secondServer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstServer, secondServer, ping);
    }

    @Override
    public String toString() {
        return firstServer + " > " + secondServer + " with " + ping + " ms.";
    }
}
