/**
 * File: Entry.java
 * Date: Apr. 10, 2021
 * @author Saahir Monowar
 * Desc: Entry object storing a target and next-hop node, as
 * 		 well as an associated cost to get to target node.
 * 		 Used to simplify Djikra’s-shortest-path algorithm
 *		 demonstration in DjikraDemo.java
 */

public class Entry<T> {
	
	//Instance variables
	private Node<T> target;
	private int cost;
	private Node<T> nextHop;

	//Constructor
	public Entry(Node<T> target, int cost, Node<T> nextHop) {
		this.target = target;
		this.cost = cost;
		this.nextHop = nextHop;
	}

	//Getters and Setters
	public Node<T> getTarget() {
		return target;
	}

	public int getCost() {
		return cost;
	}

	public Node<T> getNextHop() {
		return nextHop;
	}

	public void setTarget(Node<T> target) {
		this.target = target;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setNextHop(Node<T> nextHop) {
		this.nextHop = nextHop;
	}
	
	//Miscellaneous
	public String toString() {
		String string = "";
		string += "TO: " + target.getData();
		string += " | COST: " + cost;
		string += " | NH: " + nextHop;
		return string;
	}
}
