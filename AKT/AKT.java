/*
    Nguyen Tuan Dang
    Faculty of Information Technology, Saigon University
    dangnt@sgu.edu.vn
*/

package AKT;

import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;

public class AKT {

    public static Set<Vertex> visited = new HashSet<Vertex>();
    public static Set<Vertex> destinations = new HashSet<Vertex>();

    public AKT(ArrayList<Vertex> destinations) {
        for (Vertex v : destinations) {
            this.destinations.add(v);
        }
    }

    public void ATSearch(Vertex initialVertex) {

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        initialVertex.setG(0);
        visited.add(initialVertex);
        priorityQueue.add(initialVertex);

        while(!priorityQueue.isEmpty()){

            Vertex currentVertex = priorityQueue.poll();

            if(destinations.contains(currentVertex)) {
                currentVertex.tracePath().printPath();
                break;
            }

            // System.out.print(actualVertex + "(" + actualVertex.getG() + ")" + "\n");

            ArrayList<Vertex> adjacentVertices = currentVertex.getAdjacentVertices();

            for (int i = 0; i < adjacentVertices.size(); i++) {
                Vertex v = adjacentVertices.get(i);

                if(!visited.contains(v)) {
                    v.setG(currentVertex.getG() + v.getD() + v.getH());
                    visited.add(v);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {

        Vertex vertex0 = new Vertex("Oradea");
        Vertex vertex1 = new Vertex("Zerind");
        Vertex vertex2 = new Vertex("Arad");
        Vertex vertex3 = new Vertex("Timisoara");
        Vertex vertex4 = new Vertex("Lugoj");
        Vertex vertex5 = new Vertex("Mehadia");
        Vertex vertex6 = new Vertex("Drobeta");
        Vertex vertex7 = new Vertex("Sibiu");
        Vertex vertex8 = new Vertex("Rimnicu Vilcea");
        Vertex vertex9 = new Vertex("Craiova");
        Vertex vertex10 = new Vertex("Faragas");
        Vertex vertex11 = new Vertex("Pitesti");
        Vertex vertex12 = new Vertex("Bucharest");

        vertex0.addAdjacentVertex(vertex1, 71);
        vertex0.addAdjacentVertex(vertex7, 151);
        vertex1.addAdjacentVertex(vertex2, 75);
        vertex2.addAdjacentVertex(vertex7, 140);
        vertex2.addAdjacentVertex(vertex3, 118);
        vertex3.addAdjacentVertex(vertex4, 111);
        vertex4.addAdjacentVertex(vertex5, 70);
        vertex5.addAdjacentVertex(vertex6, 75);
        vertex6.addAdjacentVertex(vertex9, 120);
        vertex7.addAdjacentVertex(vertex10, 99);
        vertex7.addAdjacentVertex(vertex8, 80);
        vertex8.addAdjacentVertex(vertex9, 146);
        vertex8.addAdjacentVertex(vertex11, 97);
        vertex9.addAdjacentVertex(vertex11, 138);
        vertex10.addAdjacentVertex(vertex12, 211);
        vertex11.addAdjacentVertex(vertex12, 101);
        ArrayList<Vertex> destinations = new ArrayList<Vertex>();

        vertex0.setH(380);
        vertex1.setH(374);
        vertex2.setH(366);
        vertex3.setH(329);
        vertex4.setH(244);
        vertex5.setH(241);
        vertex6.setH(242);
        vertex7.setH(253);
        vertex8.setH(193);
        vertex9.setH(160);
        vertex10.setH(176);
        vertex11.setH(100);
        vertex12.setH(0);
        destinations.add(vertex12);

        AKT at = new AKT(destinations);

        at.ATSearch(vertex2);
    }
}
