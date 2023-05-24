package main;

import classeEspecifica.Estreptococos;
import classeEspecifica.Histoplasma;
import classeGeral.Bacteria;
import classeGeral.Fungo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ListIterator;

public class lerArquivo {
    //private Histoplasma histoplasma;

    public static LinkedList lerArquivo1(String diretorio) {
        String erro = "Não encontrado";

        FileInputStream fil = null;
        try {
            fil = new FileInputStream(diretorio);
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

        LinkedList arq = lerArquivo1("patologicos.txt"); //crio uma variavel para ler o metodo lerArquivo1
//        arq = arq.s
        //Iterator it = arq.iterator();

        for (int i = 0; i < arq.size(); i++) {
            String elementoAtual = (String) arq.get(i);
            String texto[] = elementoAtual.split(" ");
            String nome = texto[0];
            String id = texto[1];
            if (elementoAtual.equals(n)) {
                return texto[0];

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

    public static boolean lerEstreptococos() { //ler se há um outro estreptococos na fila

        LinkedList lista = lerArquivo1("patologicos.txt");

        for (int i = 0; i < lista.size(); i++) {
            String elementoAtual = (String) lista.get(i);     // 1 HV1
            String proximoElemento = (String) lista.get(i + 1);     //2 EST

            String texto[] = elementoAtual.split(" ");
            String textoProximo[] = elementoAtual.split(" ");

            String id = texto[0];
            String nome = texto[1];

            String idProximo = textoProximo[0];

            if (id == idProximo && id == "2") {
                return true;
            }
        }
        return false;
    }

    public static String retornaIdEstrep() { //Estreptococos
        LinkedList lista = lerArquivo1("patologicos.txt");

        for (int i = 0; i < lista.size(); i++) {
            String elementoAtual = (String) lista.get(i);
            String proximoElemento = (String) lista.get(i + 1);

            String texto[] = elementoAtual.split(" ");
            String textoProximo[] = elementoAtual.split(" ");

            String id = texto[0];
            String nome = texto[1];

            String idProximo = textoProximo[0];

            if (id == idProximo && id == "2") {
                String identificacao = id+" "+texto[1]+textoProximo[1];
                
                return identificacao;
            }
        }
        return null;
        
    }

    public static void verificar_Fila_Histoplasma() {
        LinkedList<Object> lista = lerArquivo1("patologicos.txt"); //e um object pq ele e o pai de todos, se fosse string dava erro nas instancias
        // de fungo e bacteria

        for (int i = 0; i < lista.size() - 1; i++) {
            if ((lista.get(i) instanceof Fungo && lista.get(i + 1) instanceof Bacteria)
                    || //verifica se o anterior e fungo
                    (lista.get(i) instanceof Bacteria && lista.get(i + 1) instanceof Fungo)) { //verifica se o proximo e fungo na lista

                if (lista.get(i + 1).getClass().getSuperclass() == Bacteria.class) {
                    lista.remove(i + 1);
                }
            }
        }
    }

    public static void removerDaLista(String identificacao) {
        LinkedList<String> lista = lerArquivo1("patologicos.txt");

        for (int i = 0; i < lista.size() - 1; i++) {
            if (lista.get(i).equals(identificacao)) {
                lista.remove(i);
            }
        }

    }

    public static void ultimoLista(String identificacao) {
        LinkedList<String> lista = lerArquivo1("patologicos.txt");

        for (int i = 0; i < lista.size(); i++) { //le a lista toda
            String atual = lista.get(i); //armazena o index atual
            if (atual.contains(identificacao)) {  //se achar a identificacao na lista
                lista.remove(i); //remove ela
                lista.add(atual); //joga pro final
                break;
            }
        }

    }

}
