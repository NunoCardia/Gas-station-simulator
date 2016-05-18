package com.company;

import java.util.ArrayList;

public class Simulador extends InterfaceSimulador
{

    private double instante;
    private double media_cheg, media_serv_station;
    private int n_clientes;

    private double desvioPadEstacaos, desvioPadLoja;
    private Service service_gasolina, service_store, service_gasoleo, self_service;
    private ListaEventos lista;
    
    private double instante_final;

    private double media_serv_store;

    private int cenario;
    public Simulador() 
    {
        super();
        ArrayList<String> list = InitSimulador.run();

        media_cheg = Double.parseDouble(list.get(1));
        media_serv_station = Double.parseDouble(list.get(2));
        media_serv_store = Double.parseDouble(list.get(3));
        n_clientes = 100;

        instante = 0;
        this.instante_final = Integer.parseInt(list.get(0));;

        service_gasolina = new Service (this,0,Integer.parseInt(list.get(5)));
        service_store = new Service(this,2,Integer.parseInt(list.get(4)));
        service_gasoleo = new Service(this,1,Integer.parseInt(list.get(6)));
        self_service = new Service(this,3,Integer.parseInt(list.get(4)));

        desvioPadEstacaos = Double.parseDouble(list.get(7));
        desvioPadLoja = Double.parseDouble(list.get(8));

        lista = new ListaEventos(this);
        this.cenario = Integer.parseInt(list.get(9));
        initComponents(this.cenario);
        Double random = RandomGenerator.rand(2);
        if(list.get(9).equals("1"))
        {
            if(random<=0.2)
            {
                insereEvento (new Chegada(instante, this, service_gasoleo));
            }
            else
            {
                insereEvento (new Chegada(instante, this, service_gasolina));
            }
        }
        else
        {
            insereEvento(new Chegada(instante,this,self_service));
        }
    }


    public static void main(String[] args) 
    {

        Simulador s = new Simulador();

        s.executa();
        s.setVisible(true);

    }

    void insereEvento (Evento e1)
    {
        lista.insereEvento (e1);
    }

    private void act_stats()
    {
        service_gasolina.act_stats();
        service_store.act_stats();
        service_gasoleo.act_stats();
        self_service.act_stats();
    }

    private void relat ()
    {
        System.out.println();
        System.out.println("------- Resultados finais -------");
        System.out.println();
        service_gasolina.relat();
        System.out.println();
        service_gasoleo.relat();
        System.out.println();
        service_store.relat();
        System.out.println();
        self_service.relat();
    }


    public void executa ()
    {
        Evento e1;

        while (instante < instante_final)
        {

            e1 = (Evento)(lista.removeFirst());

            instante = e1.getInstante();
            act_stats();
            e1.executa();
        }
        relat();
    }


    public double getInstante()
    {
        return instante;
    }

    public double getMedia_cheg()
    {
        return media_cheg;
    }

    public double getMedia_serv_station()
    {
        return media_serv_station;
    }

    public double getMedia_serv_store()
    {
        return media_serv_store;
    }

    public Service getservice_store()
    {
        return service_store;
    }

    public Service getservice_gasolina()
    {
        return service_gasolina;
    }

    public Service getservice_gasoleo()
    {
        return service_gasoleo;
    }

    public int getCenario()
    {
        return cenario;
    }

    public double getdesvioPadEstacaos() {
        return desvioPadEstacaos;
    }

    public double getdesvioPadLoja() {
        return desvioPadLoja;
    }


}