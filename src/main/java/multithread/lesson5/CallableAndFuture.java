package multithread.lesson5;

import java.math.BigInteger;
import java.util.concurrent.*;

public class CallableAndFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ExecutorService executorService = Executors.newSingleThreadExecutor();


        /**
         * метод {@link ExecutorService#submit(Callable)} делает то же самое что и
         * {@link ExecutorService#execute(Runnable)}, отличие в том что он в качестве параметра
         * принимает не реализацию Runnable, a Callable- этот интерфейс может что-то вернуть, для как Future<T>
         *
         * Callable, так же как и Runnable, представляет собой определённое задание, которое выполняется потоком.
         * В отличие от Runnable Callable:
         * • имеет return type не void;
         * • может выбрасывать Exception.
         * Метод submit передаёт наше задание (task) в thread pool, для выполнения его одним из потоков,
         * и возвращает тип Future, в котором и хранится результат выполнения нашего задания.

         */
        Future<BigInteger> factorial = executorService.submit(new CallableFactorial(0));


        /**
         * Метод {@link Future#get()} делает почти то же самое что и метод join().
         * Тоже останавливает поток, и дождаться завершения другого потока.
         * Метод get позволяет получить результат выполнения нашего задания из объекта Future
         */
        BigInteger f = factorial.get();
        System.out.println(f);

        executorService.shutdown();

    }

}

class CallableFactorial implements Callable<BigInteger> {

    long factorial;

    public CallableFactorial(long factorial) {
        this.factorial = factorial;
    }

    @Override
    public BigInteger call() throws Exception {
        if (factorial <= 0) throw new Exception("неверное число для факториала");
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= factorial; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}


