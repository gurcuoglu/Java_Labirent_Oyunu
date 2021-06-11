/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirinleroyunu;

/**
 *
 * @author mypc
 */
public class Oyuncu  extends Karakterler{
    int OyuncuID;
    String OyuncuAdi;
    Boolean OyuncuTur;
    int Score;
    
    public int PuaniGoster(){return 0;};


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



}
