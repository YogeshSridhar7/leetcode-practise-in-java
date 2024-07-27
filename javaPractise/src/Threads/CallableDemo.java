package Threads;

import java.util.concurrent.*;

public class CallableDemo {
    static ExecutorService executorService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableMessage callableMessage = new CallableMessage();
        Future<String > message = executorService.submit(callableMessage);
        System.out.println(message.get().toString());
    }
}

class CallableMessage implements Callable<String> {
    public String call() throws Exception{
        return "Hello World!";
    }
}
