package com.tomek.slabiak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.tomek.slabiak.task2.ComputerNetwork;
import com.tomek.slabiak.task2.Edge;
import com.tomek.slabiak.task2.Path;
import com.tomek.slabiak.task2.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ComputerNetworkTest
{

    private  ComputerNetwork computerNetwork;

    @Before
    public void setup(){
        computerNetwork = new ComputerNetwork();
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
    }


    @Test
    public void shouldReturnAppropriatePathBetwenServers()
    {
        Path path = computerNetwork.getPath("1", "7");
        assertEquals(3,path.getServers().size());
        assertEquals(500,path.getCombinedPing());
    }

    @Test
    public void shouldReturnAppropriateEdges() {
        List<Edge> edges = computerNetwork.getEdge(200);
        assertEquals(2, edges.size());
        assertEquals("1", edges.get(0).getFirstServer());
        assertEquals("2", edges.get(0).getSecondServer());
        assertEquals("6", edges.get(1).getFirstServer());
        assertEquals("7", edges.get(1).getSecondServer());
    }

    @Test
    public void shouldReturnAdjacentVertices(){
        Vertex vertex = computerNetwork.getVertex("1");
        assertEquals(3, vertex.getAdjacentVertices().size());
        assertEquals("1",vertex.getIp());
        assertTrue(vertex.getAdjacentVertices().containsKey("2"));
        assertTrue(vertex.getAdjacentVertices().containsKey("3"));
        assertTrue(vertex.getAdjacentVertices().containsKey("4"));
        }

    }
