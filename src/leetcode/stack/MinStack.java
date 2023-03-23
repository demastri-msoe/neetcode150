package leetcode.stack;

class MinStack {
    class Node {
        Node next;
        int data;
        int oldMin;
        Node(int data, Node next, int oldMin) {
            this.data = data;
            this.next = next;
            this.oldMin = oldMin;
        }
    }
    Node top;
    int curMin;

    public MinStack() {
        top = null;
        curMin = Integer.MAX_VALUE;
    }

    public void push(int val) {
        top = new Node(val, top, curMin);
        if( val < curMin )
            curMin = val;

    }

    public void pop() {
        if( top != null ) {
            if( top.data == curMin )
                curMin = top.oldMin;
            top = top.next;
        }
    }

    public int top() {
        Node outVal = top;
        return outVal.data;
    }

    public int getMin() {
        return curMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
