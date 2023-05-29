
package AgentePatologico;

import java.util.LinkedList;


public abstract class AgentePatologico {
    private String identificacao;
    private int energia_Vital;
    private String classe_Geral;
    private String classe_Especifica;

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getEnergia_Vital() {
        return energia_Vital;
    }

    public void setEnergia_Vital(int energia_Vital) {
        this.energia_Vital = energia_Vital;
    }

    public String getClasse_Geral() {
        return classe_Geral;
    }

    public void setClasse_Geral(String classe_Geral) {
        this.classe_Geral = classe_Geral;
    }

    public String getClasse_Especifica() {
        return classe_Especifica;
    }

    public void setClasse_Especifica(String classe_Especifica) {
        this.classe_Especifica = classe_Especifica;
    }

    public AgentePatologico(String identificacao, int energia_Vital, String classe_Geral, String classe_Especifica) {
        this.identificacao = identificacao;
        this.energia_Vital = energia_Vital;
        this.classe_Geral = classe_Geral;
        this.classe_Especifica = classe_Especifica;
    }

    public AgentePatologico() {
    }
    
    public void Atacar(){}
    
    public void Atacar(LinkedList<String> lista){}

    
    
    
    
}
