# Shortest-Path

- Author: Saahir Monowar (@SaahirM)
- Upload Date: 17-Apr-2021

## Desc

A demonstration of Djikra's shortest-path algorithm on a graph. Main program is DjikraDemo.java. Program reads an undirected, connected graph from a text file (formatted as an adjacency list). The program then runs Djikra's algorithm on every node to find the shortest path from every node to every other node on the graph. Meanwhile, it prints the results to the console and 'Output.txt'.

I've also included a python file (Visualize.py) that can read the text file, parse the information, and display the graphs using python's networkx module.

## Input format details

Program reads a graph from a text file.

### Sample input

[This is what valid input looks like:](https://github.com/SaahirM/Shortest-Path/files/6330328/Test.txt)
```
4
A	B, 1 D, 7
B	A, 1 C, 2
C	B, 2 D, 3
D	A, 7 C, 3
```

### Sample input explanation

1. First line: Number of nodes 'n' present on the graph
2. n lines afterward: Name of node, followed by a tab, then its edges and their weights. Connected node separated from edge-weight by a comma and space. Groups of edges separated by just a space.

## Discaimers

Programs assume valid input. Otherwise, things fall apart. Valid input will:
- represent a connected graph (no isolated nodes)
- represent an undirected graph (connections/edges between nodes are two-way)
