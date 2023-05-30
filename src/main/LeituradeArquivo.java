/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import AgentePatologico.AgentePatologico;
import classeEspecifica.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class LeituradeArquivo {

    public static LinkedList criarListaPatologicos() {
        LinkedList agentePatologico = new LinkedList();

        String erro = "Não encontrado";

        FileInputStream fil = null;
        try {
            fil = new FileInputStream("patologicos.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possível abrir o arquivo");
        }

        Scanner scan = new Scanner(fil); //scaneia o arquivo atribuindo a variavel scan
        LinkedList ls1 = new LinkedList(); //cria a lista

        while (scan.hasNextLine()) { //enquanto tiver dado a ser lido no arquivo
            String linha = scan.nextLine(); //scaneia a posição e atribui a variável linha
            String[] partes = linha.split(" "); //codigo para pegar o identificador da classe

            String codigo = partes[0];
            String id = partes[1];

            ls1.add(linha); // adiciona a linha à lista

            if (codigo.equals("1")) {
                AgentePatologico agente = new HIV(linha) {
                    @Override
                    public void remover(LinkedList<AgentePatologico> listaPatologicos) {
                    }
                };
                agentePatologico.add(agente);

            } else if (codigo.equals("2")) {
                AgentePatologico agente = new Estreptococos(linha) {
                    @Override
                    public void remover(LinkedList<AgentePatologico> listaPatologicos) {
                       
                    }
                };
                agentePatologico.add(agente);

            } else if (codigo.equals("3")) {
                AgentePatologico agente = new Giardia(linha) {
                    @Override
                    public void remover(LinkedList<AgentePatologico> listaPatologicos) {
                        
                    }
                };
                agentePatologico.add(agente);

            } else if (codigo.equals("4")) {
                AgentePatologico agente = new Covid19(linha) {
                };
                agentePatologico.add(agente);
            } else if (codigo.equals("5")) {
                AgentePatologico agente = new Histoplasma(linha) {
                    @Override
                    public void remover(LinkedList<AgentePatologico> listaPatologicos) {
                        
                    }
                };
                agentePatologico.add(agente);

            } else if (codigo.equals("6")) {
                AgentePatologico agente = new Escherichia(linha) {
                    @Override
                    public void remover(LinkedList<AgentePatologico> listaPatologicos) {
                        
                    }
                };
                agentePatologico.add(agente);
            }
        }

        scan.close();

        return agentePatologico;

    }

}
