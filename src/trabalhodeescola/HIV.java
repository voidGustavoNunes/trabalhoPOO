package trabalhodeescola;

public class HIV extends Agente {

    public static void main(String[] args) {
        Agente agente = new Agente();
        
        agente.getClasse_Especifica("HIV");
        agente.getClasse_Geral("Virus");
        agente.getEnergia_Vital(0);
        agente.getIdentificacao("HIV1XPTO");
        
    }
}
