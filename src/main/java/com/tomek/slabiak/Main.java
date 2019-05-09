package com.tomek.slabiak;

import com.tomek.slabiak.task1.CountAlgorithm;
import com.tomek.slabiak.task2.ComputerNetwork;
import com.tomek.slabiak.task2.Edge;


public class Main {
    public static void main(String[] args) {



        /*
        * Task1:
        * */
        CountAlgorithm algorithm = new CountAlgorithm();
        algorithm.add("cat");
        int catCount = algorithm.count("cat");
        System.out.println("cat count:" + catCount);



        /*
        * Task 2:
        * */

        ComputerNetwork computerNetwork = new ComputerNetwork();
        computerNetwork.addVertex("1");
        computerNetwork.addVertex("2");
        computerNetwork.addVertex("3");
        computerNetwork.addVertex("4");
        computerNetwork.addVertex("5");
        computerNetwork.addVertex("6");
        computerNetwork.addVertex("7");
        computerNetwork.addEdge("1", "2", 200);
        computerNetwork.addEdge("1", "4", 300);
        computerNetwork.addEdge("1", "3", 400);
        computerNetwork.addEdge("4", "5", 150);
        computerNetwork.addEdge("4", "6", 150);
        computerNetwork.addEdge("5", "7", 450);
        computerNetwork.addEdge("3", "7", 100);
        computerNetwork.addEdge("6", "7", 200);


        System.out.println(computerNetwork.getVertex("1"));

        for (Edge e : computerNetwork.getEdge(200)) {
            System.out.println(e);
        }

        System.out.println(computerNetwork.getPath("1", "7"));
    }

}
