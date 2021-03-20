import java.util.Stack;

class StackWithIncrementOption{
    public static void main(String[] args) {
        CustomStack cs = new CustomStack(6);
        cs.push(1);
        cs.push(2);
        System.out.println(cs.pop());
        cs.push(2);
        cs.push(3);
        cs.push(4);
        cs.increment(5, 100);
        cs.push(4);
        cs.push(5);
        System.out.println(cs.s);
        cs.increment(2, 100);
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());

    }


}

class CustomStack {
    int[] inc;
    int n;
    Stack<Integer> s;
    public CustomStack(int maxSize) {
        s = new Stack<>();
        n = maxSize;
        inc = new int[n];
    }
    
    public void push(int x) {
        if (s.size() < n){
            s.push(x);
        }
    }
    
    public int pop() {
        int i  = s.size()-1;
        if (i < 0){
            return -1;
        }
        if (i > 0)inc[i-1] += inc[i];
        int res = s.pop() + inc[i];
        inc[i] = 0;
        return res;
    }
    
    public void increment(int k, int val) {
        int index = Math.min(k, s.size()) - 1;
        if (index >= 0)
            inc[index] += val;
    }
}
