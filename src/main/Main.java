package main;

import AgentePatologico.AgentePatologico;
import classeEspecifica.Covid19;
import classeEspecifica.Escherichia;
import classeEspecifica.Estreptococos;
import classeEspecifica.Giardia;
import classeEspecifica.HIV;
import classeEspecifica.Histoplasma;
import classeGeral.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            System.out.println("As classes que mais aparecem -" + maxFrequencia + " - indivíduos são:");
            for (String classe : classesMaisFrequentes) {
                System.out.println(classe);
            }
        } else {
            System.out.println("A classe que mais aparece -" + maxFrequencia + " - indivíduos é: " + classesMaisFrequentes.get(0));
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
