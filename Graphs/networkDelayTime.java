class Solution {
    /* 
     Problem: find the delay time for a signal to reach all nodes from an origin node in a directed graph.
     Used Dijkstra's algorithm to find shortest path to each node from the origin node and then find the maximum time
     among all nodes to find the delay time in receving signal.
    */
    public int networkDelayTime(int[][] times, int N, int K) {
        
        // adjacency matrix initialization for a directed graph
        int[][] adj = new int[N][N];
        for(int row = 0; row < N; ++row){
            for(int col = 0; col < N; ++col){
                adj[row][col] = -1; 
            }
        }
        
        // edges with connections u --> v
        for(int i = 0; i < times.length; ++i){  adj[times[i][0] - 1][times[i][1] - 1] = times[i][2]; }
        
        // stores the shortest time in which the node can receive a signal
        int[] time = new int[N];
        for(int i = 0; i < N ; ++i){ time[i] = -1;}
        
      
        int nodeCount = 1;
        Queue<Integer> traverse = new LinkedList<>();
        // zero-indexing
        K = K - 1; 
        traverse.add(K);
        
        // perform BFS 
        while(!traverse.isEmpty()){  
            int node = nodeCount; 
            nodeCount = 0;
            while(node != 0){
                int u = traverse.poll();
                
                for(int v = 0; v < N; ++v){
                    /*
                     Update node time if one of the following holds
                     1) adj[u][v] >= 0  there must be a connection between  u and v
                     2) u != v          avoid cycle to itself
                     3) v != K          avoid cycle back to origin node
                    */
                    
                    if(adj[u][v] >= 0 && u != v && v != K ){
                        /*
                         Additionally,
                         1) if node is never visited before time[v] == -1 
                         2) if there is a better/shortest route from node u to the node v 
                         then update node v's time value 
                        */
                        
                        if(time[v] == -1 || time[v] > (time[u] + adj[u][v]) ){ 
                            time[v] =  (time[u] == -1) ? adj[u][v]: time[u] + adj[u][v];        
                            traverse.add(v);
                            ++nodeCount;
                        }
                    }
                }
                --node;
            }
        }
       
           int totalTime = 0;
           int isolatedNodeCount = 0; // no node connecting 
           for(int i = 0; i < N && isolatedNodeCount  < 2; ++i){
               if(time[i] > totalTime){
                   totalTime = time[i];
               }else if(time[i] == -1){
                   ++isolatedNodeCount ;
               }
           }
        
        return isolatedNodeCount  < 2 ? totalTime : -1;
    }  
  
}
