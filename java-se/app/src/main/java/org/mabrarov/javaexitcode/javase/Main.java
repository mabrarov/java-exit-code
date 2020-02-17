package org.mabrarov.javaexitcode.javase;

import java.util.concurrent.CountDownLatch;

public class Main {

  public static void main(String[] args) {
    final Runtime runtime = Runtime.getRuntime();
    final CountDownLatch completed = new CountDownLatch(1);
    final CountDownLatch shutdown = new CountDownLatch(1);
    runtime.addShutdownHook(new Thread(() -> {
      System.out.println("Shutdown hook called");
      shutdown.countDown();
      await(completed);
      runtime.halt(0);
    }));
    System.out.println("Press Ctrl+C to exit");
    await(shutdown);
    System.out.println("Main thread is going to stop now");
    completed.countDown();
  }

  private static void await(final CountDownLatch latch) {
    try {
      latch.await();
    } catch (InterruptedException ignored) {
      Thread.currentThread().interrupt();
    }
  }

}
