package com.example.threads;

class CountingSemaphore {
    private int signals = 0;

    public synchronized void acquire() throws InterruptedException {
        while (signals == 0) {
            wait();
        }
        signals--;
    }

    public synchronized void release() {
        signals++;
        notify();
    }

    public static void main(String[] args) {
        CountingSemaphore semaphore = new CountingSemaphore();

        Thread t1 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 1 acquired");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            semaphore.release();
            System.out.println("Thread 2 released");
        });

        t1.start();
        t2.start();
    }
}
