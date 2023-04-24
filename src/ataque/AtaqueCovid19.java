
package ataque;

import main.Paciente;

public class AtaqueCovid19 {
    Paciente paciente = new Paciente();
        
    int celulasT = paciente.getQntde_Celulas();
    int hemacias = paciente.getQntde_Hemacias();
    int leucocitos = paciente.getQntde_Leucocitos();

    paciente.setQntde_Leucocitos(leucocitos - 10);
    paciente.setQntde_Celulas(celulasT - 2);
    paciente.setQntde_Hemacias(hemacias - 15);
        
    if(hemacias < 200){
       ataque_Covid();
    }
    // verificar se o ataque esta sendo recursivo
}
