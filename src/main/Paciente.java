
package main;


public class Paciente {
    String nome;
    double peso;
    double altura;
    int idade;
    int qntde_Leucocitos;
    int qntde_Hemacias;
    int qntde_Celulas;
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

    public int getQntde_Celulas() {
        return qntde_Celulas;
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

    public void setQntde_Celulas(int qntde_Celulas) {
        this.qntde_Celulas = qntde_Celulas;
    }

    public void setQntde_K(int qntde_K) {
        this.qntde_K = qntde_K;
    }


}
