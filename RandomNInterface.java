/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofinal;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pichau
 */
public interface RandomNInterface extends Remote{
   String gerarStringAleatoria(String senha) throws RemoteException;
}
