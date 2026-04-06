class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        HashMap<Integer,Integer> source = new HashMap<>();
        int[] history = new int[n];
        for(int i = 0; i<edges.length; i++){
            List<Integer> list = graph.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(edges[i][1]);
            graph.put(edges[i][0],list);

            list = graph.getOrDefault(edges[i][1], new ArrayList<>());
            list.add(edges[i][0]);
            graph.put(edges[i][1],list);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int nodesVisited = 0;

        while(q.size() > 0){
            int curNode = q.poll();
            history[curNode] = 1;
            nodesVisited++;
            List<Integer> curList = graph.getOrDefault(curNode,new ArrayList<>());
            for(Integer connection : curList){
                if(source.get(curNode) == connection)
                    continue;
                if(history[connection] == 1)
                    return false;
                q.offer(connection);
                source.put(connection,curNode);
            }
        }
        return nodesVisited == n;
    }
}
