package org.example.study.thread;

import java.util.stream.IntStream;

public class ThreadEx8 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread2.setPriority(7);

        System.out.println("thread1.getPriority() = " + thread1.getPriority());
        System.out.println("thread2.getPriority() = " + thread2.getPriority());
        thread1.start();
        thread2.start();


    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("-");
                for (int j = 0; j < 10000000; j++) {

                }
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("|");
                for (int j = 0; j < 10000000; j++) {

                }
            }
        }
    }
}
