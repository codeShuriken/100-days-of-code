import java.util.Map;
import java.util.Stack;
import java.util.HashMap;

class BasicCalculator123{
    public static void main(String[] args) {
        String s1  =  "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate1(s1));

        String s2 = " 3+5 / 2 ";
        System.out.println(calculate2(s2));

        String s3 = "(2+6* 3+5- (3*14/7+2)*5)+3";
        System.out.println(calculate3V2(s3));
    }

    public static int calculate1(String s) {
        Stack<Integer> stk = new Stack<>();
        int num = 0, sign = 1, total = 0;
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                num = num*10 + (c - '0');
            }else{
                switch(c){
                    case '+':
                        total += (num * sign);
                        num = 0;
                        sign  = 1;
                        break;
                    case '-':
                        total += (num * sign);
                        num = 0;
                        sign = -1;
                        break;
                    case '(':
                        stk.push(total);
                        stk.push(sign);
                        total = 0;
                        sign =1;
                        break;
                    case ')':
                        total += (sign * num);
                        num = 0;
                        total *= stk.pop();
                        total += stk.pop();
                        break;
                }
            }
        }

        if (num != 0)total += (sign * num);
        return total;
    }

    public static int calculate2(String s) {
        char curSign = '+';
        int num = 0;
        Stack<Integer> stk = new Stack<>();
        int total = 0;
        for (int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if (Character.isDigit(c))num = num * 10 + (c - '0');
            if (i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')){
                switch(curSign){
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-1 * num);
                        break;
                    case '*':
                        stk.push(stk.pop() * num);
                        break;
                    case '/':
                        stk.push(stk.pop() / num);
                        break;
                }
                curSign = c;
                num = 0;
            }
        }
        
        for (int i : stk)total += i;
        return total;
    }


   
    public static int calculate3V2(String s){
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack  = new Stack<>();
        Map<Character, Integer> map = new HashMap();
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
        int i=0;

        while (i < s.length()){
            if (Character.isDigit(s.charAt(i))){
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i++) - '0');
                }
                numStack.push(num);
                --i;
            }else if (s.charAt(i) == '(')opStack.push('(');
            else if (s.charAt(i) == ')'){
                while (!opStack.isEmpty() && opStack.peek() != '('){
                    doOperation(numStack, opStack);
                }
                opStack.pop();
            }else if (s.charAt(i) != ' '){
                //Key part
                while (!opStack.isEmpty() && opStack.peek() != '(' 
                && map.get(opStack.peek()) >= map.get(s.charAt(i))){
                    doOperation(numStack, opStack);
                }
                opStack.push(s.charAt(i));
            }
            ++i;
        }

        while (!opStack.isEmpty())doOperation(numStack, opStack);
        return numStack.pop();
    }

    private static void doOperation(Stack<Integer> numStack, Stack<Character> opStack) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
         
        char op = opStack.pop();
         
        int ans = 0;
         
        switch(op) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/':
                ans = num1 / num2;
                break;
        }
         
        numStack.push(ans);
    }

}