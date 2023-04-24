package ataque;

import main.Paciente;

public class AtaqueHistoPlasma {
    Paciente paciente = new Paciente();
        
    int hemacias = paciente.getQntde_Hemacias();
        
    paciente.setQntde_Hemacias(hemacias - 50);
        
    //fazer verificacao na fila se esta do lado da bacteria

}
