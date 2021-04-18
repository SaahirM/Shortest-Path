"""
File: Visualize.py
Date: 17-Apr-2021
@author: Saahir Monowar
Desc: Parses text from an input file to create and display a graph.
	  Uses python's 'networkx' and 'matplotlib' modules
"""

import networkx as nx
import matplotlib.pyplot as plt

# FUNCTIONS
"""
Draws a given graph with specific, pre-determined settings
@param graph: networkx graph to be drawn
@param pos: 'pos' variable from networkx that determines graph layout
"""
def drawGraph(graph, pos):
	# Get weights
	edgeLabels = {}
	allEdges = dict(graph.edges())
	for edge in allEdges:
		temp = allEdges[edge]
		edgeLabels[edge] = temp['weight']
	
	# call nx.draw()
	nx.draw(graph, pos)
	nx.draw_networkx(graph, pos, node_size=1500, node_color='yellow', font_size=24)
	nx.draw_networkx_edge_labels(graph, pos, edge_labels=edgeLabels, font_size=24)  
	plt.show()

# Initialization
inFile = open(input("Enter name of file with graph: "))
N_NODES = int(inFile.readline())
G = nx.Graph()

# INPUT
# Save individual lines to array
inText = []
for line in inFile:
    inText.append(line.split())

# PROCESSING
# Create nodes
for i in range(N_NODES):
    G.add_node(inText[i][0])

# Link them with edges
for i in range(N_NODES):
    Node1 = inText[i][0]
    for j in range(1, int((len(inText[i]) + 1) / 2)):
        Node2 = inText[i][(2 * j) - 1][0:-1]
        weight = int(inText[i][2 * j])
        G.add_edge(Node1, Node2, weight=weight)

# OUTPUT
# Draw (call function)
pos = nx.spring_layout(G)
drawGraph(G, pos)

inFile.close()