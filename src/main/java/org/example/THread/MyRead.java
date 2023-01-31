package org.example.THread;

public class MyRead extends Thread{
    @Override
    public void run() {

        System.out.println("My THread 1 Start");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("My THread 1 Finish");
    }
}
