package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;


public class InterfaceSimulador extends JFrame
{
    protected JPanel painelLoja;
    protected JPanel painelGasolina;
    protected JPanel painelGasoleo;
    protected JPanel box_painelLoja;
    protected JPanel box_painelGasolina;
    protected JPanel boxGasoleo;
    protected JPanel mightyPanel;
    protected JLabel label_temp_medio_espera_store;
    protected JLabel label_temp_medio_espera_gasolina;
    protected JLabel label_temp_medio_espera_gasoleo;
    protected JLabel label_comp_medio_fila_store;
    protected JLabel label_comp_medio_fila_gasolina;
    protected JLabel label_comp_medio_fila_gasoleo;
    protected JLabel label_util_serv_store;
    protected JLabel label_util_serv_gasolina;
    protected JLabel label_util_serv_gasoleo;
    protected JLabel label_temp_sim_store;
    protected JLabel label_temp_sim_gasolina;
    protected JLabel label_temp_sim_gasoleo;
    protected JLabel label_n_client_atend_store;
    protected JLabel label_n_client_atend_gasolina;
    protected JLabel label_n_client_atend_gasoleo;
    protected JLabel label_n_client_fila_store;
    protected JLabel label_n_client_fila_gasolina;
    protected JLabel label_n_client_fila_gasoleo;
    protected JButton exit;
    protected JTabbedPane tabbed_pane = new JTabbedPane();


