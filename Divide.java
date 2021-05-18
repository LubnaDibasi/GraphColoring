import java.util.*;
import java.io.*;
public class Divide {
	
		static boolean divide(ArrayList<Node> nodes, int n, int m)
		{
		
			ArrayList<Integer> explored = new ArrayList<Integer>();
			for(int i = 0; i < n + 1; i++)
				explored.add(0);
			
			
		
			int maxColors = 1;
			
		
			for (int sv = 1; sv <= n; sv++)
			{
				if (explored.get(sv) > 0)
					continue;
				
			
				explored.set(sv, 1);
				Queue<Integer> queue = new LinkedList<>();
				queue.add(sv);
				
				while(queue.size() != 0)
				{
					int top = queue.peek();
					queue.remove();
					
					for(int it: nodes.get(top).edges)
					{
					
						if(nodes.get(top).color == nodes.get(it).color)
						{
							nodes.get(it).color += 1;
						}
					
						maxColors = Math.max(maxColors,
											Math.max(nodes.get(top).color,
													nodes.get(it).color));
						if (maxColors > m)
							return false;
					
						if (explored.get(it) == 0)
						{
							explored.set(it, 1);
							queue.remove(it);
						}
					}
					
				}
			}
			return true;
		}

	public static void main (String[] args)
		{
		
		long startTime = System.currentTimeMillis();
		
			int n = 10;
			int [][] graph = 
					{{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, 
					{1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
					{0, 0, 0, 1, 1, 1, 0, 0, 1, 0}, 
					{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
					{0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, 
					{0, 0, 1, 0, 0, 0, 0, 0, 0, 1}, 
					{0, 0, 0, 0, 1, 0, 0, 1, 1, 0}, 
					{0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, 
					{0, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
					{0, 1, 0, 0, 0, 1, 0, 0, 0, 0}};


			int m = 5; // Number of colors
			
			ArrayList<Node> nodes = new ArrayList<Node>();
			
			for(int i = 0; i < n+ 1; i++)
			{
				nodes.add(new Node());
			}
			
		for (int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(graph[i][j] > 0)
				{
					nodes.get(i).edges.add(i);
					nodes.get(j).edges.add(j);
				}
			}
		}
		
            if (divide(nodes, n, m))
			System.out.println("no violating condition could be found while travelling");
            else System.out.println("violation condition");
			long time = System.currentTimeMillis() - startTime;
			System.out.println("The execution time "+time+ "ms");
	} 
	}



