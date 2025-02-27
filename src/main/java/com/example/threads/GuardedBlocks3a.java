package com.example.threads;

class NoSynchronization {
    static int count = 0;

    public static void main(String[] args) {
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
        });

        Thread printThread = new Thread(() -> {
            System.out.println("Count value (without sync): " + count);
        });

        incrementThread.start();
        printThread.start();
    }
}
