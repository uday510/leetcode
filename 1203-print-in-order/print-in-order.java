class Foo {

    AtomicInteger num1 = new AtomicInteger(0);
    AtomicInteger num2 = new AtomicInteger(0);
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        num1.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (num1.get() < 1) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        num2.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (num2.get() < 1) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}