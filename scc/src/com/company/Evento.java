package com.company;

public abstract class Evento 
{

    protected double instante;
    protected Simulador s;
    protected Service serviceType;

    Evento (double i, Simulador s, Service serviceType)
    {
        instante = i;
        this.s = s;
        this.serviceType = serviceType;
    }

    public boolean menor (Evento e1)
    {
	return (instante < e1.instante);
    }

    abstract void executa ();

    public double getInstante() 
    {
        return instante;
    }

    public Service getserviceType()
    {
        return serviceType;
    }

    public void setserviceType(Service serviceType)
    {
        this.serviceType = serviceType;
    }

    
    
    
}