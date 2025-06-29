/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofinal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 *
 * @author Pichau
 */
public class RandomNImpl extends UnicastRemoteObject implements RandomNInterface {

    public RandomNImpl() throws RemoteException {
    }


    @Override
    public String gerarStringAleatoria(String senha ) throws RemoteException {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(senha.length());
        for (int i = 0; i < senha.length(); i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
