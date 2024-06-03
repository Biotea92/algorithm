package org.example.flab.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/*
    * 싱글턴 패턴 double-checked locking 방식
 */
public class IdGenerator3 {
    private AtomicLong id = new AtomicLong(0L);
    private static IdGenerator3 instance;

    private IdGenerator3() {}

    public static IdGenerator3 getInstance() {
        if (instance == null) {
            synchronized (IdGenerator3.class) { // 클래스 레벨의 잠금처리
                if (instance == null) {
                    instance = new IdGenerator3();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
