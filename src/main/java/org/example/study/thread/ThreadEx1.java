package org.example.study.thread;

public class ThreadEx1 {

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();

        Runnable myThread2 = new MyThread2();
        Thread t2 = new Thread(myThread2);

        t1.start();
        t2.start();
    }

    // 쓰레드를 상속받으면 다른 클래스를 상속 받을 수 없다. 그래서 보통은 Runnable인터페이스를 구현한다.
    static class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                // 조상인 Thread의 getName을 호출
                System.out.println("Thread = " + getName());
            }
        }
    }

    static class MyThread2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
//                Thread.currentThread() 현재 실행중인 쓰레드를 반환
                System.out.println("Runnable = " + Thread.currentThread().getName());
            }
        }
    }
}
