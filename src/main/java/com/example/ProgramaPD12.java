package com.example;

import java.io.IOException;

public class ProgramaPD12 {

    public static <T> void main(String[] args) throws IOException {

        // instanciar curso BasicoIng...
        Conjunto<Alumno> BasicoIng = new Conjunto<>();
        // cargar alumnos del curso BasicoIng desde el archivo “basico-ing.txt”
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\com\\example\\basico-ing.txt");
        String[] linea;
        Nodo<Alumno> nuevoNodo;
        for (String string : archivo) {
            linea = string.split(",");
            nuevoNodo = new Nodo(linea[0], linea[1]);
            BasicoIng.insertar(nuevoNodo);
        }

        // instanciar curso BasicoEmp...
        Conjunto<Alumno> BasicoEmp = new Conjunto<>();
        // cargar alumnos del curso BasicoEmp desde el archivo “basico-emp.txt”
        archivo = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\com\\example\\basico-emp.txt");
        for (String string : archivo) {
            linea = string.split(",");
            nuevoNodo = new Nodo(linea[0], linea[1]);
            BasicoEmp.insertar(nuevoNodo);
        }
        // generar el curso "integrador101" con los alumnos que están en condiciones de
        // cursarlo
        Conjunto<Alumno> integrador101 = BasicoIng.union(BasicoEmp);

        // guardar en un archivo "integrador101.txt" - IDEALMENTE ordenados por código
        // de alumno -

        ManejadorArchivosGenerico.escribirArchivo("integrador101.txt", integrador101.imprimir(",").split(";"));
        // generar el curso "exigente102" con los alumnos que están en condiciones de
        // cursarlo

        Conjunto<Alumno> exigente102 = BasicoIng.interseccion(BasicoEmp);
        ManejadorArchivosGenerico.escribirArchivo("exigente102.txt", exigente102.imprimir(",").split(";"));
        // guardar en un archivo "exigente102.txt" - IDEALMENTE ordenados por código de
        // alumno -

    }

}
