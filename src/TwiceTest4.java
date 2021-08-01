import java.util.Scanner;

class Stack {
    private int maxSize;
    private int[] stack;
    private int top = -1;


    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }


    int peek(){
        return stack[top];
    }


    boolean isEmpty() {
        return top == -1;
    }


    boolean isFull() {
        return top == maxSize - 1;
    }


    void push(int val){
        if(isFull()){
            System.out.println("栈已满~~");
            return;
        }
        top++;
        stack[top] = val;

    }


    int pop() {

        if(isEmpty()) {

            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top--;
        return value;
    }


    private boolean isExist(int element){
        if(isEmpty()){
            System.out.println("栈空无元素");
            return false;
        }

        for (int i = top; i >= 0;i--){
            if(element == stack[i]) return true;
        }
        return false;
    }
}
class ExecChange {
    /**
     *
     * num 为 待转换 的值 ，target 为转换进制
     *   方法： 第一位（最小位） 要 用 num % target ；
     *   之后的 位  依次 num / target 然后 % target
     *
     */

    private int num;
    private int target;


    Stack stack = new Stack(100000000);

    public ExecChange(int num, int target) {
        this.num = num;
        this.target = target;
    }

    public void changeNum(int num, int target){
        if(num==0){
            System.out.println(0);
        } else{
            while(num!=0){
                stack.push(num % target);
                num /= target;
            }
            while (!stack.isEmpty()) {
                if(stack.peek()==10) {
                    System.out.print("A");
                    int a = stack.pop();
                }else if(stack.peek()==11){
                    System.out.print("B");
                    int a = stack.pop();
                }else if(stack.peek()==12){
                    System.out.print("C");
                    int a = stack.pop();
                }else if(stack.peek()==13){
                    System.out.print("D");
                    int a = stack.pop();
                }else if(stack.peek()==14){
                    System.out.print("E");
                    int a = stack.pop();
                }else if (stack.peek()==15){
                    System.out.print("F");
                    int a = stack.pop();
                }else{
                    System.out.print(stack.pop());
                }
            }
        }
    }
}

public class TwiceTest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("在此输入待转换数字 ：");
        int num = scanner.nextInt();
        System.out.println("请输入想要转换的进制(2/4/8/16) ：");
        int target = scanner.nextInt();
        System.out.println("转换结果如下： ");
        ExecChange execChange = new ExecChange(num, target);
        execChange.changeNum(num,target);
    }
}
