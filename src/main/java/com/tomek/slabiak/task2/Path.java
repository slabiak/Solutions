package com.tomek.slabiak.task2;

import java.util.LinkedList;

public class Path {

    long combinedPing;
    LinkedList<String> servers;

    public Path(long combinedPing, LinkedList<String> servers) {
        this.combinedPing = combinedPing;
        this.servers = servers;
    }

    public long getCombinedPing() {
        return combinedPing;
    }

    public void setCombinedPing(long combinedPing) {
        this.combinedPing = combinedPing;
    }

    public LinkedList<String> getServers() {
        return servers;
    }

    public void setServers(LinkedList<String> servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Path is: \n");
        for (String server : servers) {
            sb.append(server + " > ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(" which takes " + combinedPing + " ms.");
        return sb.toString();
    }
}
