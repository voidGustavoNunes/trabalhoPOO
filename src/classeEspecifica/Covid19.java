package classeEspecifica;

<<<<<<< HEAD
import AgentePatologico.AgentePatologico;
=======
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9
import classeGeral.Virus;
import java.util.LinkedList;
import main.*;

<<<<<<< HEAD
public class Covid19 extends Virus {

=======
public abstract class Covid19 extends Virus {
    
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9
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

    @Override
<<<<<<< HEAD
    public void Atacar(LinkedList<AgentePatologico> listaPatologicos, Paciente paciente) {
        int energia_Vital = getEnergia_Vital();

        int celulasT = paciente.getQntde_CelulasT();
        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();

        //ATAQUE DA COVID
        paciente.setQntde_Leucocitos(leucocitos - 10);
        paciente.setQntde_CelulasT(celulasT - 2);
        paciente.setQntde_Hemacias(hemacias - 15);

        //CONTRA ATAQUE PACIENTE
        double contraAtaque = paciente.ContraAtaque();
        setEnergia_Vital((energia_Vital - (int) contraAtaque));

        if (getEnergia_Vital() < 0) {
            setEnergia_Vital(0);

        }

        //SEGUNDO ATAQUE
        if (hemacias < 200) {
            paciente.setQntde_Leucocitos(leucocitos - 10);
            paciente.setQntde_CelulasT(celulasT - 2);
            paciente.setQntde_Hemacias(hemacias - 15);

            //SEGUNDO CONTRA ATAQUE
            double contraAtaque2 = paciente.ContraAtaque();
            setEnergia_Vital((this.getEnergia_Vital() - (int) contraAtaque2));

            if (getEnergia_Vital() < 0) {
                setEnergia_Vital(0);

            }
        }

    }
    
    
    @Override
        public void remover(LinkedList<AgentePatologico> listaPatologicos){
            listaPatologicos.remove(this);
        
        }
=======
    public void Atacar() {

    }
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9

}
