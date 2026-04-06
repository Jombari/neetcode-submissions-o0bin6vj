class MinStack {
    HashSet<Integer> removed;
    PriorityQueue<Integer> minHeap; 
    Stack<Integer> st; 
    public MinStack() {
        removed = new HashSet<>();
        minHeap = new PriorityQueue<>();
        st = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        minHeap.offer(val);
    }
    
    public void pop() {
        int val = st.pop();
        removed.add(val);

        while(removed.contains(minHeap.peek())){
            int removedVal = minHeap.poll();
            removed.remove(removedVal);
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}
