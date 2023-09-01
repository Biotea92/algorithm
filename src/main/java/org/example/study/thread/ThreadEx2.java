package org.example.study.thread;

public class ThreadEx2 {

    public static void main(String[] args) {

        // 쓰레드 생성
//        Thread1 t1 = new Thread1();
//        t1.start();

        // run 메서드만 호출
        Thread1 t2 = new Thread1();
        t2.run();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            throwException();
        }

        public void throwException() {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
