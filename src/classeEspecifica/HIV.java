package classeEspecifica;

import AgentePatologico.AgentePatologico;
import classeGeral.Virus;
import java.util.LinkedList;
import main.Paciente;

public abstract class HIV extends Virus {

    String codigo = "1";

    public HIV(String identificacao) {
        super(identificacao, 0, "HIV");
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

    @Override
    public void Atacar(LinkedList<AgentePatologico> listaPatologicos, Paciente paciente) {
        int leucocitos = paciente.getQntde_Leucocitos();
        int celulasK = paciente.getQntde_K();
        int celulasT = paciente.getQntde_CelulasT();

        //ATAQUE DO HIV
        paciente.setQntde_K(celulasK - 5);
        paciente.setQntde_Leucocitos(leucocitos - 10);
        paciente.setQntde_CelulasT(celulasT - 3);

        //CONTRA ATAQUE
        double contrataque = paciente.ContraAtaque();
        this.setEnergia_Vital(getEnergia_Vital() - (int) contrataque);

        if (getEnergia_Vital() < 0) {
            setEnergia_Vital(0);

        }
    }

    @Override
    public abstract void remover(LinkedList<AgentePatologico> listaPatologicos);
    
    
    
}
