package classeEspecifica;

import classeGeral.Protozoario;
import main.Paciente;
import main.lerArquivo;

public abstract class Giardia extends Protozoario {
    String codigo = "3";
    
    public Giardia(String identificacao) {
        super(identificacao, 500, "Giardia");
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

    @Override
    public void setEnergia_Vital(int energia_Vital) {
        super.setEnergia_Vital(energia_Vital);
    }

    Paciente paciente = new Paciente();

    public void Ataque() {
        
        String  identificacao1 = getIdentificacao();

        int recupera = 50;

        int celulasK = paciente.getQntde_K();
        int celulasT = paciente.getQntde_CelulasT();

        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();
        int energia_Vital = getEnergia_Vital();

        boolean p = paciente.verificaPaciente();
        String identificacao = getIdentificacao();

        if (getEnergia_Vital() == 0) { //SE A GIARDIA MORREU
            lerArquivo.removerDaLista(identificacao);

        }

        if (p == false) { //SE O PACIENTE NAO MORREU

            //============ ATAQUE DA GIARDIA ===================
            paciente.setQntde_K(celulasK - 9);
            paciente.setQntde_CelulasT(celulasT - 8);

            // ============ CONTRA ATAQUE DO PACIENTE ===================
            double contraAtaque = paciente.ContraAtaque();
            setEnergia_Vital((int) contraAtaque);

            if ((leucocitos * 2) < hemacias) {
                setEnergia_Vital(energia_Vital + recupera);
            }
            
            lerArquivo.ultimoLista(identificacao1); //joga ele pra ultimo
        }
        

    }

}
