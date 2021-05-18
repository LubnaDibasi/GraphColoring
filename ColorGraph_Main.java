package alg311_Proj;

import java.util.concurrent.TimeUnit;

public class ColorGraph_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//example #1
		Graph graph1 = new Graph(10);
       graph1.addEdge(0,1); 
 graph1.addEdge(0,3); 
 
 graph1.addEdge(1,0); 
 graph1.addEdge(1,9); 
 
 graph1.addEdge(2,3); 
 graph1.addEdge(2,4); 
 graph1.addEdge(2,5); 
 graph1.addEdge(2,8); 
 
 graph1.addEdge(3,0); 
 graph1.addEdge(3,2); 
 graph1.addEdge(3,8); 
 
 graph1.addEdge(4,2); 
 graph1.addEdge(4,6); 
 graph1.addEdge(4,7); 
 
 graph1.addEdge(5,2); 
 graph1.addEdge(5,9); 
 
 graph1.addEdge(6,4); 
 graph1.addEdge(6,7); 
 graph1.addEdge(6,8); 
 
 graph1.addEdge(7,4); 
 graph1.addEdge(7,6); 
 
 graph1.addEdge(8,2); 
 graph1.addEdge(8,3); 
 graph1.addEdge(8,6); 
 
 graph1.addEdge(9,1); 
 graph1.addEdge(9,5); 
	/*	graph1.addEdge(0, 1);
		graph1.addEdge(0, 2);
		graph1.addEdge(1, 2);
		graph1.addEdge(1, 3);
		graph1.addEdge(1, 4);
		graph1.addEdge(2, 3);
		graph1.addEdge(2, 4);
		graph1.addEdge(3, 4); */

		System.out.println("\nBRUTE FORCE Coloring of graph 1");
		long startTime = System.nanoTime();
		graph1.bruteForce();
		long time = System.nanoTime() - startTime;
		System.out.println("Brute Fore execution time: " + time + " nanoseconds");
		System.out.println("-----------------------------------------------");

		System.out.println("\nGREEDY Coloring of graph 1 ");
		long GrStartTime = System.nanoTime();
		graph1.greedy();
		long GrTime = System.nanoTime() - GrStartTime;
		System.out.println("Greedy execution time: " + GrTime + " nanoseconds");

		System.out.println("-----------------------------------------------");
		System.out.println("-----------------------------------------------");
		
		//example#2
		System.out.println();
		Graph graph2 = new Graph(7);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 3);
		graph2.addEdge(0, 4);
		graph2.addEdge(0, 5);
		graph2.addEdge(1, 2);
		graph2.addEdge(1, 6);
		graph2.addEdge(2, 4);
		graph2.addEdge(2, 5);
		graph2.addEdge(3, 4);
		graph2.addEdge(3, 5);
		graph2.addEdge(4, 5);
		graph2.addEdge(4, 6);
		graph2.addEdge(5, 6);

		System.out.println("\nBRUTE FORCE Coloring of graph 2");
		startTime = System.nanoTime();
		graph2.bruteForce();
		time = System.nanoTime() - startTime;
		System.out.println("Brute Fore execution time: " + time + " nanoseconds");

		System.out.println("-----------------------------------------------");

		System.out.println("\nGREEDY Coloring of graph 2 ");
		GrStartTime = System.nanoTime();
		graph2.greedy();
		GrTime = System.nanoTime() - GrStartTime;
		System.out.println("Greedy execution time: " + GrTime + " nanoseconds");

	}
   
   
   

}
