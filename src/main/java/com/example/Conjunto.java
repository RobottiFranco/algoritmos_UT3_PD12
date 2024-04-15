package com.example;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Conjunto<T> extends Lista<T> implements IConjunto {

    @Override
    public Conjunto union(Conjunto otroConjunto) {
        Nodo<T> actual = this.getPrimero();
        Nodo<T> nodoAInsertar;
        Conjunto<T> union = new Conjunto<T>();

        while (actual != null) {
            union.insertar(actual.clonar());
            actual = actual.getSiguiente();
        }

        actual = otroConjunto.getPrimero();

        while (actual != null) {

            nodoAInsertar = union.buscar(actual.getEtiqueta());

            if (nodoAInsertar == null) {
                union.insertar(actual.clonar());
            }
            actual = actual.getSiguiente();
        }
        return union;
    }

    @Override
    public Conjunto interseccion(Conjunto otroConjunto) {
        Nodo<T> actual = this.getPrimero();
        Nodo<T> nodoAInsertar;
        Conjunto<T> interseccion = new Conjunto<T>();

        while (actual != null) {

            nodoAInsertar = otroConjunto.buscar(actual.getEtiqueta());

            if (nodoAInsertar != null) {
                interseccion.insertar(nodoAInsertar.clonar());
            }
            actual = actual.getSiguiente();
        }

        return interseccion;
    }

}
