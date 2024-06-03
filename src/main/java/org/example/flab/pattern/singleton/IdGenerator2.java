package org.example.flab.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/*
    * 싱글턴 패턴 lazy initialization 방식
 */
public class IdGenerator2 {
    private AtomicLong id = new AtomicLong(0L);
    private static IdGenerator2 instance;

    private IdGenerator2() {}
    public static synchronized IdGenerator2 getInstance() {
        if (instance == null) {
            instance = new IdGenerator2();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
