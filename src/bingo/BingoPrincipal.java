/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;

/**
 *
 * @author jv_sa
 */
public class BingoPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList num_sorteados = new ArrayList();
        
        CartelaBingo cartela1 = new CartelaBingo("João");
        CartelaBingo cartela2 = new CartelaBingo("Luiz");
        
        cartela1.preencherCartela();
        cartela2.preencherCartela();
        
        cartela1.imprimirCartela();
        cartela2.imprimirCartela();
        
        cartela1.sortearNumeros(cartela1, cartela2);
      
        cartela1.imprimirCartela();
        cartela2.imprimirCartela();
    }
    
}
