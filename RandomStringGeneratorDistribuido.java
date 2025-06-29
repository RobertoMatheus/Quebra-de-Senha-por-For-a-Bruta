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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RandomStringGeneratorDistribuido {
    public static void main(String[] args) {
        try {
            String senha ="123";
            // Get the RMI registry from the server's host and port
            Registry registry = LocateRegistry.getRegistry("localhost", 1199); 
            // Look up the remote object by its bound name
            RandomNInterface stub = (RandomNInterface) registry.lookup("HelloService"); 
            // Invoke the remote method
            boolean loop = true;
            do {
                
            String response = stub.gerarStringAleatoria(senha);
                if (response.equals(senha)) {
                    loop=false;
                    System.out.println("A senha é: "+senha);
                }
                else{
                    System.out.println(""+response);
                }
            } while (loop);
            
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}