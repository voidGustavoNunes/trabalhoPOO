
package ataque;

import main.Paciente;

public class AtaqueHIV {
        Paciente paciente = new Paciente();
        
        int leucocitos = paciente.getQntde_Leucocitos();
        int celulasK = paciente.getQntde_K();
        int celulasT = paciente.getQntde_Celulas();
        
        Paciente.setQntde_K(celulasK - 5);
        Paciente.setQntde_Leucocitos(leucocitos - 10);
        Paciente.setQntde_Celulas(celulasT - 3);
        
}
