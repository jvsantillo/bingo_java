/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jv_sa
 */
public class CartelaBingo {

    private String nome;
    private int[][] numeros;
    private Random gerador = new Random();
    private ArrayList num_gerados = new ArrayList();
    private ArrayList num_sorteados = new ArrayList();
    
    
    
    public CartelaBingo(String nome){
        this.nome = nome;
        numeros = new int [3][3];
    }

    public String getNome() {
        return nome;
    }
    

    public void preencherCartela() {
        
       int num_gerado = 0;
       
        
       
       for (int posicao_linha = 0; posicao_linha < 3; posicao_linha++) {

            for (int posicao_coluna = 0; posicao_coluna < 3; posicao_coluna++) {

                if(!num_gerados.contains(num_gerado)){
                    num_gerado = gerador.nextInt(75) + 1;
                    numeros[posicao_linha][posicao_coluna] = num_gerado;
                    num_gerados.add(num_gerado);
                    num_gerado = 0;
                }
                
            }

        }
        
    }

    public void sortearNumeros(CartelaBingo cartela1, CartelaBingo cartela2) {

        
        do {
            
            int num_sorteado = gerador.nextInt(75) + 1;
                    
             
            if(!num_sorteados.contains(num_sorteado)){
            
            
            for (int posicao_linha = 0; posicao_linha < 3; posicao_linha++) {

                for (int posicao_coluna = 0; posicao_coluna < 3; posicao_coluna++) {


                    if (num_sorteado == cartela1.pegarElemento(posicao_linha, posicao_coluna) ) {

                        cartela1.setElemento(posicao_linha, posicao_coluna, 0);
                        System.out.println("O número sorteado foi: " + 
                                num_sorteado + "\n" + "A cartela do " + 
                                cartela1.getNome() + " possui esse número" + "\n");
                        
                       
                        
                        
                    } 
                    
                    if(num_sorteado == cartela2.pegarElemento(posicao_linha, posicao_coluna) ) {
                        
                        cartela2.setElemento(posicao_linha, posicao_coluna, 0);
                        System.out.println("O número sorteado foi: " + num_sorteado);
                        System.out.println("A cartela do " + cartela2.getNome()
                                + "  possui esse número" + "\n");
                   
                        
                    
                    } 
                    
                    
                    
                }
        
            }
           
            
            num_sorteados.add(num_sorteado);
        }
            
            System.out.println("O número sorteado foi: " + num_sorteado);
            System.out.println("O número sorteado não está em nenhuma das cartelas " + "\n");
            
        } while (cartela1.estaVazia() == false && cartela2.estaVazia() == false );
        
        if(cartela2.estaVazia() == true){
            System.out.println("O vencedor é: " + cartela2.getNome());
        }
        if(cartela1.estaVazia() == true){
            System.out.println("O vencedor é: " + cartela1.getNome());
        }
        
    }

    public boolean estaVazia() {

        boolean vazia = true;
        
        for (int i = 0; i < 3; i++) {
            
            for (int j = 0; j < 3; j++) {
                
                if(numeros[i][j] != 0 ){
                    
                    vazia = false;
                }
                
            }
            
            
        }
        
        return vazia;
    }
    
    public int pegarElemento(int pos_linha, int pos_coluna){
        
        int elemento;
                    
        return elemento = numeros[pos_linha][pos_coluna];
                
        
        }
    
    public void setElemento(int pos_linha, int pos_coluna, int numero){
        
        numeros[pos_linha][pos_coluna] = numero;
        
    }
    
    public void imprimirCartela(){
        
       for(int linha=0 ; linha < 3 ; linha++){
            for(int coluna = 0; coluna < 3 ; coluna ++){
                System.out.printf("\t %d \t",numeros[linha][coluna]);
            }
            System.out.println();
        }
       
        System.out.println();
    }
}

