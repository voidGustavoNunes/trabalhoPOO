package classeEspecifica;

import AgentePatologico.AgentePatologico;
import classeGeral.Bacteria;
import classeGeral.Fungo;
import java.util.LinkedList;
import main.Paciente;

public class Histoplasma extends Fungo {

    String codigo = "5";
    Bacteria bacteria;

    public Histoplasma(String identificacao) {
        super(identificacao, 1000, "Histoplasma");
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

    protected void verificar_Fila_Histoplasma(LinkedList<AgentePatologico> listaPatologicos) { //verifica na lista se há 
                                                                                                // uma bacteria proxima do histoplasma
        int tamanhoLista = listaPatologicos.size();

        int agenteId = listaPatologicos.indexOf(this);

        if (agenteId - 1 >= 1 && listaPatologicos.get(agenteId - 1) instanceof Bacteria) {
            listaPatologicos.get(agenteId - 1).setEnergia_Vital(0);
            listaPatologicos.get(agenteId - 1).remover(listaPatologicos);

        } else if ((agenteId == 0) && listaPatologicos.get(tamanhoLista-1) instanceof Bacteria) {
            listaPatologicos.get(tamanhoLista-1).setEnergia_Vital(0);
        }
        if (listaPatologicos.get(agenteId + 1) instanceof Bacteria) {
            if (tamanhoLista == listaPatologicos.size()) {
                listaPatologicos.get(agenteId + 1).setEnergia_Vital(0);
                listaPatologicos.get(agenteId + 1).remover(listaPatologicos);
            } else {
                listaPatologicos.get(agenteId).setEnergia_Vital(0);
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
            this.setEnergia_Vital(0);
        }

    }

    @Override
    public void remover(LinkedList<AgentePatologico> listaPatologicos) {
        listaPatologicos.remove(this);

    }
;

}
