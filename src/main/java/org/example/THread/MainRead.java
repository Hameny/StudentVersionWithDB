package org.example.THread;

public class MainRead {
    public static void main(String[] args) throws InterruptedException {
        MyRead myRead = new MyRead();
        Myread2 myread2 = new Myread2();
        MyRead3 myRead3 = new MyRead3();
        myRead.start();
        myRead.join();
        myread2.start();
        myread2.join();
        myRead3.start();
        myRead3.join();
        System.out.println("Main");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
