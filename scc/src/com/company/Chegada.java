package com.company;

public class Chegada extends Evento 
{

    Chegada (double i, Simulador s, Service serviceType)
    {
        super (i, s, serviceType);
    }

    void executa ()
    {

        serviceType.insereService (new Cliente());
        Double random = RandomGenerator.rand(2);
        if(serviceType.getserviceType() == 3)
        {
            s.insereEvento(new Chegada(s.getInstante()+Aleatorio.exponencial(s.getMedia_cheg()), s,serviceType));
        }

        else
        {
            if(random<0.2)
            {
                s.insereEvento (new Chegada(s.getInstante()+Aleatorio.exponencial(s.getMedia_cheg()), s,s.getservice_gasoleo()));
            }
            else
            {
                s.insereEvento (new Chegada(s.getInstante()+Aleatorio.exponencial(s.getMedia_cheg()), s,s.getservice_gasolina()));
            }
        }
    }

}