package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

    public class currencyConverter extends JFrame{

        //variables here


        public currencyConverter(){
            setTitle("Currency Converter");
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(2, 1));
        }
    }
}