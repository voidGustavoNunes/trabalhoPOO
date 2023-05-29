package classeEspecifica;

import classeGeral.Bacteria;
import java.util.LinkedList;
import main.GerarIdentificador;
import main.Paciente;

public abstract class Escherichia extends Bacteria {

    private static String codigo = "6";
    Paciente paciente = new Paciente();

    public Escherichia(String identificacao) {
        super(identificacao, 64, "Escherichia");
        this.codigo = codigo;
    }

    public Escherichia() {
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

    private void adicionarStringAleatoria(LinkedList<String> lista, String novaString) {
        // Gerar um número aleatório para a posição
        int posicaoAleatoria = (int) (Math.random() * (lista.size() + 1));

        // Inserir a nova string na posição aleatória
        lista.add(posicaoAleatoria, novaString);
    }

    public void espalhaEscherichia(LinkedList<String> lista) { //passa como parametro o objeto escherichia
        GerarIdentificador gerar = new GerarIdentificador();

        String identificadorPrimeiraEscherichia = gerar.gerarIdentificacao(codigo);
        String identificadorSegundaEscherichia = gerar.gerarIdentificacao(codigo);

        adicionarStringAleatoria(lista, identificadorPrimeiraEscherichia);
        adicionarStringAleatoria(lista, identificadorSegundaEscherichia);

    }
    @Override
    public void Atacar(){
    
    }

}

