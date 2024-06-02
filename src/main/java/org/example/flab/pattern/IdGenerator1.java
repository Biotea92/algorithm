package org.example.flab.pattern;

import java.util.concurrent.atomic.AtomicLong;

/*
    * 싱글턴 패턴 eager initialization 방식
 */
public class IdGenerator1 {
    private AtomicLong id = new AtomicLong(0L);
    private static final IdGenerator1 instance = new IdGenerator1();

    private IdGenerator1() {
        System.out.println("IdGenerator1.IdGenerator1");
    }

    public static IdGenerator1 getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
