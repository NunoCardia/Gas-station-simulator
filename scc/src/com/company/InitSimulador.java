package com.company;



import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;


public class InitSimulador 
{

    public static ArrayList <String> run()
    {
        try
        {int i = 0;
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if (i == 2)
                {
                    UIManager.setLookAndFeel(info.getClassName());

                }
             i++;
            }
        }
        catch (Exception e) {

        }





        ArrayList<String> list = new ArrayList<String>();

        JTextField RunTime = new JTextField("1000");
        JTextField arrivalTime = new JTextField("1.2");
        JTextField tempoAtendimentoEstacao = new JTextField("4");
        JTextField desvioPadEstacao = new JTextField("2.5");
        JTextField tempoAtendimentoLoja = new JTextField("1");
        JTextField desvioPadLoja = new JTextField("0.5");
        JTextField n_store = new JTextField("1");
        JTextField nPostosGasolina = new JTextField("2");
        JTextField nPostosGasoleo = new JTextField("1");

        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton cenario1 = new JRadioButton("Cenario 1 -- (Estaçoes)",true);
        JRadioButton cenario2 = new JRadioButton("Cenario 2 -- (Self-Service)",false);


        buttonGroup.add(cenario1);
        buttonGroup.add(cenario2);



        JPanel panel = new JPanel(new GridLayout(0,4));



        //Add things to layout
        panel.add(new JLabel("Tempo"));
        panel.add(RunTime);

        panel.add(new JLabel("Intervalo de chegada"));
        panel.add(arrivalTime);

        panel.add(new JLabel("Estações Tempo medio de atendimento:"));
        panel.add(tempoAtendimentoEstacao);

        panel.add(new JLabel("Desvio Padrao"));
        panel.add(desvioPadEstacao);

        panel.add(new JLabel("Loja: Tempo medio de atendimento"));
        panel.add(tempoAtendimentoLoja);

        panel.add(new JLabel("Loja: Desvio padrao"));
        panel.add(desvioPadLoja);

        panel.add(new JLabel("Loja: Numero de postos"));
        panel.add(n_store);

        panel.add(new JLabel("Gasolina: Numero de postos"));
        panel.add(nPostosGasolina);

        panel.add(new JLabel("Gasoleo: Numero de postos"));
        panel.add(nPostosGasoleo);



        panel.add(cenario1);
        panel.add(cenario2);




        int result = JOptionPane.showConfirmDialog(null, panel,"Bem vindo! Configure o seu simulador",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);


        if(result == JOptionPane.OK_OPTION)
        {
            if(!"".equals(RunTime.getText()) && !"".equals(arrivalTime.getText()) && !"".equals(tempoAtendimentoEstacao.getText()) && !"".equals(tempoAtendimentoLoja.getText()) &&
                    !"".equals(n_store.getText()) && !"".equals(nPostosGasolina.getText()) && !"".equals(nPostosGasoleo.getText()) && !"".equals(desvioPadEstacao.getText()) && !"".equals(desvioPadLoja.getText()))
            {
                list.add(RunTime.getText());
                list.add(arrivalTime.getText());
                list.add(tempoAtendimentoEstacao.getText());
                list.add(tempoAtendimentoLoja.getText());

                list.add(n_store.getText());
                list.add(nPostosGasolina.getText());
                list.add(nPostosGasoleo.getText());

                list.add(desvioPadEstacao.getText());
                list.add(desvioPadLoja.getText());
                try
                {
                    for(int i=0;i<list.size();i++)
                    {
                        Double.parseDouble(list.get(i));
                    }
                }
                catch(Exception e)
                {
                    run();
                }
                if(cenario1.isSelected()==true)
                {
                    list.add("1");
                }
                else if(cenario2.isSelected()==true)
                {
                    list.add("2");
                }

            }
            else
            {
                run();
            }    
            
        }
        else
        {
            System.exit(0);
        }
        return list;
    }
}
