package classeEspecifica;

import classeGeral.Fungo;
import main.Paciente;
import main.lerArquivo;

public abstract class Histoplasma extends Fungo {

    String codigo = "5";
    
    public Histoplasma(String identificacao) {
        super(identificacao, 1000, "Histoplasma");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
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

    @Override
    public String getIdentificacao() {
        return super.getIdentificacao();
    }

    Paciente paciente = new Paciente();

    public void Ataque() {

        String identificacao1 = getIdentificacao(); //PEGA A IDENTIFICACAO DO HISTOPLASMA CRIADO

        int hemacias = paciente.getQntde_Hemacias();
        int energiaH = getEnergia_Vital();

        boolean p = paciente.verificaPaciente();

        if (energiaH == 0) { //SE O HISTOPLASMA MORREU
            lerArquivo.removerDaLista(identificacao1);
        }

        if (p == false) { //se paciente nao morreu
            paciente.setQntde_Hemacias(hemacias - 50);

            lerArquivo.verificar_Fila_Histoplasma();//validacao fila

            double contraataque = paciente.ContraAtaque();
            setEnergia_Vital(energiaH - (int) contraataque);

            lerArquivo.ultimoLista(identificacao1); //joga ele pra ultimo

        }

    }

}
