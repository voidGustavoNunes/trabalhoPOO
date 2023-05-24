package classeEspecifica;

import classeGeral.Bacteria;
import java.util.LinkedList;
import java.util.Random;
import main.GerarIdentificador;
import main.Paciente;
import main.lerArquivo;

public abstract class Escherichia extends Bacteria {

    String codigo = "6";
    Paciente paciente = new Paciente();

    public Escherichia(String identificacao) {
        super(identificacao, 64, "Escherichia");
        this.codigo = codigo;
    }
    

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getClasse_Especifica() {
        return super.getClasse_Especifica();
    }

    @Override
    public String getClasse_Geral() {
        return super.getClasse_Geral();
    }

    @Override
    public int getEnergia_Vital() {
        return super.getEnergia_Vital();
    }

    @Override
    public String getIdentificacao() {
        return super.getIdentificacao();
    }

    private void espalhaEscherichia(Escherichia escherichia) { //passa como parametro o objeto escherichia
        Random random = new Random();

        LinkedList lista = lerArquivo.lerArquivo1("patologicos.txt");

        int indiceAleatorio = random.nextInt((lista.size()) + 1); //pega o tamanho da lista e gera um numero aleatorio

        lista.add(indiceAleatorio, escherichia); //adiciona em um indice aleatorio a nova escherichia

    }

    private void criarNovaEscherichia() {
        GerarIdentificador gerar = new GerarIdentificador();

        String codigo = getCodigo();

        Escherichia escherichia = new Escherichia(gerar.gerarIdentificacao(codigo)) {
        };
        int energiaVital = getEnergia_Vital();

        energiaVital = energiaVital / 2;

        escherichia.setEnergia_Vital(energiaVital);

        espalhaEscherichia(escherichia); //ESPALHA A ESCHERICHIA PELA FILA

    }
    @Override
    public void Atacar() {

        boolean p = paciente.verificaPaciente();

        int celulasT = paciente.getQntde_CelulasT();
        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();
        int celulasK = paciente.getQntde_K();

        int energiaVital = getEnergia_Vital();
        
        String identificacao1 = getIdentificacao();

        if (p == false) { //SE O PACIENTE NAO MORREU
            paciente.setQntde_CelulasT(celulasT - 1);
            paciente.setQntde_Leucocitos(leucocitos - 1);
            paciente.setQntde_Hemacias(hemacias - 1);
            paciente.setQntde_K(celulasK - 1);

            double contraAtaque = paciente.ContraAtaque();

            setEnergia_Vital(energiaVital - (int) contraAtaque);
            lerArquivo.ultimoLista(identificacao1); //joga ele pra ultimo

            //validacao
            if (getEnergia_Vital() != 1) {
                if (getEnergia_Vital() == 0) {
                    criarNovaEscherichia();
                    criarNovaEscherichia();
                }
            }
        }
    }
}
