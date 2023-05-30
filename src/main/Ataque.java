/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import AgentePatologico.AgentePatologico;
import java.util.LinkedList;
import classeEspecifica.*;
import java.util.Iterator;

/**
 *
 * @author Gustavo
 */
public class Ataque {

    private LinkedList<AgentePatologico> agentesPatologicos = LeituradeArquivo.criarListaPatologicos();
    private LinkedList<AgentePatologico> copiaAgentes = new LinkedList<>(agentesPatologicos);

    private AgentePatologico ultimoAgente;
    private int dias;

    public void ataques(Paciente paciente) {
        dias = 0;

        while (!agentesPatologicos.isEmpty() && !paciente.verificaPaciente()) {
            dias++;
            
            for (AgentePatologico agente : copiaAgentes) {
                agente.Atacar(agentesPatologicos, paciente);

                if (agente.getEnergia_Vital() <= 0 && !agente.getClasse_Especifica().equals("HIV")) {
                    agente.remover(agentesPatologicos);
                    agentesPatologicos.remove(agente);
                }

                if (!paciente.verificaPaciente()) {
                    ultimoAgente = agente;
                } else {
                    exibirResultadoMorte();
                    return;
                }
                
            }
            copiaAgentes = agentesPatologicos;
        }

        exibirResultadoVida();
    }

    private void exibirResultadoMorte() {
        System.out.println("O paciente irá morrer");
        System.out.println("O paciente durou " + dias + " dias");
        System.out.println("O último agente foi o: " + ultimoAgente.getIdentificacao());
    }

    private void exibirResultadoVida() {
        System.out.println("O paciente irá viver");
        System.out.println("A luta durou " + dias + " dias");
        System.out.println("O último agente foi o: " + ultimoAgente.getIdentificacao());
    }

}
