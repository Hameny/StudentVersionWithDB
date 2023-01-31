package org.example.THread;

public class MyRead3 extends Thread{
    @Override
    public void run() {
        System.out.println("My THread 3 Start");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("My THread 3 Finish");
    }
}
