class MinStack {
    Stack<Long> st; 
    long min;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(0L);
            min = val;
        } else{
            st.push(val-min);
            if(val < min)
                min = val;
        }
    }
    
    public void pop() {
        if(st.isEmpty())
            return;
        
        long val = st.pop();
        if(val < 0) 
            min = min-val;
        
    }
    
    public int top() {
        long top = st.peek();
        if(top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
