package edu.utvt.clase1;

public class FormatString {
    public static void main(String[] args) {
        String name = "John Doe";
        String age = "40";
        String message = "Hola" +name+ "con tu edad actual" +age+ ",ya eres mayor de edad";
        System.out.println(message);

        StringBuffer sb = new StringBuffer();
        sb.append("Hola ");
        sb.append(name);
        sb.append("con tu edad actual");
        sb.append(age);
        sb.append("ya eres mayor de edad");
        System.out.println(sb.toString());

        String defaultMessage = "Hola con tu edad actual" +age+ ",ya eres mayor de edad";
    }
}
