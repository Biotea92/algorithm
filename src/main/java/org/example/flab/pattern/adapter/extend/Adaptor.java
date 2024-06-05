package org.example.flab.pattern.adapter.extend;

public class Adaptor extends Adaptee implements ITarget {
    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        // f2() 재구현
    }

    // fc()를 구현할 필요 없이 Adaptee에서 직접 상속하는 것이 객체 어댑터와의 가장 큰 차이점이다.
}
