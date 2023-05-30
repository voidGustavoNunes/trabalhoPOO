package classeEspecifica;

<<<<<<< HEAD
import AgentePatologico.AgentePatologico;
=======
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9
import classeGeral.Bacteria;
import classeGeral.Fungo;
import java.util.LinkedList;
import main.Paciente;

<<<<<<< HEAD
public class Histoplasma extends Fungo {
=======
public abstract class Histoplasma extends Fungo {
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9

    String codigo = "5";
    Bacteria bacteria;

    public Histoplasma(String identificacao) {
        super(identificacao, 1000, "Histoplasma");
        this.codigo = codigo;
    }

    public Histoplasma() {
        this.codigo = codigo;
    }

<<<<<<< HEAD
=======
    
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9
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

<<<<<<< HEAD
    protected void verificar_Fila_Histoplasma(LinkedList<AgentePatologico> listaPatologicos) {

        int tamanhoLista = listaPatologicos.size();

        int agenteId = listaPatologicos.indexOf(this);

        if (listaPatologicos.get(agenteId - 1) instanceof Bacteria) {
            listaPatologicos.get(agenteId -1 ).setEnergia_Vital(0);
            listaPatologicos.get(agenteId - 1).remover(listaPatologicos);
        }

        if (listaPatologicos.get(agenteId + 1) instanceof Bacteria) {
            if (tamanhoLista == listaPatologicos.size()) {
                listaPatologicos.get(agenteId +1 ).setEnergia_Vital(0);
                listaPatologicos.get(agenteId + 1).remover(listaPatologicos);
            } else {
                listaPatologicos.get(agenteId ).setEnergia_Vital(0);
                listaPatologicos.get(agenteId).remover(listaPatologicos);
                agenteId--;
            }
        }

    }

    @Override
    public void Atacar(LinkedList<AgentePatologico> listaPatologicos, Paciente paciente) {

        int hemacias = paciente.getQntde_Hemacias();
        int energiaH = getEnergia_Vital();

        boolean p = paciente.verificaPaciente();

        paciente.setQntde_Hemacias(hemacias - 50);

        verificar_Fila_Histoplasma(listaPatologicos);//validacao fila

        double contraataque = paciente.ContraAtaque();
        this.setEnergia_Vital(energiaH - (int) contraataque);

        if (energiaH < 0) {
            setEnergia_Vital(0);
        }

    }

    @Override
    public void remover(LinkedList<AgentePatologico> listaPatologicos){
        listaPatologicos.remove(this);

    };
    
    

=======
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

>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9
}