    protected void initComponents(int cenario)
    {
        try
        {int i = 0;
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if (i == 2)
                {
                    UIManager.setLookAndFeel(info.getClassName());

                }
                i++;
            }
        }
        catch (Exception e)
        {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        setTitle("Resultados ");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mightyPanel = new JPanel();
        mightyPanel.setLayout(new BorderLayout());

        painelLoja = new JPanel();
        painelLoja.setLayout(new BorderLayout());

        painelGasolina = new JPanel();
        painelGasolina.setLayout(new BorderLayout());

        painelGasoleo = new JPanel();
        painelGasoleo.setLayout(new BorderLayout());

        exit = new JButton("Sair");


        box_painelLoja = new JPanel();
        box_painelLoja.setLayout(new BoxLayout(box_painelLoja,BoxLayout.PAGE_AXIS));

        label_temp_medio_espera_store = new JLabel("Tempo medio de espera: ");
        box_painelLoja.add(label_temp_medio_espera_store);
        box_painelLoja.add(Box.createVerticalGlue());

        label_comp_medio_fila_store = new JLabel("Comprimento medio da fila: ");
        box_painelLoja.add(label_comp_medio_fila_store);
        box_painelLoja.add(Box.createVerticalGlue());

        label_util_serv_store = new JLabel("Utilizacao do servico: ");
        box_painelLoja.add(label_util_serv_store);
        box_painelLoja.add(Box.createVerticalGlue());

        label_temp_sim_store = new JLabel("Tempo de simulacao: ");
        box_painelLoja.add(label_temp_sim_store);
        box_painelLoja.add(Box.createVerticalGlue());

        label_n_client_atend_store = new JLabel("Numero de clientes atendidos: ");
        box_painelLoja.add(label_n_client_atend_store);
        box_painelLoja.add(Box.createVerticalGlue());

        label_n_client_fila_store = new JLabel("Numero de clientes na fila: ");
        box_painelLoja.add(label_n_client_fila_store);
        box_painelLoja.add(Box.createVerticalGlue());

        painelLoja.add(box_painelLoja,BorderLayout.CENTER);

        box_painelGasolina = new JPanel();
        box_painelGasolina.setLayout(new BoxLayout(box_painelGasolina,BoxLayout.PAGE_AXIS));

        label_temp_medio_espera_gasolina = new JLabel("Tempo medio de espera: ");
        box_painelGasolina.add(label_temp_medio_espera_gasolina,BorderLayout.CENTER);
        box_painelGasolina.add(Box.createVerticalGlue());


        label_comp_medio_fila_gasolina = new JLabel("Comprimento medio da fila: ");
        box_painelGasolina.add(label_comp_medio_fila_gasolina);
        box_painelGasolina.add(Box.createVerticalGlue());

        label_util_serv_gasolina = new JLabel("Utilizacao do servico: ");
        box_painelGasolina.add(label_util_serv_gasolina);
        box_painelGasolina.add(Box.createVerticalGlue());

        label_temp_sim_gasolina = new JLabel("Tempo de simulacao: ");
        box_painelGasolina.add(label_temp_sim_gasolina);
        box_painelGasolina.add(Box.createVerticalGlue());

        label_n_client_atend_gasolina = new JLabel("Numero de clientes atendidos: ");
        box_painelGasolina.add(label_n_client_atend_gasolina);
        box_painelGasolina.add(Box.createVerticalGlue());

        label_n_client_fila_gasolina = new JLabel("Numero de clientes na fila: ");
        box_painelGasolina.add(label_n_client_fila_gasolina);
        box_painelGasolina.add(Box.createVerticalGlue());

        painelGasolina.add(box_painelGasolina,BorderLayout.CENTER);
        boxGasoleo = new JPanel();
        boxGasoleo.setLayout(new BoxLayout(boxGasoleo,BoxLayout.PAGE_AXIS));

        label_temp_medio_espera_gasoleo = new JLabel("Tempo medio de espera: ");
        boxGasoleo.add(label_temp_medio_espera_gasoleo,BorderLayout.CENTER);
        boxGasoleo.add(Box.createVerticalGlue());

        label_comp_medio_fila_gasoleo = new JLabel("Comprimento medio da fila: ");
        boxGasoleo.add(label_comp_medio_fila_gasoleo);
        boxGasoleo.add(Box.createVerticalGlue());

        label_util_serv_gasoleo = new JLabel("Utilizacao do servico: ");
        boxGasoleo.add(label_util_serv_gasoleo);
        boxGasoleo.add(Box.createVerticalGlue());

        label_temp_sim_gasoleo = new JLabel("Tempo de simulacao: ");
        boxGasoleo.add(label_temp_sim_gasoleo);
        boxGasoleo.add(Box.createVerticalGlue());

        label_n_client_atend_gasoleo = new JLabel("Numero de clientes atendidos: ");
        boxGasoleo.add(label_n_client_atend_gasoleo);
        boxGasoleo.add(Box.createVerticalGlue());

        label_n_client_fila_gasoleo = new JLabel("Numero de clientes na fila: ");
        boxGasoleo.add(label_n_client_fila_gasoleo);
        boxGasoleo.add(Box.createVerticalGlue());

        painelGasoleo.add(boxGasoleo,BorderLayout.CENTER);

        if(cenario == 1)
        {
            painelGasoleo.setBorder(BorderFactory.createTitledBorder("Resultados Gasoleo"));
            painelGasoleo.setBackground(Color.GREEN);
            mightyPanel.add(painelGasoleo, BorderLayout.PAGE_START);
            painelGasolina.setBorder(BorderFactory.createTitledBorder("Resultados Gasolina"));
            painelGasolina.setBackground(Color.cyan);
            mightyPanel.add(painelGasolina, BorderLayout.CENTER);
            painelLoja.setBorder(BorderFactory.createTitledBorder("Resultados Loja"));
            painelLoja.setBackground(Color.WHITE);
            mightyPanel.add(painelLoja, BorderLayout.PAGE_END);
            mightyPanel.add(exit,BorderLayout.EAST);
        }
        else if(cenario == 2)
        {

            painelGasolina.setBorder(BorderFactory.createTitledBorder("Reultados SelfService"));
            mightyPanel.add(painelGasolina, BorderLayout.PAGE_START);

        }
        this.add(mightyPanel);
        this.getContentPane().setBackground(Color.pink);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                dispose();
                System.exit(0);

            }
        });
    }


}
