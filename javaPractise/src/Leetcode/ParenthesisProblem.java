package Leetcode;

public class ParenthesisProblem {
    public static void main(String[] args) {

        String input = "[{{{((}";
        MyStack myStack =new MyStack();
        boolean isBalanced = true;

        for(char c: input.toCharArray()){
            if(c=='[' || c=='{' || c=='(') {
                myStack.push(c);
            }
            if(c==']' || c=='}' || c==')'){
                if(c==']' && myStack.pop()!='['){
                    isBalanced=false;
                    break;
                }
                else if(c=='}' && myStack.pop()!='{'){
                    isBalanced=false;
                    break;
                }
                else if(c==')' && myStack.pop()!='('){
                    isBalanced=false;
                    break;
                }
            }
        }
        if(isBalanced){
            System.out.println("is balanced");
        }else {
            System.out.println("not balanced");
        }
    }
}

class MyStack {
    private static int MAX=10;
    private static char[] array = new char[MAX];
    private int top = -1;

    public boolean isFull() {
        if (top == MAX) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }
    public char pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return 0;
        }
        return array[top--];
    }

    public void push(char a){
        array[++top] = a;
    }
}
