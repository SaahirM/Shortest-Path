/**
 * File: Edge.java
 * Date: Apr. 10, 2021
 * @author Saahir Monowar
 * Desc: Edge object that acts as one-way link between 
 * 		 two nodes (with an assigned weight)
 */

public class Edge<T> {
	
	//Instance variables
	private Node<T> connectedNode;
	private int weight;

	//Constructor
	public Edge(Node<T> node, int weight) {
		connectedNode = node;
		this.weight = weight;
	}

	//Getters and Setters
	public Node<T> getConnectedNode() {
		return connectedNode;
	}

	public int getWeight() {
		return weight;
	}

	public void setConnectedNode(Node<T> connectedNode) {
		this.connectedNode = connectedNode;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	//Miscellaneous
	
	/**
	 * Returns string representation of object
	 * (formatted as tuple)
	 */
	public String toString() {
		return "(" + connectedNode.getData().toString() +
				", " + weight + ")";
	}


}
