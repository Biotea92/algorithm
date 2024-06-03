package org.example.flab.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/*
    * 싱글턴 패턴 holder 방식
 */
public class IdGenerator4 {
    private AtomicLong id = new AtomicLong(0L);

    private IdGenerator4() {}

    private static class SingletonHolder {
        private static final IdGenerator4 instance = new IdGenerator4();
    }

    public static IdGenerator4 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
