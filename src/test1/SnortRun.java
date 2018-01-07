/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class SnortRun extends Thread {
    javax.swing.JTextArea jTextArea1;
    String dir;
    volatile boolean exit;
    Runtime runtime = Runtime.getRuntime();
    Process proc;
    
    
    SnortRun(javax.swing.JTextArea TextArea1, String directory){
        jTextArea1 = TextArea1;
        dir = directory;
        exit = false;
        try {
            runtime.exec("touch "+dir+"/live.lock");
        } catch (IOException ex) {
            Logger.getLogger(SnortRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Stop(){
        proc.destroy();
        try {
            runtime.exec("rm -rf "+dir);
        } catch (IOException ex) {
            Logger.getLogger(SnortRun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void run(){
        try {
            runtime.exec("chmod +xw filedrop.sh");
            proc=runtime.exec("x-terminal-emulator --disable-factory -e ./filedrop.sh");

            
        } catch (IOException ex) {
            Logger.getLogger(SnortRun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
