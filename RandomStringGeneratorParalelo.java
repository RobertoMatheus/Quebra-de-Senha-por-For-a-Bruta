/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofinal;

/**
 *
 * @author Pichau
 */
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomStringGeneratorParalelo  {
    private int contador=0;
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder sb = new StringBuilder();
    boolean loop=true;
    
   

    public static void main(String[] args) {
        String senha = "123";
        //String stringAleatoria = gerarStringAleatoria(comprimentoDaString);
        //System.out.println("String aleatória: " + stringAleatoria);
        RandomStringGeneratorParalelo p=new RandomStringGeneratorParalelo();
        p.executaThreads(senha);
    } 
    
    public void executarContador(String senha,int t){        
        
        Random random = new Random();
        StringBuilder result=new StringBuilder();
            for (int i = 0; i < senha.length(); i++) {
            int index = random.nextInt(caracteres.length());
            result.append(caracteres.charAt(index));
        }
            System.out.println(""+result+" thread"+t);
        if(result.toString().equals(senha)||loop==false){
            loop=false;
        }
    }
    
    public void executaThreads(String senha){

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                do {
                   executarContador(senha,1);
                   contador++; 
                } while (loop);
                loop=false;
            }
            
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                do{
                   executarContador(senha,2);
                   contador++; 
                } while (loop);
                loop=false;
            }
            
        });  t1.start();
        t2.start();     
        
        try {
            t1.join();
            t2.join();
            System.out.println("A senha é: "+senha);
            System.out.println("Numero de tentativas: "+contador);
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomStringGeneratorParalelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
