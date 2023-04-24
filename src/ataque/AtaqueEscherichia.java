
package ataque;

import main.Paciente;

public class AtaqueEscherichia {
    Paciente paciente = new Paciente();
    
    int celulasT = paciente.getQntde_Celulas();
    int hemacias = paciente.getQntde_Hemacias();
    int leucocitos = paciente.getQntde_Leucocitos();
    int celulasK = paciente.getQntde_K();
        
    paciente.setQntde_Celulas(celulasT - 1);
    paciente.setQntde_Leucocitos(leucocitos - 1);
    paciente.setQntde_Hemacias(hemacias - 1);
    paciente.setQntde_K(celulasK - 1);
        
        
    //fazer validacao
        
    
}
