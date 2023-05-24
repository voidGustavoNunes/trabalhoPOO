
package main;

import java.util.LinkedList;


public class Paciente {
    String nome;
    double peso;
    double altura;
    int idade;
    int qntde_Leucocitos;
    int qntde_Hemacias;
    int qntde_CelulasT;
    int qntde_K;

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public int getIdade() {
        return idade;
    }

    public int getQntde_Leucocitos() {
        return qntde_Leucocitos;
    }

    public int getQntde_Hemacias() {
        return qntde_Hemacias;
    }

    public int getQntde_CelulasT() {
        return qntde_CelulasT;
    }

    public int getQntde_K() {
        return qntde_K;
    }

    public void setQntde_Leucocitos(int qntde_Leucocitos) {
        this.qntde_Leucocitos = qntde_Leucocitos;
    }

    public void setQntde_Hemacias(int qntde_Hemacias) {
        this.qntde_Hemacias = qntde_Hemacias;
    }

    public void setQntde_CelulasT(int qntde_CelulasT) {
        this.qntde_CelulasT = qntde_CelulasT;
    }

    public void setQntde_K(int qntde_K) {
        this.qntde_K = qntde_K;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    public boolean verificaPaciente(){
        int k = getQntde_K();
        int t = getQntde_CelulasT();
        int h = getQntde_Hemacias();
        int l = getQntde_Leucocitos();
        
        if(k == 0 || t == 0|| h == 0 || l == 0){
            return true; 
        
        }
        return false;
    
    }
    
    
    public double ContraAtaque() {
        int leucocitos = getQntde_Leucocitos();
        double peso = getPeso();
        double altura = getAltura();
        int idade = getIdade();
        
        double ataque = (((double) leucocitos)/ peso * altura * (double) idade);
        
        return ataque;   
    }
        
    public void setaDadosPaciente(){
        LinkedList listaPaciente = lerArquivo.lerArquivo1("paciente.txt");
    
        String nome = (String) listaPaciente.get(0);
        String peso = (String) listaPaciente.get(1);
        String altura = (String) listaPaciente.get(2);
        String idade = (String) listaPaciente.get(3);
        String leucocitos = (String) listaPaciente.get(4);
        String hemacias = (String) listaPaciente.get(5);
        String celulasT = (String) listaPaciente.get(6);
        String celulasK = (String) listaPaciente.get(7);
        
        setNome(nome);
        setPeso(Double.parseDouble(peso));
        setAltura(Double.parseDouble(altura));
        setIdade(Integer.parseInt(idade));
        setQntde_Leucocitos(Integer.parseInt(leucocitos));
        setQntde_Hemacias(Integer.parseInt(hemacias));
        setQntde_CelulasT(Integer.parseInt(celulasT));
        setQntde_K(Integer.parseInt(celulasK));
        
    }

}
