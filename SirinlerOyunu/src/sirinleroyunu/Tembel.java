/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirinleroyunu;

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author mypc
 */
public class Tembel extends Oyuncu {
    //hareket-----puanlama----olayları kontrol etme
    public int[][] maze= new int[14][11];
    public int konumX, konumY;
    public int pixelX=6*35+100;
    public int pixelY=5*35+130;
    int score;
    int OyuncuId= 1;
    Boolean Tur = true;
    int ID =1;
    String Ad = "Tembel Şirin";
    String OyuncuAdi = "Player1";
    public Tembel(int x, int y, int maze[][],int score){
        this.maze = maze;
        konumX=x;
        konumY=y;
        this.score=score;
    }

    public int getOyuncuID() {
        return OyuncuID;
    }

    public void setOyuncuID(int OyuncuID) {
        this.OyuncuID = OyuncuID;
    }

    public String getOyuncuAdi() {
        return OyuncuAdi;
    }

    public void setOyuncuAdi(String OyuncuAdi) {
        this.OyuncuAdi = OyuncuAdi;
    }

    public Boolean getOyuncuTur() {
        return OyuncuTur;
    }

    public void setOyuncuTur(Boolean OyuncuTur) {
        this.OyuncuTur = OyuncuTur;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public Boolean getTur() {
        return Tur;
    }

    public void setTur(Boolean Tur) {
        this.Tur = Tur;
    }

    
    
    public void hareket(int key){
    if (key == KeyEvent.VK_LEFT) {
        
        if(maze[konumX-1][konumY]==1){
            pixelX-=35;
            konumX-=1;

        }
    }

    if (key == KeyEvent.VK_RIGHT) {
        
        if(maze[konumX+1][konumY]==1){
           
            pixelX+=35;
            konumX+=1;
        }
        else if(konumX==12&&konumY==7){
            pixelX+=35;
            JOptionPane.showMessageDialog(null,"KAZANDINIZ");
           
        }
    }

    if (key == KeyEvent.VK_UP) {
        
        if(maze[konumX][konumY-1]==1){
            
            pixelY-=35;
            konumY-=1;
        }
    }

    if (key == KeyEvent.VK_DOWN) {
        
         if(maze[konumX][konumY+1]==1){
            
            pixelY+=35;
            konumY+=1;
        }
    }
    }

    @Override
    public int PuaniGoster() {
        return score;
    }
  
    
    
    
    
    
    }
    
    

