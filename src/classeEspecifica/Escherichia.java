package classeEspecifica;

import AgentePatologico.AgentePatologico;
import classeGeral.Bacteria;
import java.util.LinkedList;
import main.GeraIdentificador;
import main.Paciente;

public class Escherichia extends Bacteria {

    private static String codigo = "6";
    Paciente paciente = new Paciente();

    boolean filho = false;

    public Escherichia(String identificacao) {
        super(identificacao, 64, "Escherichia");
        this.codigo = codigo;
    }

    public Escherichia(String identificacao, boolean filho) {
        super(identificacao, 64, "Escherichia");
        this.codigo = codigo;
        this.filho = filho;
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

    private void adicionarStringAleatoria(LinkedList<AgentePatologico> lista, String novaString) {
        // Gerar um número aleatório para a posição
        int posicaoAleatoria = (int) (Math.random() * (lista.size() - 1));

        // Inserir a nova string na posição aleatória
        Escherichia escherichia = new Escherichia(novaString, true);
        lista.add(posicaoAleatoria, escherichia);
    }

    public void espalhaEscherichia(LinkedList<AgentePatologico> lista) { //passa como parametro o objeto escherichia
        GeraIdentificador gerar = new GeraIdentificador();

        String identificadorPrimeiraEscherichia = gerar.gerarIdentificacao(codigo);
        String identificadorSegundaEscherichia = gerar.gerarIdentificacao(codigo);

        this.adicionarStringAleatoria(lista, identificadorPrimeiraEscherichia);
        this.adicionarStringAleatoria(lista, identificadorSegundaEscherichia);

    }

    @Override
    public void Atacar(LinkedList<AgentePatologico> listaPatologicos, Paciente paciente) {

        int celulasT = paciente.getQntde_CelulasT();
        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();
        int celulasK = paciente.getQntde_K();


        paciente.setQntde_CelulasT(celulasT - 1);
        paciente.setQntde_Leucocitos(leucocitos - 1);
        paciente.setQntde_Hemacias(hemacias - 1);
        paciente.setQntde_K(celulasK - 1);

        double contraAtaque = paciente.ContraAtaque();

        this.setEnergia_Vital(this.getEnergia_Vital() - (int) contraAtaque);

        if (this.getEnergia_Vital() < 0) {
            this.setEnergia_Vital(0) ;

        }

    }

    @Override
    public void remover(LinkedList<AgentePatologico> listaPatologicos) {
        if (filho == false) { //se for a escherichia original
            this.espalhaEscherichia(listaPatologicos);
        }
        else{
            listaPatologicos.remove(this);
        }
    }

}
