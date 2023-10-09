package org.example;

public class Main {
    public static void main(String[] args) {

        ChangeTime addTime = new ChangeTime();
        String newTime = addTime.addTime("9:13 AM",200);
        System.out.println(newTime);
    }

}