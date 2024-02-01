package Data_Structure;
import java.util.Stack;
class PostfixExpressionEvaluator {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for(int i = expression.length()-1;i>=0;i--){
            char  ch = expression.charAt(i);
            if(Character.isDigit(ch)){
                stack.push(ch-'0');
            }
            else{
                int o1 = stack.pop();
                int o2 = stack.pop();

                switch (ch){
                    case '+' :
                        stack.push(o1+o2);
                        break;
                    case '-' :
                        stack.push(o1-o2);
                        break;
                    case '*' :
                        stack.push(o1*o2);
                        break;
                    case '/' :
                        stack.push(o1/o2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String postfixExpression = "+*23*549"; // Example postfix expression: 2 * 3 + 5
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result of the postfix expression is: " + result);
    }
}