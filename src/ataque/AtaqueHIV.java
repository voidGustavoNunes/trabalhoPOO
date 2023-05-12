
package ataque;

import main.Paciente;

public class AtaqueHIV {
    
    public static void Ataque(){
        Paciente paciente = new Paciente();
        
        int leucocitos = paciente.getQntde_Leucocitos();
        int celulasK = paciente.getQntde_K();
        int celulasT = paciente.getQntde_Celulas();
        
        paciente.setQntde_K(celulasK - 5);
        paciente.setQntde_Leucocitos(leucocitos - 10);
        paciente.setQntde_Celulas(celulasT - 3);
        
        
        
    }    
}
