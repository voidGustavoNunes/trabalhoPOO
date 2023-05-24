package main;

import classeEspecifica.Covid19;
import classeEspecifica.Escherichia;
import classeEspecifica.Estreptococos;
import classeEspecifica.Giardia;
import classeEspecifica.HIV;
import classeEspecifica.Histoplasma;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        LinkedList listaPatologicos = lerArquivo.lerArquivo1("patologicos.txt"); //cria a lista que armazena objetos do tipo String
        

        int i, dias = 0;
        
        //verificar o paciente
        Paciente paciente = new Paciente();
        
        paciente.setaDadosPaciente(); //pega os dados do arquivo e seta 
        
        //REALIZANDO OS ATAQUES

        for (i = 0; i < listaPatologicos.size(); i++) {
            String elementoAtual = (String) listaPatologicos.get(i); 
            
            String texto[] = elementoAtual.split(" ");

            String codigo = texto[0];

            if (codigo.equals("1")) {
                HIV hiv = new HIV(elementoAtual) {};
                hiv.Atacar();
            }
            else if(codigo.equals("2")){
                Estreptococos estreptococos = new Estreptococos(elementoAtual){};
                estreptococos.Atacar();
            }
            else if(codigo.equals("3")){
                Giardia giardia = new Giardia(elementoAtual){};
                giardia.Atacar();
            }
            else if(codigo.equals("4")){
                Covid19 covid = new Covid19(elementoAtual){};
                covid.Atacar();
            }
            else if(codigo.equals("5")){
                Histoplasma histoplasma = new Histoplasma(elementoAtual){};
                histoplasma.Atacar();
            }
            else if(codigo.equals("6")){
                Escherichia escherichia = new Escherichia(elementoAtual){};
                escherichia.Atacar();
            }
            else{
                System.out.println("Não foi possível identificar qual a classe específica");
            }
            dias++;
        }

        System.out.println("O agente patologico mais presente foi: {}");

    }

}
