package com.example.threads;

class helloworldthread extends Thread {
    private int threadNumber;

    public helloworldthread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void run() {
        System.out.println("Hello world from thread " + threadNumber);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new helloworldthread(i + 1).start();
        }
    }
}
