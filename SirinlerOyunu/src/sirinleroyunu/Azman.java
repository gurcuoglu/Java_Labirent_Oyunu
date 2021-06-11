
package sirinleroyunu;

import javax.swing.JOptionPane;



public class Azman extends Düsman{
    //Hareket ---- olayları kontrol etme
    public int[][] maze= new int[14][11];
    public int[][] kkötüler= new int[14][2];
    public int[][] bkötüler= new int[14][2];
    public int yerX, yerY;
    public int hp=100;
    public int iyi;
    public int a,b,count=2;
    int DüsmanID = 4;
    String DüsmanAdi ="Azman";
    Boolean DusmanTur=false;
    int ID = 4;
    String Ad = "Azman";
    Boolean Tur=false;
    int score;
    int u ;
    public Azman(int maze[][],int kkötüler[][],int bkötüler[][],int iyi,int score){
        this.maze=maze;
        this.kkötüler=kkötüler;
        this.bkötüler=bkötüler;
        this.iyi = iyi ;
        this.score=score;
    }

    public int getDüsmanID() {
        return DüsmanID;
    }

    public void setDüsmanID(int DüsmanID) {
        this.DüsmanID = DüsmanID;
    }

    public String getDüsmanAdi() {
        return DüsmanAdi;
    }

    public void setDüsmanAdi(String DüsmanAdi) {
        this.DüsmanAdi = DüsmanAdi;
    }

    public Boolean getDusmanTur() {
        return DusmanTur;
    }

    public void setDusmanTur(Boolean DusmanTur) {
        this.DusmanTur = DusmanTur;
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
    
    
    public int hareket(){
        Dijkstra ms = new Dijkstra();
        
        if(kkötüler[DüsmanID][0] == yerX && kkötüler[DüsmanID][1]==yerY){
                    score = score - 5;
                    System.out.println(" Puan : " + score);
                    if(score>=0){
                        a=6*35+100;
                        b=5*35+130;
                        yerX=6;
                        yerY=5;
                        for (int j = 0; j < count; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                    }
                    if(score<=0){
                        
                          a=6*35+100;
                        b=5*35+130;
                        yerX=6;
                        yerY=5;
                        for (int j = 0; j < 2; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                        
                        JOptionPane.showMessageDialog(null,"wasted1");}  
                    
                }
        
        
            for (int i = 0; i <count; i++) {
                int[] start = {kkötüler[i][0],kkötüler[i][1]};
                int[] end = {yerX,yerY};
                if(ms.getPath(maze, start, end).get(1).x>0){
                kkötüler[i][0]=ms.getPath(maze, start, end).get(1).x;//if 
                kkötüler[i][1]=ms.getPath(maze, start, end).get(1).y;
                
                }
                int[] s = {kkötüler[i][0],kkötüler[i][1]};
                int[] e = {yerX,yerY};
                System.out.println(ms.getPath(maze, s, e).getLast().dist);
                if(ms.getPath(maze, s, e).getLast().dist<1){
                    if(iyi==1&&hp>1){
                        hp-=2;
                        a=6*35+100;
                        b=5*35+130;
                        yerX=6;
                        yerY=5;
                        for (int j = 0; j < count; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                    }
                    if(iyi==1&&hp<1)JOptionPane.showMessageDialog(null,"wasted");
                    if(iyi==0&&hp>0){
                        hp-=1;
                        yerX=6;
                        yerY=5;
                        a=6*35+100;
                        b=5*35+130;
                        for (int j = 0; j < count; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                        
                    }
                    if(iyi==0&&hp==0)JOptionPane.showMessageDialog(null,"wasted");
                }
            }
         if(kkötüler[DüsmanID][0] == yerX && kkötüler[DüsmanID][1]==yerY){
                    score = score - 5;
                    System.out.println(" Puan : " + score);
                    if(score>=0){
                        a=6*35+100;
                        b=5*35+130;
                        yerX=6;
                        yerY=5;
                        for (int j = 0; j < count; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                    }
                    if(score<=0){
                        
                          a=6*35+100;
                        b=5*35+130;
                        yerX=6;
                        yerY=5;
                        for (int j = 0; j < 2; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                        
                        JOptionPane.showMessageDialog(null,"wasted1");}  
                    
                }
        
          if (kkötüler[1][0]==0) {
                        if (u%2==0) {
                            System.out.print("Azman----->");
                        }
                       
                       else System.out.print("Gargamel-->");}
                  
                    if (kkötüler[1][0]==1) {
                        
                        if (u%2==0) {
                            System.out.print("Gargamel-->");
                        }
                       
                       else System.out.print("Azman----->");}
                    
                     u++;
                  
                int[] s = {kkötüler[u][0],kkötüler[u][1]};
                int[] e = {yerX,yerY};
                System.out.println(ms.getPath(maze, s, e).getLast().dist+" adımda ulaşır");
         
          return 90;
        
    }
    
    
}
