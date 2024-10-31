package org.example;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.soma(2, 3) == 5);
        System.out.println(calculadora.soma(3, 8) == 7);
    }
}