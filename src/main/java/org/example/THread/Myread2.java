package org.example.THread;

public class Myread2 extends Thread{
    @Override
    public void run() {
        System.out.println("My THread 2 Start");
        try {
            sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("My THread 2 Finish");
    }
}
