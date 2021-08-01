import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//方式一：继承于Thread类
class MyThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 101; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
//方式二：实现Runnable接口
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 101; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
//方式三：实现Callable接口
class MyCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 101; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return null;
    }
}
public class TwiceTest1 {
    public static void main(String[] args) {

        //方式一
        MyThread myThread = new MyThread();
        myThread.setName("方式一");
        myThread.start();

        //方式二
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.setName("方式二");
        thread.start();

        //方式三
        MyCallable myCallable = new MyCallable();

        FutureTask futureTask = new FutureTask(myCallable);
        Thread thread1 = new Thread(futureTask);
        thread1.setName("方式三");
        thread1.start();

        try{
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}