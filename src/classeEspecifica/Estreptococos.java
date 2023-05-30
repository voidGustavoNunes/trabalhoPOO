package classeEspecifica;

import AgentePatologico.AgentePatologico;
import classeGeral.Bacteria;
import java.util.LinkedList;
import main.Paciente;

<<<<<<< HEAD
public class Estreptococos extends Bacteria {
=======

public abstract class Estreptococos extends Bacteria {
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9

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
<<<<<<< HEAD
        super.setEnergia_Vital(energia_Vital);
=======
        super.setEnergia_Vital(energia_Vital); 
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9
    }

    public Estreptococos() {
        this.codigo = codigo;
    }
<<<<<<< HEAD

    public boolean lerEstreptococos(LinkedList<AgentePatologico> listaPatologicos) { //ler se há um outro estreptococos na fila

        for (int i = 0; i < listaPatologicos.size() - 1; i++) {
            AgentePatologico elementoAtual = listaPatologicos.get(i);     // 1 HV1
            AgentePatologico proximoElemento = null;
            if (listaPatologicos.size() - 1 >= i + 1) {
                proximoElemento =  listaPatologicos.get(i + 1);     //2 EST
            }

            if (elementoAtual.getClasse_Especifica() == "Estreptococos" && proximoElemento.getClasse_Especifica() == "Estreptococos") {
=======
    
    

    Paciente paciente = new Paciente();


    public boolean lerEstreptococos(LinkedList<String> listaPatologicos) { //ler se há um outro estreptococos na fila

        for (int i = 0; i < listaPatologicos.size() -1; i++) {
            String elementoAtual = (String) listaPatologicos.get(i);     // 1 HV1
            String proximoElemento = "";
            if(listaPatologicos.size()-1 >= i+1) {
                proximoElemento = (String) listaPatologicos.get(i + 1);     //2 EST
            }

            String texto[] = elementoAtual.split(" ");
            String textoProximo[] = proximoElemento.split(" ");

            String id = texto[0];
            String idProximo = textoProximo[0];

            if (id.equals(idProximo) && idProximo.equals("2")) {
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9
                return true;
            }
        }
        return false;

    }

<<<<<<< HEAD
    public static String retornaIdEstrep(LinkedList<AgentePatologico> listaPatologicos) { //Estreptococos

        for (int i = 0; i < listaPatologicos.size() - 1; i++) {
            AgentePatologico elementoAtual = listaPatologicos.get(i);
            AgentePatologico proximoElemento = listaPatologicos.get(i + 1);

            String texto[] = elementoAtual.getIdentificacao().split(" ");
            String textoProximo[] = proximoElemento.getIdentificacao().split(" ");
=======
    public static String retornaIdEstrep(LinkedList<String> listaPatologicos) { //Estreptococos

        for (int i = 0; i < listaPatologicos.size() -1; i++) {
            String elementoAtual = (String) listaPatologicos.get(i);
            String proximoElemento = (String) listaPatologicos.get(i + 1);

            String texto[] = elementoAtual.split(" ");
            String textoProximo[] = proximoElemento.split(" ");
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9

            String id = texto[0];
            String nome = texto[1];

            String idProximo = textoProximo[0];
<<<<<<< HEAD
            String nomeProximo = textoProximo[1];

            if (id.equals(idProximo) && id.equals("2")) {
                String identificacao = id + " " + nome.replace("\n", "") + nomeProximo.replace("\n", "") + "\n";
=======

            if (id.equals(idProximo) && id.equals("2")) {
                String identificacao = id + " " + texto[1].replace("\n", "") + textoProximo[1].replace("\n", "") + "\n";
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9

                return identificacao;
            }
        }
        return null;

    }

    @Override
<<<<<<< HEAD
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
    }

    @Override
    public void remover(LinkedList<AgentePatologico> listaPatologicos) {
        listaPatologicos.remove(this);
    }
=======
    public void Atacar(){}

>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9
}
