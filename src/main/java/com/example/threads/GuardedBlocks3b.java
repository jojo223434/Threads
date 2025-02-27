package com.example.threads;

class SynchronizationWithWaitNotify {
    static int count = 0;
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread incrementThread = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 1_000_000; i++) {
                    count++;
                }
                lock.notify();
            }
        });

        Thread printThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Count value (with sync): " + count);
            }
        });

        incrementThread.start();
        printThread.start();
        incrementThread.join();
        printThread.join();
    }
}
