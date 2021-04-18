/**
 * File: Node.java
 * Date: Apr. 10, 2021
 * @author Saahir Monowar
 * Desc: Node object in graph. Stores data and linkedList
 * 		 of edges (connections with other nodes). Contains 
 * 		 limited methods for manipulation of edges
 */

import java.util.LinkedList;

public class Node<T> {
	
	//Instance variables
	private T data;
	private LinkedList<Edge<T>> edges;

	//Constructor
	public Node(T data) {
		this.data = data;
		edges = new LinkedList<Edge<T>>();
	}
	
	//Getters and Setters
	public T getData() {
		return data;
	}
	
	public LinkedList<Edge<T>> getEdges() {
		return edges;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Adds node to list of all edges for this node, 
	 * unless edge already exists
	 * @param node to add
	 */
	public void addEdge(Node<T> node, int weight) {
		Edge<T> edge = new Edge<T>(node, weight);
		if (edges.contains(edge)) {
			System.out.println("Error: Edge already exists");
		} else if (edge != null) {
			edges.add(edge);
		}
	}
	
	/**
	 * Removes given node from list of nodes
	 * @param node to remove
	 * @return true if node was in list of edges
	 */
	public boolean removeEdgeWith(Node<T> node) {
		Edge<T> edge = new Edge<T>(node, 0);
		return edges.remove(edge);
	}
	
	/**
	 * Returns string representation of object
	 */
	public String toString() {
		String string = "";
		string += "Node: " + data.toString();
		string += " | Edges: ";
		for (Edge<T> edge : edges) {
			string += edge.toString() + " ";
		}
		return string;
	}

}
