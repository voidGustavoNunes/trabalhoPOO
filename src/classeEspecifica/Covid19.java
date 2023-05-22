package classeEspecifica;

import classeGeral.Virus;
import java.util.LinkedList;
import main.*;

public abstract class Covid19 extends Virus {

    Paciente paciente = new Paciente();

    String codigo = "4";

    public Covid19(String identificacao) {
        super(identificacao, 100, "Covid19");
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

    public void Ataque() {

        boolean p = paciente.verificaPaciente();
        int energia_Vital = getEnergia_Vital();

        String identificacao1 = getIdentificacao();

        int celulasT = paciente.getQntde_CelulasT();
        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();

        if (energia_Vital == 0) { //SE A COVID MORRER
            lerArquivo.removerDaLista(identificacao1);
        }

        if (p == false) {
            //ATAQUE DA COVID
            paciente.setQntde_Leucocitos(leucocitos - 10);
            paciente.setQntde_CelulasT(celulasT - 2);
            paciente.setQntde_Hemacias(hemacias - 15);

            //CONTRA ATAQUE PACIENTE
            double contraAtaque = paciente.ContraAtaque();
            setEnergia_Vital((energia_Vital - (int) contraAtaque));
            
            
            //SEGUNDO ATAQUE
            if (hemacias < 200) {
                paciente.setQntde_Leucocitos(leucocitos - 10);
                paciente.setQntde_CelulasT(celulasT - 2);
                paciente.setQntde_Hemacias(hemacias - 15);
                
                //SEGUNDO CONTRA ATAQUE
                double contraAtaque2 = paciente.ContraAtaque();
                setEnergia_Vital((energia_Vital - (int) contraAtaque2));
            }
            lerArquivo.ultimoLista(identificacao1); //joga ele pra ultimo
            
        }

    }
}
