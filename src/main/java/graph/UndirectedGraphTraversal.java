package graph;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.junit.jupiter.api.Test;

/**
 * UndirectedGraphTraversal
 *
 * @author Ritam Das
 * @since 29/01/23
 **/
public class UndirectedGraphTraversal {
    /*
           1----------2
          /            \
         /              \      .6
        0----------------3 .___: \
                          \       \
                           4 ------ 5
   */
  private static List<List<Integer>> generateGraph() {
    int noOfVertices = 7;
    List<List<Integer>> adjacencyList = new ArrayList<>(noOfVertices);
    for (int i = 0; i < noOfVertices; i++)
      adjacencyList.add(new ArrayList<>());

    addEdges(adjacencyList, 0, 1);
    addEdges(adjacencyList, 0, 3);
    addEdges(adjacencyList, 1, 2);
    addEdges(adjacencyList, 2, 3);
    addEdges(adjacencyList, 3, 4);
    addEdges(adjacencyList, 3, 6);
    addEdges(adjacencyList, 4, 5);
    addEdges(adjacencyList, 5, 6);

    return adjacencyList;
  }

  private static void addEdges(List<List<Integer>> adjacentList, int v1, int v2) {
    adjacentList.get(v1).add(v2);
    adjacentList.get(v2).add(v1);
  }

  private List<Integer> breadthFirstTraversal(List<List<Integer>> adjacencyList, int startingNode) {

    // A bit set to keep track of the vertices already visited
    BitSet bitMap = new BitSet(adjacencyList.size());
    List<Integer> result = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();

    // Add the source to processing and mark that vertices as visited
    queue.add(startingNode);
    bitMap.flip(startingNode);

    while(!queue.isEmpty()) {
      int currentVertices = queue.poll();
      result.add(currentVertices);

      // Process the connected vertices of the current vertices by checking the edges,
      // For all the unvisited vertices, enqueue the vertices for processing and mark it in bitmap
      for(int connectedVertices: adjacencyList.get(currentVertices)) {
        if(!bitMap.get(connectedVertices)) {
          queue.add(connectedVertices);
          bitMap.flip(connectedVertices);
        }
      }
    }
    return result;
  }

  private List<Integer> depthFirstTraversal(List<List<Integer>> adjacencyList, int startingNode) {
    BitSet bitMap = new BitSet(adjacencyList.size());
    List<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    stack.push(startingNode);
    bitMap.flip(startingNode);

    while (!stack.isEmpty()) {
      int currentVertices = stack.pop();
      result.add(currentVertices);

      for (int connectedVertices : adjacencyList.get(currentVertices)) {
        if (!bitMap.get(connectedVertices)) {
          stack.add(connectedVertices);
          bitMap.flip(connectedVertices);
        }
      }

    }
    return result;
  }

  @Test
  protected void testGraphTraversal() {
    assertIterableEquals(Arrays.asList(0, 3, 6, 5, 4, 2, 1), depthFirstTraversal(generateGraph(), 0));
    assertIterableEquals(Arrays.asList(0, 1, 3, 2, 4, 6, 5), breadthFirstTraversal(generateGraph(), 0));

  }
}
