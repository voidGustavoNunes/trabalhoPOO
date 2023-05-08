package ataque;

import java.util.Random;

import classeEspecifica.Escherichia;
import java.util.LinkedList;
import main.*;

public class AtaqueEscherichia extends Escherichia {

    private Paciente paciente;
    private Escherichia escherichia; //cria uma escherichia

    public AtaqueEscherichia(String identificacao) {
        super(identificacao);
    }

    private void espalhaEscherichia(Escherichia escherichia) { //passa como parametro o objeto escherichia
        Random random = new Random();

        LinkedList lista = lerArquivo.lerArquivo1();

        int indiceAleatorio = random.nextInt((lista.size()) + 1); //pega o tamanho da lista e gera um numero aleatorio

        lista.add(indiceAleatorio, escherichia); //adiciona em um indice aleatorio a nova escherichia

    }

    private Escherichia criarNovaEscherichia() {
        GerarIdentificador gerar = new GerarIdentificador();

        String codigo = getCODIGO();

        Escherichia escherichia = new Escherichia(gerar.gerarIdentificacao(codigo));
        int energiaVital = escherichia.getenergia_Vital();

        energiaVital = energiaVital / 2;

        setEnergia_Vital(energiaVital);

        espalhaEscherichia(escherichia);

        return escherichia;
    }

    public void Ataque() {
        AtaquePaciente ataque = new AtaquePaciente();

        int celulasT = paciente.getQntde_Celulas();
        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();
        int celulasK = paciente.getQntde_K();

        int energiaVital = escherichia.getenergia_Vital();
        
        
        while (energiaVital != 1) {
            paciente.setQntde_Celulas(celulasT - 1);
            paciente.setQntde_Leucocitos(leucocitos - 1);
            paciente.setQntde_Hemacias(hemacias - 1);
            paciente.setQntde_K(celulasK - 1);

            double contraAtaque = ataque.ContraAtaque();

            escherichia.setEnergia_Vital(energiaVital - (int) contraAtaque);

            //validacao
            if (energiaVital == 0) {
                criarNovaEscherichia();
                criarNovaEscherichia();
            }
        }
    }

}
