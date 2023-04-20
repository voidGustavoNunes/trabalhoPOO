
package trabalhodeescola;


public class Ataques {
    public void ataque_HIV(){
        paciente paciente = new paciente();
        
        int leucocitos = paciente.getQntde_Leucocitos();
        int celulasK = paciente.getQntde_K();
        int celulasT = paciente.getQntde_Celulas();
        
        paciente.setQntde_K(celulasK - 5);
        paciente.setQntde_Leucocitos(leucocitos - 10);
        paciente.setQntde_Celulas(celulasT - 3);
        

    }
    
    public void ataque_Estrep(){
        paciente paciente = new paciente();
        
        int celulasK = paciente.getQntde_K();
        int hemacias = paciente.getQntde_Hemacias();
        
        
        paciente.setQntde_Hemacias(hemacias - 10);
        paciente.setQntde_K(celulasK - 3);
        
        //acrescentar if utilizando a lista
        
    }
    
    public void ataque_Giardia(){
        paciente paciente = new paciente();
        
        int celulasK = paciente.getQntde_K();
        int celulasT = paciente.getQntde_Celulas();
        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();
    
        paciente.setQntde_K(celulasK - 9);
        paciente.setQntde_Celulas(celulasT - 8);
        
        if((leucocitos * 2) < hemacias){
            //acrescentar codigo giardia recuperando energia vital
        
        
        }
    }
    public void ataque_Covid(){
        paciente paciente = new paciente();
        
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
    
    public void ataque_Histoplasma(){
        paciente paciente = new paciente();
        
        int hemacias = paciente.getQntde_Hemacias();
        
        paciente.setQntde_Hemacias(hemacias - 50);
        
        //fazer verificacao na fila se esta do lado da bacteria

    
    }
    public void ataque_Escherichia(){
        paciente paciente = new paciente();
    
        int celulasT = paciente.getQntde_Celulas();
        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();
        int celulasK = paciente.getQntde_K();
        
        paciente.setQntde_Celulas(celulasT - 1);
        paciente.setQntde_Leucocitos(leucocitos - 1);
        paciente.setQntde_Hemacias(hemacias - 1);
        paciente.setQntde_K(celulasK - 1);
        
        
        //fazer validacao
        
    
    }
    
    
    
    
}


