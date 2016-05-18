package com.company;

import java.util.*;


public class ListaEventos extends LinkedList<Evento> 
{

    private Simulador s;
    private static final long serialVersionUID = 1;

    ListaEventos (Simulador s)
    {
        this.s = s;
    }

    public void insereEvento (Evento e1)
    {
	int i = 0;
        while (i < size() && ((Evento)get(i)).menor(e1)) i++;
        add(i, e1);
    }

}