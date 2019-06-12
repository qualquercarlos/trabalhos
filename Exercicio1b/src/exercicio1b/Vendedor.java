/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1b;

/**
 *
 * @author 10070361
 */
public class Vendedor extends Funcionario {

    private String numeroFilial;

    public String getNumeroFilial() {
        return numeroFilial;
    }

    public void setNumeroFilial(String numeroFilial) {
        this.numeroFilial = numeroFilial;
    }
  
     public void imprimirDados() {
       
       super.imprimirDados();
       System.out.print(" filial: "+numeroFilial);
    }
}
