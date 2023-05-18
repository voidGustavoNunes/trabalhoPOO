package ataque;

import classeEspecifica.HIV;
import main.Paciente;

public class AtaqueHIV {

    private Paciente paciente;
    private HIV hiv;
    
    public void Ataque() {
        
        AtaquePaciente ataque = new AtaquePaciente();

        boolean p = paciente.verificaPaciente();

        while (p == false) { //enquanto o paciente nao morre
            int leucocitos = paciente.getQntde_Leucocitos();
            int celulasK = paciente.getQntde_K();
            int celulasT = paciente.getQntde_CelulasT();

            paciente.setQntde_K(celulasK - 5);
            paciente.setQntde_Leucocitos(leucocitos - 10);
            paciente.setQntde_CelulasT(celulasT - 3);
            
            double contrataque = ataque.ContraAtaque();
            hiv.setEnergia_Vital((int) contrataque);
            

        }

    }
}
