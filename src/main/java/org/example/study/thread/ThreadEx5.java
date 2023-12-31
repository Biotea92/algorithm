package org.example.study.thread;

public class ThreadEx5 {

    static long startTime = 0;

    public static void main(String[] args) {
        Thread1 th1 = new Thread1();
        th1.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }

        System.out.println("소요시간1 : " + (System.currentTimeMillis() - ThreadEx5.startTime));
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.printf("%s", new String("|"));
            }

            System.out.println("소요시간2 : " + (System.currentTimeMillis() - ThreadEx5.startTime));
        }

    }
}
