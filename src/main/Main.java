package main;


import classeGeral.*;
import java.util.*;

public class Main {

    private static void imprimirClassesMaisFrequentes(String[] classes, int[] frequencias) {
        List<String> classesMaisFrequentes = new ArrayList<>();
        int maxFrequencia = 0;

        for (int i = 0; i < frequencias.length; i++) {
            if (frequencias[i] > maxFrequencia) {
                maxFrequencia = frequencias[i];
                classesMaisFrequentes.clear(); // Limpar a lista de classes mais frequentes
                classesMaisFrequentes.add(classes[i]); // Adicionar a classe atual à lista
            } else if (frequencias[i] == maxFrequencia) {
                classesMaisFrequentes.add(classes[i]); // Adicionar a classe atual à lista
            }
        }

        if (classesMaisFrequentes.size() > 1) {
            System.out.println("As classes que mais aparecem -" + maxFrequencia + " - individuos sao:");
            for (String classe : classesMaisFrequentes) {
                System.out.println(classe);
            }
        } else {
            System.out.println("A classe que mais aparece -" + maxFrequencia + " - individuos e: " + classesMaisFrequentes.get(0));
        }
    }


    public static void main(String[] args) {
        Paciente paciente = new Paciente();
        Ataque ataque = new Ataque();

        paciente.setaDadosPaciente();

        ataque.ataques(paciente);

        int qtBacteria = Bacteria.getQt();
        int qtVirus = Virus.getQt();
        int qtFungo = Fungo.getQt();
        int qtProtozoario = Protozoario.getQt();

        int elementos[] = {qtBacteria, qtFungo, qtVirus, qtProtozoario};
        String[] classes = {"Bacteria", "Fungo", "Virus", "Protozoário"};

        int[] frequencias = {qtBacteria, qtFungo, qtVirus, qtProtozoario};

        //10 pontos
        imprimirClassesMaisFrequentes(classes, frequencias);

    }
}
