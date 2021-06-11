/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirinleroyunu;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author mypc
 */
public class AltinThread extends Thread{
    private Image red,yol;
    int a=0;
    int x=0,y=0;
    public int[][] maze= new int[14][11];
    Boolean d=true;
    Random r1 = new Random();

    public AltinThread(Image red, Image yol, int x, int y,int maze[][]) {
        this.red = red;
        this.yol = yol;
        this.x = x;
        this.y = y;
        this.maze=maze;
    }
    Random r2 = new Random();
    
    
    
    
     public void run(double b) {/// SÜRE RANDOM
         
         
        try{
                a=r2.nextInt(6)+5;
                AltinThread.sleep(a*1000);
           }
    catch(Exception e){
        System.out.println("hata");
    }
    }
     
     
    
    public void run(int maze[][],Image red) {////////KOORDİNAT RANDOM
      
        try{
               for (int i = 0; i < 10; i++) {
                
                 x=r1.nextInt(13);
                 y=r1.nextInt(10);
                if (maze[x][y]==0) {
                
                 }
                else continue;
                }
                d=true;
                AltinThread.sleep(5000);
                d=false;
                AltinThread.sleep((a-5)*1000);
           }
    catch(Exception e){
        System.out.println("hata");
    }
       
    }
  
    
     public Image run(int c) {////ÇİZDİRME
         
           try{
               if (d==true) {
                   return red;
               }
            }
    catch(Exception e){
        System.out.println("hata");
    }
         
         return yol;
    }
    
     public int run(int y,int t){
         return x;
     }
    
     public int run(double o,double p){
         return y;
     }
    
     
      private void loadImage() {

        ImageIcon ii = new ImageIcon("src/resources/red.png");
        red = ii.getImage();
        ImageIcon i1 = new ImageIcon("src/resources/road.png");
        yol = i1.getImage();
        
       
        
     
    }
    

}