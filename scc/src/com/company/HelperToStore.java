package com.company;

public class HelperToStore extends Evento
{

    public HelperToStore(double i, Simulador s, Service serviceType)
    {
        super(i, s, serviceType);
    }
    
    
    void executa() 
    {
        s.getservice_store().insereService(serviceType.removeService());
    }

    
    
}
