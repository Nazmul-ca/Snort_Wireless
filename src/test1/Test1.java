/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;
/**
 *
 * @author nazmul
 */
class Test1 {

    /**
     * @param args the command line arguments
     */
    public void df(String[] args) {
        try {
            System.out.println("Opening notepads");
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("D:/Program Files/Wireshark/wireshark -D");
            
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(proc.getErrorStream()));
            
            System.out.println("Here is the standard output of the command:\n");
            
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) { System.out.println(ex);  }

            
        
        
        
        
        
        
    }
    
}
