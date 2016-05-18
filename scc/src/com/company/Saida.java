package com.company;

public class Saida extends Evento 
{
    
    Saida (double i, Simulador s, Service serviceType)
    {
        super(i, s, serviceType);
    }

    void executa ()
    {
        serviceType.removeService();
    }

}