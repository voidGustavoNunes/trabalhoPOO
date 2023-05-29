package classeEspecifica;

import AgentePatologico.AgentePatologico;
import classeGeral.Bacteria;
import java.util.LinkedList;
import main.Paciente;


public abstract class Estreptococos extends Bacteria {

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
                return true;
            }
        }
        return false;

    }

    public static String retornaIdEstrep(LinkedList<String> listaPatologicos) { //Estreptococos

        for (int i = 0; i < listaPatologicos.size() -1; i++) {
            String elementoAtual = (String) listaPatologicos.get(i);
            String proximoElemento = (String) listaPatologicos.get(i + 1);

            String texto[] = elementoAtual.split(" ");
            String textoProximo[] = proximoElemento.split(" ");

            String id = texto[0];
            String nome = texto[1];

            String idProximo = textoProximo[0];

            if (id.equals(idProximo) && id.equals("2")) {
                String identificacao = id + " " + texto[1].replace("\n", "") + textoProximo[1].replace("\n", "") + "\n";

                return identificacao;
            }
        }
        return null;

    }

    @Override
    public void Atacar(){}

}
