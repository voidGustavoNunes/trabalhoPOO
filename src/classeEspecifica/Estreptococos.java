package classeEspecifica;

import classeGeral.Bacteria;
import java.util.LinkedList;
import main.GerarIdentificador;
import main.Paciente;
import main.lerArquivo;

public abstract class Estreptococos extends Bacteria {
    String codigo = "2";
    
    public Estreptococos(String identificacao) {
        super(identificacao, 200, "Estreptococos");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getIdentificacao() {
        return super.getIdentificacao();
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

    Paciente paciente = new Paciente();


    public void Ataque() {
        String  identificacao1 = getIdentificacao();
        
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
        
        lerArquivo.ultimoLista(identificacao1); //joga ele pra ultimo

    }

    
    
}
