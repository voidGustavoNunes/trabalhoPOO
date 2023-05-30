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

    public static void imprimirClassesMaisFrequentes(String[] classes, int[] frequencias) {
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

        Escherichia escherichia = new Escherichia() {
        };
        Estreptococos estreptococos = new Estreptococos() {
        };
        Histoplasma histoplasma = new Histoplasma() {
        };

        Paciente paciente = new Paciente();

        LinkedList<String> listaPatologicos = lerArquivo1("patologicos.txt");
        LinkedList listaPaciente = new LinkedList(paciente.criaListaPaciente());

        LinkedList<AgentePatologico> agentesInstanciados = new LinkedList<>();
        LinkedList<String> copiaAgentesInstanciados = new LinkedList<>();
        
        LinkedList<String> listaPatologicosCopia = new LinkedList<>(listaPatologicos);

        int dias = 0;

        paciente.setaDadosPaciente();

        while (!listaPatologicos.isEmpty() && paciente.verificaPaciente() == false) { //enquanto a lista não está vazia ou se o paciente não morreu
            dias++;

            Iterator<String> iterator = listaPatologicosCopia.iterator();

            while (iterator.hasNext()) {

                String elementoAtual = iterator.next();

                String[] partes = elementoAtual.split(" "); //codigo para pegar o identificador da classe
                String codigo = partes[0];

                boolean agenteJaInstanciado = false;
                AgentePatologico agenteEncontrado = null;

                for (AgentePatologico agente : agentesInstanciados) { //para cada agente da lista de agentesInstanciados(que vão atacar)
                    if (agente.getIdentificacao().equals(elementoAtual)) {
                        agenteJaInstanciado = true;
                        agenteEncontrado = agente;
                        agente.Atacar(listaPatologicos);
                        agentesInstanciados.addFirst(agente);// Adicionar o agente no início da lista
                        copiaAgentesInstanciados.addFirst(agente.getIdentificacao());
                        break;
                    }
                }

                if (!agenteJaInstanciado) { //se o agente nunca foi instanciado 
                    AgentePatologico novoAgente;

                    if (codigo.equals("1")) {
                        novoAgente = new HIV(elementoAtual) {
                            @Override
                            public void Atacar(LinkedList<String> listaPatologicos) {
                                int leucocitos = paciente.getQntde_Leucocitos();
                                int celulasK = paciente.getQntde_K();
                                int celulasT = paciente.getQntde_CelulasT();

                                //ATAQUE DO HIV
                                paciente.setQntde_K(celulasK - 5);
                                paciente.setQntde_Leucocitos(leucocitos - 10);
                                paciente.setQntde_CelulasT(celulasT - 3);

                                //CONTRA ATAQUE
                                double contrataque = paciente.ContraAtaque();
                                setEnergia_Vital((int) contrataque);

                                if (getEnergia_Vital() < 0) {
                                    setEnergia_Vital(0);

                                }

                                if (paciente.getQntde_K() <= 0 || paciente.getQntde_Leucocitos() <= 0 || paciente.getQntde_CelulasT() <= 0) {

                                    System.out.println("=========================================================");
                                    System.out.println("Quem está atacando é o HIV, tenho " + getEnergia_Vital() + "de energia vital e o paciente irá morrer ao meu ataque");
                                    System.out.println("=========================================================\n\n");

                                }
                            }
                        };
                    } else if (codigo.equals("2")) {
                        novoAgente = new Estreptococos(elementoAtual) {
                            @Override
                            public void Atacar(LinkedList<String> listaPatologicos) {
                                boolean estreptococosFila;
                                estreptococosFila = estreptococos.lerEstreptococos(copiaAgentesInstanciados);

                                int celulasK = paciente.getQntde_K();
                                int hemacias = paciente.getQntde_Hemacias();

                                if (estreptococosFila == true) {
                                    String idEstrepNovo = estreptococos.retornaIdEstrep(copiaAgentesInstanciados);
                                    listaPatologicos.add(idEstrepNovo);  //TESTAR
                                    
                                    listaPatologicosCopia.removeAll(listaPatologicosCopia);
                                    listaPatologicosCopia.addAll(listaPatologicos);
                                    
                                    
                                }

                                paciente.setQntde_Hemacias(hemacias - 10);
                                paciente.setQntde_K(celulasK - 3);

                                //CONTRA ATAQUE DO PACIENTE
                                double contraAtaque = paciente.ContraAtaque();
                                setEnergia_Vital(getEnergia_Vital() - (int) contraAtaque);

                                if (getEnergia_Vital() < 0) {
                                    setEnergia_Vital(0);

                                }

                                if (paciente.getQntde_K() <= 0 || paciente.getQntde_Hemacias() <= 0) {
                                    System.out.println("=========================================================");
                                    System.out.println("Quem está atacando é o Estreptococos, tenho " + getEnergia_Vital() + "de energia vital e o paciente irá morrer ao meu ataque");
                                    System.out.println("=========================================================\n\n");

                                }
                            }

                        };
                    } else if (codigo.equals("3")) {
                        novoAgente = new Giardia(elementoAtual) {
                            @Override
                            public void Atacar(LinkedList<String> listaPatologicos) {
                                final int RECUPERA = 50;

                                int celulasK = paciente.getQntde_K();
                                int celulasT = paciente.getQntde_CelulasT();

                                int hemacias = paciente.getQntde_Hemacias();
                                int leucocitos = paciente.getQntde_Leucocitos();
                                int energia_Vital = getEnergia_Vital();

                                boolean p = paciente.verificaPaciente();
                                String identificacao = getIdentificacao();

                                //============ ATAQUE DA GIARDIA ===================
                                paciente.setQntde_K(celulasK - 9);
                                paciente.setQntde_CelulasT(celulasT - 8);

                                // ============ CONTRA ATAQUE DO PACIENTE ===================
                                double contraAtaque = paciente.ContraAtaque();
                                this.setEnergia_Vital((int) contraAtaque - energia_Vital);
                                if (getEnergia_Vital() < 0) {
                                    this.setEnergia_Vital(0);

                                }

                                if ((leucocitos * 2) < hemacias) {
                                    this.setEnergia_Vital(energia_Vital + RECUPERA);
                                }

                                if (paciente.getQntde_K() <= 0 || paciente.getQntde_CelulasT() <= 0) {
                                    System.out.println("=========================================================");
                                    System.out.println("Quem está atacando é a Giardia, tenho " + getEnergia_Vital() + "de energia vital e o paciente irá morrer ao meu ataque");
                                    System.out.println("=========================================================\n\n");

                                }

                            }
                        };
                    } else if (codigo.equals("4")) {
                        novoAgente = new Covid19(elementoAtual) {
                            @Override
                            public void Atacar(LinkedList<String> listaPatologicos) {
                                int energia_Vital = getEnergia_Vital();

                                String identificacao1 = getIdentificacao();

                                int celulasT = paciente.getQntde_CelulasT();
                                int hemacias = paciente.getQntde_Hemacias();
                                int leucocitos = paciente.getQntde_Leucocitos();

                                //ATAQUE DA COVID
                                paciente.setQntde_Leucocitos(leucocitos - 10);
                                paciente.setQntde_CelulasT(celulasT - 2);
                                paciente.setQntde_Hemacias(hemacias - 15);

                                //CONTRA ATAQUE PACIENTE
                                double contraAtaque = paciente.ContraAtaque();
                                setEnergia_Vital((energia_Vital - (int) contraAtaque));

                                if (getEnergia_Vital() < 0) {
                                    setEnergia_Vital(0);

                                }

                                //SEGUNDO ATAQUE
                                if (hemacias < 200) {
                                    paciente.setQntde_Leucocitos(leucocitos - 10);
                                    paciente.setQntde_CelulasT(celulasT - 2);
                                    paciente.setQntde_Hemacias(hemacias - 15);

                                    //SEGUNDO CONTRA ATAQUE
                                    double contraAtaque2 = paciente.ContraAtaque();
                                    setEnergia_Vital((energia_Vital - (int) contraAtaque2));

                                    if (getEnergia_Vital() < 0) {
                                        setEnergia_Vital(0);

                                    }
                                }
                                if (paciente.getQntde_Hemacias() <= 0 || paciente.getQntde_CelulasT() <= 0 || paciente.getQntde_Hemacias() <= 0) {
                                    System.out.println("=========================================================");
                                    System.out.println("Quem está atacando é o Covid19, tenho " + getEnergia_Vital() + "de energia vital e o paciente irá morrer ao meu ataque");
                                    System.out.println("=========================================================\n\n");

                                }

                            }
                        };
                    } else if (codigo.equals("5")) {
                        novoAgente = new Histoplasma(elementoAtual) {
                            @Override
                            public void Atacar(LinkedList<String> listaPatologicos) {

                                int hemacias = paciente.getQntde_Hemacias();
                                int energiaH = getEnergia_Vital();

                                boolean p = paciente.verificaPaciente();

                                paciente.setQntde_Hemacias(hemacias - 50);

                                histoplasma.verificar_Fila_Histoplasma(listaPatologicos);//validacao fila

                                double contraataque = paciente.ContraAtaque();
                                setEnergia_Vital(energiaH - (int) contraataque);

                                if (energiaH < 0) {
                                    setEnergia_Vital(0);
                                }

                                if (paciente.getQntde_Hemacias() <= 0) {
                                    System.out.println("=========================================================");
                                    System.out.println("Quem está atacando é o Histoplasma, tenho " + getEnergia_Vital() + "de energia vital e o paciente irá morrer ao meu ataque");
                                    System.out.println("=========================================================\n\n");

                                }

                            }
                        };
                    } else if (codigo.equals("6")) {
                        novoAgente = new Escherichia(elementoAtual) {
                            @Override
                            public void Atacar(LinkedList<String> listaPatologicos) {
                                int energiaVitalAntesAtaque = getEnergia_Vital();

                                boolean p = paciente.verificaPaciente();

                                int celulasT = paciente.getQntde_CelulasT();
                                int hemacias = paciente.getQntde_Hemacias();
                                int leucocitos = paciente.getQntde_Leucocitos();
                                int celulasK = paciente.getQntde_K();

                                int energiaVital = getEnergia_Vital();

                                String identificacao1 = getIdentificacao();

                                paciente.setQntde_CelulasT(celulasT - 1);
                                paciente.setQntde_Leucocitos(leucocitos - 1);
                                paciente.setQntde_Hemacias(hemacias - 1);
                                paciente.setQntde_K(celulasK - 1);

                                double contraAtaque = paciente.ContraAtaque();

                                setEnergia_Vital(energiaVital - (int) contraAtaque);

                                if (energiaVital < 0) {
                                    energiaVital = 0;

                                }

                                //validacao
                                if (energiaVitalAntesAtaque > 1) {
                                    if (getEnergia_Vital() == 0) { //apos o ataque
                                        escherichia.espalhaEscherichia(listaPatologicos);
                                        escherichia.espalhaEscherichia(listaPatologicos);
                                    }
                                }
                                if (paciente.getQntde_Hemacias() <= 0 || paciente.getQntde_CelulasT() <= 0 || paciente.getQntde_Leucocitos() <= 0 || paciente.getQntde_K() <= 0) {
                                    System.out.println("=========================================================");
                                    System.out.println("Quem está atacando é a Escherichia, tenho " + getEnergia_Vital() + "de energia vital e o paciente irá morrer ao meu ataque");
                                    System.out.println("=========================================================\n\n");

                                }

                            }
                        };
                    } else {
                        System.out.println("O agente não possui identificador");
                        novoAgente = null;
                    }

                    if (novoAgente != null) {
                        agentesInstanciados.add(novoAgente);
                        copiaAgentesInstanciados.add(novoAgente.getIdentificacao());
                        novoAgente.Atacar(listaPatologicos);
                        agentesInstanciados.remove(novoAgente);  // Remover o agente da posição atual
                        copiaAgentesInstanciados.remove(novoAgente.getIdentificacao());
                        agentesInstanciados.addFirst(novoAgente);  // Adicionar o agente no início da lista
                        copiaAgentesInstanciados.addFirst(novoAgente.getIdentificacao());
                    }
                }
                
                if (agenteEncontrado != null && agenteEncontrado.getEnergia_Vital() <= 0 && !(agenteEncontrado instanceof HIV)) {
                    agentesInstanciados.remove(agenteEncontrado);
                    copiaAgentesInstanciados.remove(agenteEncontrado.getIdentificacao());
                    listaPatologicos.remove(agenteEncontrado.getIdentificacao());
                }

            }
            listaPatologicosCopia.clear();
            listaPatologicosCopia.addAll(listaPatologicos);
            
            paciente.verificaPaciente();
        }

        int qtBacteria = Bacteria.getQt();
        int qtVirus = Virus.getQt();
        int qtFungo = Fungo.getQt();
        int qtProtozoario = Protozoario.getQt();

        int elementos[] = {qtBacteria, qtFungo, qtVirus,  qtProtozoario};
        String[] classes = {"Bacteria", "Fungo", "Virus", "Protozoário"};

        int[] frequencias = {qtBacteria, qtFungo, qtVirus,  qtProtozoario};

        //10 pontos
        if (listaPatologicos.isEmpty()) {
            System.out.println("O paciente se curou");

        }

        //10 pontos
        imprimirClassesMaisFrequentes(classes, frequencias);

        //10 pontos
        if (paciente.verificaPaciente()
                == true) {
            System.out.println("O paciente morre em: " + dias + " dias");

        } else if (paciente.verificaPaciente()
                == false) {
            System.out.println("O paciente fica curado em: " + dias + " dias");
        }

    }
}
