package org.mabrarov.javaexitcode.javase;

import java.util.concurrent.CountDownLatch;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class Main {

  public static void main(String[] args) {
    final CountDownLatch shutdown = new CountDownLatch(1);
    final Runtime runtime = Runtime.getRuntime();
    runtime.addShutdownHook(new Thread(() -> {
      System.out.println("Shutdown hook called");
    }));
    NotifierSignalHandler notifierSignalHandler = new NotifierSignalHandler(shutdown);
    Signal.handle(new Signal("TERM"), notifierSignalHandler);
    Signal.handle(new Signal("INT"), notifierSignalHandler);
    System.out.println("Press Ctrl+C to exit");
    await(shutdown);
    System.out.println("Main thread is going to stop now");
  }

  private static void await(final CountDownLatch latch) {
    try {
      latch.await();
    } catch (InterruptedException ignored) {
      Thread.currentThread().interrupt();
    }
  }

  private static class NotifierSignalHandler implements SignalHandler {

    private final CountDownLatch notifier;

    public NotifierSignalHandler(final CountDownLatch notifier) {
      this.notifier = notifier;
    }

    @Override
    public void handle(final Signal signal) {
      System.out.println("Signal handler called for " + signal.getName());
      notifier.countDown();
    }
  }

}
