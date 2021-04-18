/**
 * File: DjikraDemo.java
 * Date: Apr. 10, 2021
 * @author Saahir Monowar
 * Desc: Program reads a graph from an input file, then runs Djikra’s-
 * 		 shortest-path algorithm on every node, before printing results
 * 		 to console and Output.txt
 * Note: Program assumes valid input and connected graph
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DjikraDemo {
	public static void main(String[] args) {
		
		//Initialization
		PrintWriter out = null;
		try {
			out = new PrintWriter("Output.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner kb = new Scanner(System.in);
		Scanner in = null;
		Graph<String> graph = new Graph<String>();
		
		//INPUT
		//File
		System.out.println("Enter Input Filename: ");
		File inFile = new File(kb.nextLine());
		try {
			in = new Scanner(inFile);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		final int N_NODES = in.nextInt();
		in.nextLine();
		
		//Save lines into array
		String[][] input = new String[N_NODES][];
		for (int i = 0; i < N_NODES; i++) {
			input[i] = in.nextLine().split("\\s");
		}
		in.close();
		
		//Create nodes
		for (int i = 0; i < N_NODES; i++) {
			String name = input[i][0];
			graph.addNode(name);
		}
		
		//Create edges between them
		for (int i = 0; i < N_NODES; i++) {
			for (int j = 1; j < (input[i].length + 1) / 2; j++) {
				String name = input[i][(2 * j) - 1].split(",")[0]; //Remove comma
				int weight = Integer.valueOf(input[i][2 * j]);
				graph.addDirectedEdge(input[i][0], name, weight);
			}
		}
		
		//PROCESSING
		ArrayList<Node<String>> nodes = graph.getNodes();
		for (int i = 0; i < N_NODES; i++) {
			Node<String> source = nodes.get(i);
			
			//Execute Djikra's algorithm
			ArrayList<Entry<String>> tentative = new ArrayList<Entry<String>>();
			ArrayList<Entry<String>> confirmed = new ArrayList<Entry<String>>();
			Entry<String> entry = new Entry<String>(source, 0, null); //temp var
			confirmed.add(entry);
			Node<String> next = source;
			
			while (true) {
				LinkedList<Edge<String>> neighbours = next.getEdges();
				for (int j = 0; j < neighbours.size(); j++) {
					Node<String> neighbour = neighbours.get(j).getConnectedNode();
					
					//Check if neighbour already in confirmed
					Entry<String> contains = search(confirmed, neighbour);
					if (contains == null) {
						//Compute cost and next hop
						//Cost = cost to next + to neighbour
						entry = search(confirmed, next); //Cost to next
						int cost = entry.getCost() + neighbours.get(j).getWeight();
						Node<String> nextHop;
						if (next.equals(source)) {
							nextHop = neighbour;
						} else {
							nextHop = entry.getNextHop();
						}
						
						//Check if neighbor in tentative list
						contains = search(tentative, neighbour);
						if (contains == null) {
							entry = new Entry<String>(neighbour, cost, nextHop);
							tentative.add(entry);
						} else if (cost < contains.getCost()) {
							tentative.remove(contains);
							entry = new Entry<String>(neighbour, cost, nextHop);
							tentative.add(entry);
						}
						
					}	
				}
				
				//Break condition
				if (tentative.isEmpty()) {
					break;
				} else {
					//Find lowest cost entry in tentative list
					Entry<String> minCost = tentative.get(0);
					for (int j = 1; j < tentative.size(); j++) {
						Entry<String> currCost = tentative.get(j);
						if (currCost.getCost() < minCost.getCost()) {
							minCost = currCost;
						}
					}
					tentative.remove(minCost);
					confirmed.add(minCost);
					next = minCost.getTarget();
				}
			}
			
			//OUTPUT
			String outText = "\n";
			outText += "Source Node: " + source.getData();
			outText += "\nTO\tCOST\tNEXT HOP\n";
			for (int j = 0; j < confirmed.size(); j++) {
				entry = confirmed.get(j);
				outText += entry.getTarget().getData() + "\t"
							+ entry.getCost() + "\t";
				if (entry.getNextHop() != null) {
					outText += entry.getNextHop().getData();
				} else {
					outText += "-";
				}
				outText += "\n";
			}
			System.out.print(outText);
			out.print(outText);
			
		}

		out.close();
		kb.close();
	}
	
	/**
	 * Searches arraylist of entries to check if given node is a target of
	 * one of the entries
	 * @param list
	 * @param item
	 * @return entry with given node as target, or null if not found
	 */
	private static Entry<String> search(ArrayList<Entry<String>> list, Node<String> node) {
		if (list.isEmpty()) {
			return null;
		}
		Entry<String> entry = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTarget().equals(node)) {
				entry = list.get(i);
				break;
			}
		}
		return entry;
	}
}