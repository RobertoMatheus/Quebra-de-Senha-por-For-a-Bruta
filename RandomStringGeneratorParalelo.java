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
    public static String gerarStringAleatoria(int comprimento) {
        
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(comprimento);
        
        
        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
                    }
   

    public static void main(String[] args) {
        int comprimentoDaString = 3;
        String senha = "123";
        //String stringAleatoria = gerarStringAleatoria(comprimentoDaString);
        //System.out.println("String aleatória: " + stringAleatoria);
        RandomStringGeneratorParalelo p=new RandomStringGeneratorParalelo();
        p.executaThreads(senha);
    } 
    
    public boolean executarContador(String senha){        
        
        Random random = new Random();
        StringBuilder result=new StringBuilder();
            for (int i = 0; i < senha.length(); i++) {
            int index = random.nextInt(caracteres.length());
            result.append(caracteres.charAt(index));
            
        }
            System.out.println(""+result);
        if(result.toString().equals(senha)){
            System.out.println("A senha é: "+senha);
            return false;
        }
            return true;
    }
    
    public void executaThreads(String senha){

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
        boolean loop = true;
                do {
                   loop= executarContador(senha);
                    
                } while (loop);
                
            }
            
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
        boolean loop = true;
                do{
                   loop= executarContador(senha);
                } while (loop);
            }
            
        });t1.start();
        t2.start();       
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomStringGeneratorParalelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}