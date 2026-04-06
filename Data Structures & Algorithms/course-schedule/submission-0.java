class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preReqCnt = new int[numCourses];
        HashMap<Integer,List<Integer>> courseToDependents = new HashMap<>();
        Queue<Integer> coursesAvailable = new LinkedList<>();
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            preReqCnt[course]++;
            List<Integer> dependents = courseToDependents.getOrDefault(preReq,new ArrayList<>());
            dependents.add(course);
            courseToDependents.put(preReq,dependents);
        }

        for(int i = 0; i<numCourses; i++){
            if(preReqCnt[i] == 0){
                coursesAvailable.offer(i);
            }
        }
        int numTaken = 0;
        while(coursesAvailable.size() > 0){
            int courseTaken = coursesAvailable.poll();
            numTaken++;
            List<Integer> dependents = courseToDependents.getOrDefault(courseTaken,new ArrayList<>());
            for(Integer dep : dependents){
                if(--preReqCnt[dep] == 0)
                    coursesAvailable.offer(dep);
            }
        }
        return numTaken == numCourses;
    }
}
