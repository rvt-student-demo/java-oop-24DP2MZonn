package rvt;

public class Diagrams {
    class A implements IA {}
    class B extends A implements IB {}
    class C extends B implements IC {}
    class D {
        IA manslauks;
    }
    class E extends B{}
    interface IA {}
    interface IB {}
    interface IC {}
}