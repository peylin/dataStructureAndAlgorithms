import CITS2200.*;

/**
 * The class SearchImp is a breadth-first search algorithm and depth first search algorithm for directed graphs.
 * 
 * @author Peylin Ng
 * @version 25/04/2018
 */
public class SearchImp implements Search
{

    /**
     * Runs a BFS on a given directed, unweighted graph.
     * 
     * @param  g            the Graph to be searched
     *         startVertex  the vertex on which to start the search
     * 
     * @return     an array listing the parent of each vertex in the spanning tree, 
     *             or -1 if the vertex is not reachable from the start vertex.
     */
    public int[] getConnectedTree (Graph g, int startVertex)
    {
        int size = g.getNumberOfVertices();
        int[] parent = new int[size];
        
        //Making all vertices as "not visited" at the start.
        for (int i = 0; i < size; i++) 
        {
            parent[i] = -1;
        }
        
        //Start a queue
        java.util.Queue<Integer> q;
        q = new java.util.LinkedList<Integer>();
        
        //Add the first element into the queue
        q.offer(startVertex);
        
        //Implement BFS
        while(q.peek() != null)
        {
            int cur = q.remove();
            
            for (int i = 0; i < size; i++)
            {
                if (i == startVertex || i == cur) 
                {
                    continue;
                }
                
                //Storing the parent into the array
                if (g.getWeight(cur,i) >= 1)
                {
                    if (parent[i] == -1)
                    {
                        q.offer(i);
                        parent[i] = cur;
                    }   
                }
            }
        }
        
        return parent;
    }
    
    /**
     * Runs a BFS on a given directed, unweighted graph to find the distances of vertices from the start vertex.
     * 
     * @param  g            the Graph to be searched
     *         startVertex  the vertex on which to start the search
     *         
     * @return     an array listing the distance of each vertex from the start vertex of each, 
     *             or -1 if the vertex is not reachable from the start vertex.
     */
    public int[] getDistances(Graph g, int startVertex)
    {
        int size = g.getNumberOfVertices();
        int[] distance = new int[size];
        
        //Initialising all values in distance to be "-1"
        for (int i = 0; i < size; i++) 
        {
            distance[i] = -1;
        }
        
        //Changing the first element to 0
        distance[startVertex] = 0;
        
        //Start a queue
        java.util.Queue<Integer> q;
        q = new java.util.LinkedList<Integer>();
        
        //Add the first element into queue
        q.offer(startVertex);
        
        //Implement BFS
        while(q.peek() != null)
        {
            int cur = q.remove();
            
            for (int i = 0; i < size; i++)
            {
                if (i == startVertex) 
                {
                    continue;
                }
                
                //calculating distance
                if (g.getWeight(cur,i) >= 1)
                {
                    if (distance[i] == -1)
                    {
                        q.offer(i);
                        distance[i] = distance[cur] + 1;
                    }   
                }
            }
        }
        
        return distance;
    }
    
    /**
     * Runs a DFS on a given directed, unweighted graph.
     * 
     * @param  g            the Graph to be searched
     *         startVertex  the vertex on which to start the search
     *     
     * @return     a 2-dimensional array, where each sub-array has two elements: 
     *             the first is the start time, the second is the end time.
     */
    public int[][] getTimes(Graph g, int startVertex)
    {
        //initialising all the variables needed
        int size = g.getNumberOfVertices();
        int[][] timeStamp = new int[size][2];
        
        int time = 0;
        
        boolean[] visited = new boolean[size];
        
        //Making sure all vertex have been searched through.
        for(int i = 0; i<size; ++i)
        {
            if(visited[i] = false)
            {
                dFSTimer(g, startVertex, visited, timeStamp, time);
            }
        }
        
        return timeStamp;
    }
    
    /**
     * Finds the start time and finish time for each vertex.
     * 
     * @param  g            the Graph to be searched
     *         startVertex  the vertex on which to start the search
     *         visited      the array that keeps track of vertex visited
     *         timeStamp    the start and finish time for each vertex
     *         time         the time
     *     
     */
    public void dFSTimer(Graph g, int curr, boolean[]visited, int[][] timeStamp, int time)
    {
        visited[curr] = true;
        
        int size = g.getNumberOfVertices();
        int[][] adjacent = g.getEdgeMatrix();
        
        //start time
        timeStamp[curr][0] = ++time;
        
        //implementing the dfs search
        for(int i = 0; i < size; ++i)
        {
            if((adjacent[curr][i] > 0) && (visited[i] = false))
            {
                dFSTimer(g, i, visited, timeStamp, time);
            }
        }
        
        //end time
        timeStamp[curr][1] = ++time;
        
    }
}
