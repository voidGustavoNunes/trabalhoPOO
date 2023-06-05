package classeEspecifica;

import AgentePatologico.AgentePatologico;
import classeGeral.Protozoario;
import java.util.LinkedList;
import main.Paciente;

public class Giardia extends Protozoario {

    String codigo = "3";

    public Giardia(String identificacao) {
        super(identificacao, 500, "Giardia");
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

    @Override
    public void Atacar(LinkedList<AgentePatologico> listaPatologicos, Paciente paciente) {
        final int RECUPERA = 50;

        int celulasK = paciente.getQntde_K();
        int celulasT = paciente.getQntde_CelulasT();

        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();
        int energia_Vital = getEnergia_Vital();

        boolean p = paciente.verificaPaciente();
        String identificacao = getIdentificacao();

        //============ ATAQUE DA GIARDIA ===================
        paciente.setQntde_K(celulasK - 9);
        paciente.setQntde_CelulasT(celulasT - 8);

        // ============ CONTRA ATAQUE DO PACIENTE ===================
        double contraAtaque = paciente.ContraAtaque();
        this.setEnergia_Vital(this.getEnergia_Vital() - (int) contraAtaque );
        if (getEnergia_Vital() < 0) {
            this.setEnergia_Vital(0);

        }

        if ((leucocitos * 2) < hemacias) {
            this.setEnergia_Vital(this.getEnergia_Vital() + RECUPERA);
        }

    }

    @Override
    public void remover(LinkedList<AgentePatologico> listaPatologicos){
        listaPatologicos.remove(this);
    
    };
    
    

}
