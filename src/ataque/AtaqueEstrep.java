package ataque;

import classeEspecifica.Estreptococos;
import java.util.LinkedList;
import main.*;

public class AtaqueEstrep extends Estreptococos {

    private Paciente paciente;
    private Estreptococos estreptococos;

    public AtaqueEstrep(String identificacao) {
        super(identificacao);
    }
    

    public void Ataque() {
        LinkedList lista = lerArquivo.lerArquivo1();
        
        boolean estreptococosFila;
        estreptococosFila = lerArquivo.lerEstreptococos();

        int celulasK = paciente.getQntde_K();
        int hemacias = paciente.getQntde_Hemacias();
        
        
        if (estreptococosFila == true) {
            String idEstrepNovo = lerArquivo.retornaIdEstrep();
            
            lista.add(idEstrepNovo);  //TESTAR
            
        }

        paciente.setQntde_Hemacias(hemacias - 10);
        paciente.setQntde_K(celulasK - 3);
        
        String identificacao = GerarIdentificador.gerarIdentificacao("2");

    }

}
