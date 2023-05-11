package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class lerArquivo {

    public static LinkedList lerArquivo1() {
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
            ls1.add(linha); // adiciona a linha à lista
        }

        scan.close();
        

        return ls1;
    }

    public static String retornaIdentificacao(String n) {
        String erro = "Não encontrado";
        String identificacao;

        LinkedList arq = lerArquivo1(); //crio uma variavel para ler o metodo lerArquivo1
//        arq = arq.s
        //Iterator it = arq.iterator();
        
        
        for(int i = 0; i < arq.size(); i++){
            String elementoAtual = (String) arq.get(i);
            String texto[] = elementoAtual.split(" ");
            String nome = texto[0];
            String id = texto[1];
            if(elementoAtual.equals(n)){
                return elementoAtual;
            
            }    
        }
        return erro;
        
//        while (it.hasNext()) { //enquanto houver valores dentro da lista
//            String curr = (String) it.next(); //atribuo
//            if (curr.equals(n)) {
//                String identificacao = (String) it.next();
//                return identificacao;
//            }
//        }
//        return erro;
    }
    
    
    public static boolean lerEstreptococos(){ //ler se há um outro estreptococos na fila
        
        LinkedList arq = lerArquivo1();
        
        for(int i = 0; i < arq.size(); i++){
            String elementoAtual = (String) arq.get(i);     // 1 HV1
            String proximoElemento = (String) arq.get(i+1);     //2 EST
            
            String texto[] = elementoAtual.split(" ");
            String textoProximo[] = elementoAtual.split(" ");
            
            String id = texto[0];
            String nome = texto[1];
            
            String idProximo = textoProximo[0];
            
            if(id == idProximo){
                return true;
            }
        }
        return false;
    }
        

//    public static void main(String[] args) {
//        String b = "1 HIV1XPTO";
//        String a = retornaIdentificacao(b);
//        System.out.println(a); // imprime a lista completa
//    }
    

}


    