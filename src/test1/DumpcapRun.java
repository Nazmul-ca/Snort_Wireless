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
 * @author nazmul
 */
public class DumpcapRun extends Thread {
    String netinterface;
    Runtime runtime = Runtime.getRuntime();
    Process proc;
    String dir;
    SnortRun th2;

    DumpcapRun(String intrfc, String directory, javax.swing.JTextArea jTextA){
        netinterface = intrfc;
        dir = directory;
        th2 = new SnortRun(jTextA, dir);
        th2.start();
    }
    public void run(){
        
            try{
                System.out.println(dir);
                runtime.exec("mkdir "+dir);
                 
                String cmd = "dumpcap -i"+netinterface+" -b duration:3 -w "
                        +dir+"/a.pcap";
                //String cmd = "D:\\Program Files\\Wireshark\\dumpcap -D";
                proc = runtime.exec(cmd); 
                BufferedReader stdInput = new BufferedReader(new 
                     InputStreamReader(proc.getInputStream()));
                BufferedReader stdError = new BufferedReader(new 
                     InputStreamReader(proc.getErrorStream()));
                String s = null;
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }
                while ((s = stdError.readLine()) != null) {
                    System.out.println(s);
                }
            }catch(Exception e){}
        //}

    }
    
    public void Stop(){
        proc.destroy();
        th2.Stop();
        
        
    }
  }
