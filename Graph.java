/**
 * File: Graph.java
 * Date: Apr. 10, 2021
 * @author Saahir Monowar
 * Desc: Graph object storing and manipulating an arrayList of nodes.
 * 		 Contains limited methods to manipulate nodes with
 */

import java.util.ArrayList;

public class Graph<T> {
	
	//Instance variables
	private ArrayList<Node<T>> nodes;
	
	//Constructor
	public Graph() {
		nodes = new ArrayList<Node<T>>();
	}
	
	//Getter
	public ArrayList<Node<T>> getNodes() {
		return nodes;
	}
	
	/**
	 * Creates node with given data and adds it to graph
	 * @param data
	 */
	public void addNode(T data) {
		Node<T> node = new Node<T>(data);
		nodes.add(node);
	}
	
	/**
	 * Searches for node containing given item and removes it
	 * @param item 
	 * @return true if found in list of nodes
	 */
	public boolean removeNode(T item) {
		Node<T> node = search(item);
		return nodes.remove(node);
	}
	
	/**
	 * Adds a one-way edge from node containing item 1 to 
	 * node containing item 2 with given weight
	 * @param item1 
	 * @param item2
	 * @param weight
	 */
	public void addDirectedEdge(T item1, T item2, int weight) {
		Node<T> node1 = search(item1);
		Node<T> node2 = search(item2);
		node1.addEdge(node2, weight);
	}
	
	/**
	 * Finds nodes containing given items and disconnects them
	 * @param item1
	 * @param item2
	 * @return true if both edges existed prior to removal
	 */
	public boolean removeEdge(T item1, T item2) {
		Node<T> node1 = search(item1);
		Node<T> node2 = search(item2);
		boolean success1 = node1.removeEdgeWith(node2);
		boolean success2 = node2.removeEdgeWith(node1);
		return success1 && success2;
	}
	
	/**
	 * Searches for and returns node with given item in graph
	 * @param item to search for
	 * @return node with item or null if not found
	 */
	public Node<T> search(T item) {
		if (nodes.isEmpty()) {
			return null; //Empty list
		} else {
			for (Node<T> node : nodes) {
				if (node.getData().equals(item)) {
					return node; //Traversed list and found
				}
			}
			return null; //Traversed list and not found
		}
	}
	
	//Miscellaneous
	/**
	 * Returns string representation of object
	 */
	public String toString() {
		String string = "";
		for (Node<T> node : nodes) {
			string += node.toString() + "\n";
		}
		return string;
	}
	
}