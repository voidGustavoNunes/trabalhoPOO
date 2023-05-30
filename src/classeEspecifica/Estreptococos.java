package classeEspecifica;

import AgentePatologico.AgentePatologico;
import classeGeral.Bacteria;
import java.util.LinkedList;
import main.Paciente;

public class Estreptococos extends Bacteria {

    String codigo = "2";

    public Estreptococos(String identificacao) {
        super(identificacao, 200, "Estreptococos");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getIdentificacao() {
        return super.getIdentificacao();
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
    public void setEnergia_Vital(int energia_Vital) {
        super.setEnergia_Vital(energia_Vital);
    }

    public Estreptococos() {
        this.codigo = codigo;
    }

    public boolean lerEstreptococos(LinkedList<AgentePatologico> listaPatologicos) { //ler se há um outro estreptococos na fila

        for (int i = 0; i < listaPatologicos.size() - 1; i++) {
            AgentePatologico elementoAtual = listaPatologicos.get(i);     // 1 HV1
            AgentePatologico proximoElemento = null;
            if (listaPatologicos.size() - 1 >= i + 1) {
                proximoElemento =  listaPatologicos.get(i + 1);     //2 EST
            }

            if (elementoAtual.getClasse_Especifica() == "Estreptococos" && proximoElemento.getClasse_Especifica() == "Estreptococos") {
                return true;
            }
        }
        return false;

    }

    public static String retornaIdEstrep(LinkedList<AgentePatologico> listaPatologicos) { //Estreptococos

        for (int i = 0; i < listaPatologicos.size() - 1; i++) {
            AgentePatologico elementoAtual = listaPatologicos.get(i);
            AgentePatologico proximoElemento = listaPatologicos.get(i + 1);

            String texto[] = elementoAtual.getIdentificacao().split(" ");
            String textoProximo[] = proximoElemento.getIdentificacao().split(" ");

            String id = texto[0];
            String nome = texto[1];

            String idProximo = textoProximo[0];
            String nomeProximo = textoProximo[1];

            if (id.equals(idProximo) && id.equals("2")) {
                String identificacao = id + " " + nome.replace("\n", "") + nomeProximo.replace("\n", "") + "\n";

                return identificacao;
            }
        }
        return null;

    }

    @Override
    public void Atacar(LinkedList<AgentePatologico> listaPatologicos, Paciente paciente) {
        boolean estreptococosFila;
        estreptococosFila = this.lerEstreptococos(listaPatologicos);

        int celulasK = paciente.getQntde_K();
        int hemacias = paciente.getQntde_Hemacias();

        if (estreptococosFila == true) {
            String idEstrepNovo = this.retornaIdEstrep(listaPatologicos);
            Estreptococos agente = new Estreptococos(idEstrepNovo);
            
            listaPatologicos.add(agente);  //TESTAR
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

    @Override
    public void remover(LinkedList<AgentePatologico> listaPatologicos) {
        listaPatologicos.remove(this);
    }
}
