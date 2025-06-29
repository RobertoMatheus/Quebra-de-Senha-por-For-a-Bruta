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

public class Server {
    public static void main(String[] args) {
        try {
            RandomNImpl obj = new RandomNImpl();
            // Create or get the RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1199); 
            // Bind the remote object to a name in the registry
            registry.rebind("HelloService", obj); 
            System.out.println("Server ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}