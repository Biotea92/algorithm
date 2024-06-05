package org.example.flab.pattern.adapter.object;

public class Adaptor implements ITarget {
    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa(); // Adaptee에 위임
    }

    @Override
    public void f2() {
        // f2() 재구현
    }

    @Override
    public void fc() {
        adaptee.fc(); // Adaptee에 위임
    }
}
