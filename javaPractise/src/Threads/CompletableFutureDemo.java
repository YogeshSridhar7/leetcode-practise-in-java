package Threads;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFutureDemo demo = new CompletableFutureDemo();
        demo.calculateFormula(5,5);
        demo.asyncOperation().thenAccept(result -> System.out.println(result)).join();
        demo.usingChaining(2);
        demo.usingCompose();

    }
    private void calculateFormula(int a, int b){
        CompletableFuture<Integer> aSqr = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 1");
           return a*a;
        });
        CompletableFuture<Integer> bSqr = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 2");
            return b*b;
        });
        CompletableFuture<Integer> twoAB = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 3");
            return 2*a*b;
        });
        CompletableFuture<Void> allSum = CompletableFuture.allOf(aSqr,bSqr,twoAB);
        allSum.thenRun(()->{
            System.out.println("Sum operation");
            int result1 = aSqr.join();
            int result2 = bSqr.join();
            int result3 = twoAB.join();
            System.out.println(result1 + result2 + result3);
        });
    }

    private CompletableFuture<String> asyncOperation() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("before sleep");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after sleep");
            return "Hello, world!";
        });
        return future;
    }

    private void usingChaining(int a){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> a)
                .thenApplyAsync(result -> result * 5)
                .thenApplyAsync(result -> result + 5);

        future.thenAccept(result -> System.out.println(result));
    }

    private void usingCompose(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future2 = future1.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        future2.thenAccept(result -> System.out.println(result));
    }
}
