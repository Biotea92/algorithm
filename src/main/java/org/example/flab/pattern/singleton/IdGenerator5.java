package org.example.flab.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/*
    * 싱글턴 패턴 enum 방식
 */
public enum IdGenerator5 {
    INSTANCE;

    private AtomicLong id = new AtomicLong(0L);

    public long getId() {
        return id.incrementAndGet();
    }
}
