import java.util.Scanner;
class MyExecption extends RuntimeException{
    public MyExecption(){};
    public MyExecption(String msg){
        super(msg);
    }
}
class UseMyException {
    Integer number = 999999;

    public UseMyException() {
    }

    public void Calculate(int a) throws MyExecption {
        try {
            this.number = this.number + a;
        } catch (MyExecption m) {
            throw new MyExecption("进行计算的必须是数值");
        }
        if (this.number > 2e31 || this.number < 0) {
            throw new MyExecption("已经超出范围");
        }

    }
}

public class TwiceTest2 {
    public static void main(String[] args) {
        UseMyException u1 = new UseMyException();
        try {
            u1.Calculate(2147483647);
        } catch (MyExecption me) {
            System.out.println("MyExecption:" + me.getMessage());
        }
    }
}