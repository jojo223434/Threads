package com.example.threads;

class HelloWorldThread extends Thread {
    public void run() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        helloWorldThread thread = new helloWorldThread();
        thread.start();
    }
}
