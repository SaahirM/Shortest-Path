# Shortest-Path

- Author: Saahir Monowar (@SaahirM)
- Upload Date: 17-Apr-2021

## Desc

A demonstration of Djikra's shortest-path algorithm on a graph. Main program is DjikraDemo.java. Program reads an undirected, connected graph from a text file (formatted as an adjacency list). The program then runs Djikra's algorithm on every node to find the shortest path from every node to every other node on the graph. Meanwhile, it prints the results to the console and 'Output.txt'.

I've also included a python file (Visualize.py) that can read the text file, parse the information, and display the graphs using python's networkx module.

## Input format details

Program reads a graph from a text file.

### Sample input

This is what valid input looks like:
```
4
A	B, 1 D, 7
B	A, 1 C, 2
C	B, 2 D, 3
D	A, 7 C, 3
```
[Click here to download sample input as a text file](https://github.com/SaahirM/Shortest-Path/files/6330328/Test.txt)

[And click here to see the corresponding output for this sample input](https://github.com/SaahirM/Shortest-Path/blob/main/README.md#output-for-sample-input)

### Sample input explanation

1. First line: Number of nodes 'n' present on the graph
2. n lines afterward: Name of node, followed by a tab, then its edges and their weights. Connected node separated from edge-weight by a comma and space. Groups of edges separated by just a space.

## Output information

Program prints information about the shortest path between every node to the console and 'Output.txt'.

For every node in the graph, the program computes the shortest path to every other node. For each of these paths, the program prints the **cost** (cumulated edge weights) and the **next hop** (next node to jump to in order to reach destination).

Here is what output looks like:

```
Source Node: Name1
TO	COST	NEXT HOP
Name2	#	Name3
.
.
.

Source Node: Name2
TO	COST	NEXT HOP
.
.
.

```

Where:
- **Name1, Name2 and Name3** are the names of nodes. Specifically:
  - **Name1** is the name of the node where you start from
  - **Name2** is the name of the node you want to arrive at and
  - **Name3** is the name of the node you should head towards next to get to your destination fastest
- **#** is the cost (aka. minimum cost from Name1 to Name2)
- All entries besides the first are omitted to avoid repetition

## Output for sample input

Here is the output for the [sample input introduced earlier](https://github.com/SaahirM/Shortest-Path/blob/main/README.md#sample-input):

```
Source Node: A
TO	COST	NEXT HOP
A	0	-
B	1	B
C	3	B
D	6	B

Source Node: B
TO	COST	NEXT HOP
B	0	-
A	1	A
C	2	C
D	5	C

Source Node: C
TO	COST	NEXT HOP
C	0	-
B	2	B
D	3	D
A	3	B

Source Node: D
TO	COST	NEXT HOP
D	0	-
C	3	C
B	5	C
A	6	C

```

Additionally, this is how Visualize.py represents the test input: ![Four nodes connected such that their edges form a distorted rectangle](https://user-images.githubusercontent.com/82421572/123171779-965cc100-d452-11eb-9b10-98e045dbf6fd.png)


## Discaimers

Programs assume valid input. Otherwise, things fall apart. Valid input will:
- represent a connected graph (no isolated nodes)
- represent an undirected graph (connections/edges between nodes are two-way)
