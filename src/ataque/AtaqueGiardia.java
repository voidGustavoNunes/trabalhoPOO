package ataque;

import main.Paciente;

public class AtaqueGiardia {
        Paciente paciente = new Paciente();
        
        int celulasK = paciente.getQntde_K();
        int celulasT = paciente.getQntde_Celulas();
        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();
    
        paciente.setQntde_K(celulasK - 9);
        paciente.setQntde_Celulas(celulasT - 8);
        
        if((leucocitos * 2) < hemacias){
            //acrescentar codigo giardia recuperando energia vital
        
}
