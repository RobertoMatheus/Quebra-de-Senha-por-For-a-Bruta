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

public class RandomStringGenerator {

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
        boolean loop = true;
        do {
            
        String stringAleatoria = gerarStringAleatoria(comprimentoDaString);
            System.out.println("A senha é: "+stringAleatoria);
        if (stringAleatoria.equals(senha)) {
            loop=false;
        }
        } while (loop);
        
    }
}