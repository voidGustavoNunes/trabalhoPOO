package classeEspecifica;

import classeGeral.Bacteria;
import classeGeral.Fungo;
import java.util.LinkedList;
import main.Paciente;

public abstract class Histoplasma extends Fungo {

    String codigo = "5";
    Bacteria bacteria;

    public Histoplasma(String identificacao) {
        super(identificacao, 1000, "Histoplasma");
        this.codigo = codigo;
    }

    public Histoplasma() {
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
    public void setEnergia_Vital(int energia_Vital) {
        super.setEnergia_Vital(energia_Vital);
    }

    @Override
    public String getIdentificacao() {
        return super.getIdentificacao();
    }

    Paciente paciente = new Paciente();

    public static void verificar_Fila_Histoplasma(LinkedList<String> listaPatologicos) {

        int tamanhoLista = listaPatologicos.size();

        for (int i = 0; i < listaPatologicos.size() - 1; i++) {
            String identificador = listaPatologicos.get(i);
            String proximoIdentificador = "";
            String anteriorIdentificador = "";
            System.out.println(i - 1 < listaPatologicos.size() - 1);
            System.out.println(i - 1 >= 0);
            if ((i - 1) >= 0 && (i - 1) < listaPatologicos.size()) {
                anteriorIdentificador = listaPatologicos.get(i - 1);
            }
            if (listaPatologicos.size() - 1 >= i + 1) {
                proximoIdentificador = listaPatologicos.get(i + 1);
            }

            String[] texto = identificador.split(" ");
            String[] proximoTexto = proximoIdentificador.split(" ");
            String[] anteriorTexto = anteriorIdentificador.split(" ");

            if (anteriorTexto[0].equals("2") || anteriorTexto[0].equals("6")) {
                if (texto[0].equals("5")) {
                    listaPatologicos.remove(i - 1);
                }
            }

            
            if (proximoTexto[0].equals("2") || proximoTexto[0].equals("6")) {
                if (texto[0].equals("5")) {
                    if (tamanhoLista == listaPatologicos.size()) {
                        listaPatologicos.remove(i + 1);
                    } else {
                        listaPatologicos.remove(i);
                        i--;
                }
            }
                
            }
        }
    }

    @Override
    public void Atacar(){

    }

}
