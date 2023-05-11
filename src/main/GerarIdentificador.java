
package main;

import java.util.Random;


public class GerarIdentificador {
    
        public String gerarIdentificacao(String numero){ //funcao para gerar um identificador para o agente gerado
        Random random = new Random();

        String espaco = " ";
        
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // alfabeto em letras maiúsculas
        StringBuilder palavraAleatoria = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int indice = random.nextInt(alfabeto.length());
            char letra = alfabeto.charAt(indice);
            palavraAleatoria.append(letra);
        }
        
        return numero + espaco + palavraAleatoria.toString();
    }
}
