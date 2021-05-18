package alg311_Proj;

//import java.io.*;
import java.util.*;

public class Graph {
	Colors colors;// enum colors
	private int sizeList;
	private LinkedList<Integer> graph[];

	Graph(int sizeList) {
		this.sizeList = sizeList;
		graph = new LinkedList[sizeList]; // initialise an adjacency list the same size as the number of vertices
		for (int i = 0; i < sizeList; ++i)
			graph[i] = new LinkedList(); // initialise each vertex
	}

	void addEdge(int v1, int v2) {
		graph[v1].add(v2);
		graph[v2].add(v1);
	}

	void print(Colors[] result) {
		for (int i = 0; i < sizeList; i++)
			System.out.println("Vertex " + i + ": " + result[i]);
	}

	// GREEDY APPROACH
	void greedy() {
		Colors result[] = new Colors[sizeList];
		for (int i = 0; i < sizeList; i++)
			result[i] = colors.NA;
		// Assign the first color to first vertex
		result[0] = colors.Blue;

		boolean available[] = new boolean[sizeList];

		// All colors are available except NA
		available[0] = false; // ignore ""
		for (int i = 1; i < sizeList; i++)
			available[i] = true;

		// mark taken colors
		for (int i = 1; i < sizeList; i++) {
			Iterator<Integer> iterator = graph[i].iterator();
			while (iterator.hasNext()) {
				int x = iterator.next();
				if (result[x] != colors.NA)
					available[result[x].ordinal()] = false;

			}

			int color = 1;
			while (color < sizeList) {
				if (available[color]) {
					result[i] = colors.values()[color]; // Assign the found
					break;}
				color++;
			}

			for (int x = 1; x < sizeList; x++)
				available[x] = true;
		}

		print(result);
	}

	// BRUTE FORCE APPROACH
	void bruteForce() {
		Colors result[] = new Colors[sizeList];
		for (int i = 0; i < sizeList; i++)// initialize all colors to NA
			result[i] = colors.NA;
		result[0] = colors.Blue; // start wit the first color in enum Colors = Blue
		boolean solved = false;
		// delete below if using recursion:
		for (int i = 1; i < sizeList; i++)
			for (int j = 1; j < sizeList; j++) {
				if (BruteCheckColor(result, i, colors.values()[j])) {
					result[i] = colors.values()[j];
					solved = true;
					break;
				}
				solved = false;
			}
		if (solved)
			print(result);
	}

	boolean BruteCheckColor(Colors[] res, int vertex, Colors c) {
		for (int j = 0; j < graph[vertex].size(); j++) // we need to check if there's any other vertex connected
			if (res[graph[vertex].get(j)] == c) // to the one passed in the parameter that has the same
				return false; // color as the color c.
		return true;
	}

	

}
