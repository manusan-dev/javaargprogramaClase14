package com.mycompany.javaclase14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaClase14 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String archivo = "C:\\Users\\Manuel\\Documents\\NetBeansProjects\\JavaClase14\\src\\main\\java\\com\\mycompany\\javaclase14\\expresiones.txt";
        String expresionRegular = "([a-z]|[0-9])+@[a-z]+\\.[a-z]+";
        
        System.out.println("Punto 1: ");

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            int numeroLinea = 0;
            String linea;
            Pattern patron = Pattern.compile(expresionRegular);
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                Matcher matcher = patron.matcher(linea);
                if (matcher.matches()) {
                    System.out.println("La linea numero " + numeroLinea + " coincide con la expresión");
                } else {
                    System.out.println("La linea " + numeroLinea + " no coincide");
                }

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        
        System.out.println("_______________________________________________________________________________________________________________");

        
         System.out.println("Punto 2: ");
        
        String archivo2 = "C:\\Users\\Manuel\\Documents\\NetBeansProjects\\JavaClase14\\src\\main\\java\\com\\mycompany\\javaclase14\\expresionesgrupo.txt";
        String expresionRegularGrupos = "\\((\\d{3})\\)\\s(\\d{3})-(\\d{4})";

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo2))) {
            int numeroLinea = 0;
            String linea;
            Pattern compilador = Pattern.compile(expresionRegularGrupos);
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                Matcher matcher = compilador.matcher(linea);
                if (matcher.matches()) {
                    System.out.println("La linea numero " + numeroLinea + " del archivo Grupos, coincide con la expresión");
                     System.out.println(linea);
                    for (int i = 1; i <= matcher.groupCount(); i++) {
                       
                        System.out.println("Grupo " + i + ": " + matcher.group(i));
                    }
                } else {
                    System.out.println("La linea numero " + numeroLinea + " del archivo Grupos NO COINCIDE");
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
