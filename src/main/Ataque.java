/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import AgentePatologico.AgentePatologico;
import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author Gustavo
 */
public class Ataque {

    private LinkedList<AgentePatologico> agentesPatologicos = GeraListaPatologicos.criarListaPatologicos();
    private LinkedList<AgentePatologico> copiaAgentes = new LinkedList<>(agentesPatologicos);

    private AgentePatologico ultimoAgente;
    private int dias;

    public void ataques(Paciente paciente) {
        dias = 0;
        
        while (!agentesPatologicos.isEmpty() && !paciente.verificaPaciente()) {
            Iterator<AgentePatologico> iterator = copiaAgentes.iterator();
            dias++;

            while(iterator.hasNext()) { //!foreach pois estava com erro na exclusao
                AgentePatologico agente = iterator.next();
                ultimoAgente = agente;
                agente.Atacar(agentesPatologicos, paciente);
                
                
                if (agente.getEnergia_Vital() <= 0 && !agente.getClasse_Especifica().equals("HIV")) {
                    
                    //agente.remover(agentesPatologicos); 
                    agentesPatologicos.remove(agente);
                }
                if (paciente.verificaPaciente()) {
                    exibirResultadoMorte();
                    return;
                }

            }
            agentesPatologicos = new LinkedList<>(copiaAgentes);
            //copiaAgentes = agentesPatologicos; ERRO
        }

        exibirResultadoVida();
    }

    private void exibirResultadoMorte() {
        System.out.println("O paciente vai morrer");
        System.out.println("O paciente durou " + dias + " dias");
        System.out.println("O ultimo agente foi o: " + ultimoAgente.getIdentificacao());
    }

    private void exibirResultadoVida() {
        System.out.println("O paciente vai viver");
        System.out.println("A luta durou " + dias + " dias");
        System.out.println("O ultimo agente foi o: " + ultimoAgente.getIdentificacao());
    }

}
