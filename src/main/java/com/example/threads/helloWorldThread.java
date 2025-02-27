package com.example.threads;

class helloWorldThread extends Thread {
    public void run() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new helloWorldThread().start();
        }
    }
}

