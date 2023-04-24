
package ataque;

import main.Paciente;

public class AtaqueEstrep {
    Paciente paciente = new Paciente();
        
    boolean estreptococosFila;
    estreptococosFila = lerArquivo.lerEstreptococos();
        
    int celulasK = paciente.getQntde_K();
    int hemacias = paciente.getQntde_Hemacias();
        
        
    paciente.setQntde_Hemacias(hemacias - 10);
    paciente.setQntde_K(celulasK - 3);
        
    //acrescentar if utilizando a lista
        
    if (estreptococosFila == true){
        Estrepcococos estreptococos = new Estrepcococos(); 
    }

}
