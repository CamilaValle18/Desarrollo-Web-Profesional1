package edu.utvt.clase1;

import java.util.Scanner;

public class inputs {
    public static void main(String[] args) {
        String name;
        int age;
        String message ="Hola %s, tu edad es %s";
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        name = sc.nextLine();
        System.out.println("Ingrese el edad: ");
        age = sc.nextInt();
        sc.close();
        String finalMessage = String.format(message, name, age);
        System.out.println(finalMessage);
    }
}
