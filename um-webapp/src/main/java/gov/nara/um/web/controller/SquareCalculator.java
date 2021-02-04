package gov.nara.um.web.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {

    private ExecutorService executor = Executors.newFixedThreadPool(2);


    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }


    public Integer calculateNumberSquare(Integer input) throws InterruptedException, ExecutionException {


        Future<Integer> future = new SquareCalculator().calculate(input);

        while(!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = future.get();
        return result;
    }
}