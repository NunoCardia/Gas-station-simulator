package com.company;

import java.util.*;


public class Service {
    private int serviceType;
    private int estado;
    private int atendidos;
    private double temp_ult, soma_temp_esp, soma_temp_serv;
    private Vector<Cliente> fila;
    private Simulador s;
    private int n_empregados;
    

    Service (Simulador s, int serviceType, int n_empregados)
    {
    	this.s = s;
        this.serviceType = serviceType;
        this.n_empregados = n_empregados;
        fila = new Vector <Cliente>();
        estado = 0;
        temp_ult = s.getInstante();
        atendidos = 0;
        soma_temp_esp = 0;
        soma_temp_serv = 0;
    }


    public void insereService (Cliente c)
    {
        double media[];
        if (estado < n_empregados)
        { 
            estado ++;
            
            if(serviceType == 2)
            {
                media = Aleatorio.normal(s.getMedia_serv_store(),s.getdesvioPadLoja(),10);
                s.insereEvento (new Saida((s.getInstante()+media[0]),s,this));
            }
            else if(serviceType == 3)
            {
                media = Aleatorio.normal(s.getMedia_serv_station(),s.getdesvioPadEstacaos(),20);
                s.insereEvento (new Saida((s.getInstante()+media[0]),s,this));
            }
            else
            {
                media = Aleatorio.normal(s.getMedia_serv_station(),s.getdesvioPadEstacaos(),30);
                s.insereEvento(new HelperToStore((s.getInstante()+media[0]),s,this));
            }
            
                       
        }
        else fila.addElement(c);
    }


    public Cliente removeService ()
    {
        Cliente c = null;
        double media[];
        atendidos++;
        if (fila.size()== 0)
        {

            estado --;
        } 
        else
        { 

            c = (Cliente)fila.firstElement();
            fila.removeElementAt(0);

            
            if(serviceType == 2)
            {
                media = Aleatorio.normal(s.getMedia_serv_store(),s.getdesvioPadLoja(),10);
                s.insereEvento (new Saida((s.getInstante()+media[0]),s,this));
            }
            else if(serviceType == 3)
            {
                media = Aleatorio.normal(s.getMedia_serv_station(),s.getdesvioPadEstacaos(),20);
                s.insereEvento (new Saida((s.getInstante()+media[0]),s,this));
            }
            else
            {
                media = Aleatorio.normal(s.getMedia_serv_station(),s.getdesvioPadEstacaos(),30);
                s.insereEvento(new HelperToStore((s.getInstante()+media[0]),s,this));
            }
        }
        return c;
    }


    public void act_stats()
    {

        double temp_desde_ult = s.getInstante() - temp_ult;

        temp_ult = s.getInstante();

        soma_temp_esp += fila.size() * temp_desde_ult;

        soma_temp_serv += estado * temp_desde_ult;
    }


    public void relat ()
    {

        double temp_med_fila = soma_temp_esp / (atendidos+fila.size());
        double comp_med_fila = soma_temp_esp / s.getInstante();
        double utilizacao_serv = soma_temp_serv / s.getInstante();
        

        if(serviceType == 2 && s.getCenario() == 1)
        {
            s.label_temp_medio_espera_store.setText(s.label_temp_medio_espera_store.getText()+temp_med_fila);
            s.label_comp_medio_fila_store.setText(s.label_comp_medio_fila_store.getText()+comp_med_fila);
            s.label_util_serv_store.setText(s.label_util_serv_store.getText()+(utilizacao_serv/n_empregados));
            s.label_temp_sim_store.setText(s.label_temp_sim_store.getText()+s.getInstante());
            s.label_n_client_atend_store.setText(s.label_n_client_atend_store.getText()+atendidos);
            s.label_n_client_fila_store.setText(s.label_n_client_fila_store.getText()+fila.size());
        }
        else if(serviceType == 0 && s.getCenario() == 1)
        {
            s.label_temp_medio_espera_gasolina.setText(s.label_temp_medio_espera_gasolina.getText()+temp_med_fila);
            s.label_comp_medio_fila_gasolina.setText(s.label_comp_medio_fila_gasolina.getText()+comp_med_fila);
            s.label_util_serv_gasolina.setText(s.label_util_serv_gasolina.getText()+(utilizacao_serv/n_empregados));
            s.label_temp_sim_gasolina.setText(s.label_temp_sim_gasolina.getText()+s.getInstante());
            s.label_n_client_atend_gasolina.setText(s.label_n_client_atend_gasolina.getText()+atendidos);
            s.label_n_client_fila_gasolina.setText(s.label_n_client_fila_gasolina.getText()+fila.size());
        }
        else if(serviceType == 1 && s.getCenario() == 1)
        {
            s.label_temp_medio_espera_gasoleo.setText(s.label_temp_medio_espera_gasoleo.getText()+temp_med_fila);
            s.label_comp_medio_fila_gasoleo.setText(s.label_comp_medio_fila_gasoleo.getText()+comp_med_fila);
            s.label_util_serv_gasoleo.setText(s.label_util_serv_gasoleo.getText()+(utilizacao_serv/n_empregados));
            s.label_temp_sim_gasoleo.setText(s.label_temp_sim_gasoleo.getText()+s.getInstante());
            s.label_n_client_atend_gasoleo.setText(s.label_n_client_atend_gasoleo.getText()+atendidos);
            s.label_n_client_fila_gasoleo.setText(s.label_n_client_fila_gasoleo.getText()+fila.size());
        }
        else if(serviceType == 3 && s.getCenario() == 2)
        {
            s.label_temp_medio_espera_gasolina.setText(s.label_temp_medio_espera_gasolina.getText()+temp_med_fila);
            s.label_comp_medio_fila_gasolina.setText(s.label_comp_medio_fila_gasolina.getText()+comp_med_fila);
            s.label_util_serv_gasolina.setText(s.label_util_serv_gasolina.getText()+(utilizacao_serv/n_empregados));
            s.label_temp_sim_gasolina.setText(s.label_temp_sim_gasolina.getText()+s.getInstante());
            s.label_n_client_atend_gasolina.setText(s.label_n_client_atend_gasolina.getText()+atendidos);
            s.label_n_client_fila_gasolina.setText(s.label_n_client_fila_gasolina.getText()+fila.size());
        }
        System.out.println("Tempo medio de espera "+temp_med_fila);
        System.out.println("Comp. medio da fila "+comp_med_fila);
        System.out.println("Utilizacao do service "+utilizacao_serv/n_empregados);
        System.out.println("Tempo de simulacao "+s.getInstante());
        System.out.println("Numero de clientes atendidos "+atendidos);
        System.out.println("Numero de clientes na fila "+fila.size());
    }

    public int getAtendidos() 
    {
        return atendidos;
    }

    public int getserviceType()
    {
        return serviceType;
    }
}