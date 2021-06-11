
package sirinleroyunu;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.TimerTask;





public class Pencere extends JPanel implements ActionListener{
    
 
    private final int genislik = 680;
    private final int yükseklik = 700;
    private final int gecikme= 25;
    public int[][] maze= new int[14][11];
    public static final Color VERY_LIGHT_RED = new Color(255,102,102,60);
    public static final Color VERY_LIGHT_YELLOW = new Color(230, 230, 255,60);
    
    private Image star,sirine,gozlukluimg,luke,kylo,azman,gargamel,tembelimg,red;
    private Image yol;
    
    public int a=6*35+100;
    public int b=5*35+130;
    public int yerx=6;
    public int yery=5;
    private int dx, dy;
    public int secilen=0;
    public int count;  
    public int hp=100;
    public int iyi;
    public int[] kötüler=new int[14];
     int u =0;
     public int score=20;
    //13 11------14 11
  
    public int[][] kkötüler= new int[14][2];
    public int[][] bkötüler= new int[14][2];
    int[] w=new int [2000];
    public Tembel tembel;
    public Gözlüklü gozluklu;
    public Azman azmancık;   
    public int gargamelId = 0;
    public int azmanId = 0;
    
         private Timer timer;
//    public TimerTask gorev;
//    public int suresayac=0;
     // AltinThread thread = new AltinThread(red, yol, yerx,  yery,maze);
    
    public Pencere() throws IOException {

//        thread.run(5.0);
//        thread.run(maze,red);
        
        String str = "Bunu dosyaya yazdir";
        String[] kotu =new String[10];
        
        Scanner sc = new Scanner(System.in);
        System.out.println("İyi karakteri seçiniz.\nTembel-->0\nGözlüklü-->1");
        iyi = sc.nextInt();
        count=0;
        int countt=0;
        File file = new File("Harita.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        String line;

        try (BufferedReader br = new BufferedReader(fileReader)) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if(parts[0].equals("Karakter")){
                    kotu[count]=line;
                    String[] parr = line.split(",");
                    if(parr[0].equals("Karakter:Gargamel")){
                        kötüler[count]=0;
                        gargamelId = count;
                        
                    }
                    
                    else if(parr[0].equals("Karakter:Azman")){
                        kötüler[count]=1;
                        azmanId=count;
                    } 
                    else kötüler[count]=2;
                    
                    if(parr[1].equals("Kapi:A")){
                        kkötüler[count][0]=3;
                        kkötüler[count][1]=0;
                        bkötüler[count][0]=3;
                        bkötüler[count][1]=0;
                        
                    }
                    else if(parr[1].equals("Kapi:B")){
                        kkötüler[count][0]=10;
                        kkötüler[count][1]=0;
                        bkötüler[count][0]=10;
                        bkötüler[count][1]=0;
                    }
                    else if(parr[1].equals("Kapi:C")){
                        kkötüler[count][0]=0;
                        kkötüler[count][1]=5;
                        bkötüler[count][0]=0;
                        bkötüler[count][1]=5;
                    }
                    else {
                        kkötüler[count][0]=3;
                        kkötüler[count][1]=10;
                        bkötüler[count][0]=3;
                        bkötüler[count][1]=10;
                    }
                    count++;
                }
                else{
                    String[] part = line.split("\t");
                    for (int i = 0; i < part.length; i++) {
                        
                        
                        
                        maze[i][countt]=Integer.parseInt(part[i]);
                        
                    }
                    countt++;
                    
                }
              
            }
            
        }
        
        for (int i = 0; i < 13; i++) {
            
        }
        tembel = new Tembel(yerx,yery,maze,score);
        gozluklu = new Gözlüklü(yerx,yery,maze,score);
        azmancık = new Azman(maze,kkötüler,bkötüler,iyi,score);
        
       initBoard();    }
    private void initBoard() {
          addKeyListener(new TAdapter());

        setFocusable(true);
        setBackground(new Color(174, 191, 190));
        
        setPreferredSize(new Dimension(genislik, yükseklik));

        loadImage();
        
        timer = new Timer(gecikme, this);
        timer.start();
           
       
    }
    @Override
   
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       
        drawStar(g);
    }

    private void drawStar(Graphics g) {
       
        
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 11; j++) {
                if (maze[i][j]==0){
                    g.drawImage(star, i*35+100, j*35+130, this);
                    }
                else{ g.drawImage(yol, i*35+100, j*35+130, this);
                }
            }
    
        }
        g.setColor(Color.yellow);
        g.fillRect(6*35+100, 5*35+130, 35, 35);
        g.setColor(Color.BLUE);
        g.fillRect(3*35+100, 0*35+130, 35, 35);
        g.fillRect(10*35+100, 0*35+130, 35, 35);
        g.fillRect(0*35+100, 5*35+130, 35, 35);
        g.fillRect(3*35+100, 10*35+130, 35, 35);
        g.drawImage(sirine, 13*35+100, 7*35+130, this);
        
        
        
      //  g.drawImage(thread.run(2), thread.run(5,0)*35+100, thread.run(5.0,5.0)*35+130, this);

        
        
        
        Toolkit.getDefaultToolkit().sync();
        if(secilen==0){
          secilen=1;  
        }
        
        if(iyi==0){
           g.drawImage(tembelimg, a, b, 35, 25, this);
        }
//      g.drawImage(cup, tembel.pixelX, tembel.pixelY, this);
//     g.drawImage(master, gozluklu.pixelX, gozluklu.pixelY, this);
        if(iyi==1){
           g.drawImage(gozlukluimg, a, b, 35, 25, this);
        }
        Dijkstra ms = new Dijkstra();
        if(dx==-1||dx==1||dy==1||dy==-1){
            for (int i = 0; i <count; i++) {
                int[] start = {kkötüler[i][0],kkötüler[i][1]};
                int[] end = {yerx,yery};
                
                if(kkötüler[gargamelId][0] == yerx && kkötüler[gargamelId][1]==yery){//gargamele çarpıyor mu?
                    score = score - 15;
                    System.out.println(" Puan : " + score);
                    if(score>=0){
                        a=6*35+100;
                        b=5*35+130;
                        yerx=6;
                        yery=5;
                        for (int j = 0; j < 2; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                      
                    }
                    if(score<=0){
                        
                        a=6*35+100;
                        b=5*35+130;
                        yerx=6;
                        yery=5;
                        for (int j = 0; j < 2; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                        
                        JOptionPane.showMessageDialog(null,"wasted");} 
                    continue;
                }
                if(kkötüler[azmanId][0] == yerx && kkötüler[azmanId][1]==yery){
                    score = score - 5;
                    System.out.println(" Puan : " + score);
                    if(score>=0){
                        a=6*35+100;
                        b=5*35+130;
                        yerx=6;
                        yery=5;
                        for (int j = 0; j < count; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                    }
                    if(score<=0){
                        
                          a=6*35+100;
                        b=5*35+130;
                        yerx=6;
                        yery=5;
                        for (int j = 0; j < 2; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                        
                        JOptionPane.showMessageDialog(null,"wasted");}  
                    continue;
                }
                
                if(ms.getPath(maze, start, end).get(1).x>0){
                    kkötüler[i][0]=ms.getPath(maze, start, end).get(1).x;//if 
                kkötüler[i][1]=ms.getPath(maze, start, end).get(1).y;
                 }
                if(kkötüler[gargamelId][0] == yerx && kkötüler[gargamelId][1]==yery){//gargamele çarpıyor mu?
                    score = score - 15;
                    System.out.println(" Puan : " + score);
                    if(score>=0){
                        a=6*35+100;
                        b=5*35+130;
                        yerx=6;
                        yery=5;
                        for (int j = 0; j < 2; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                      
                    }
                    if(score<=0){
                        
                          a=6*35+100;
                        b=5*35+130;
                        yerx=6;
                        yery=5;
                        for (int j = 0; j < 2; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                        
                        JOptionPane.showMessageDialog(null,"wasted");}  
                    continue;
                }
                if(kkötüler[azmanId][0] == yerx && kkötüler[azmanId][1]==yery){
                    score = score - 5;
                    System.out.println(" Puan : " + score);
                    if(score>=0){
                        a=6*35+100;
                        b=5*35+130;
                        yerx=6;
                        yery=5;
                        for (int j = 0; j < count; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                    }
                    if(score<=0){
                        
                          a=6*35+100;
                        b=5*35+130;
                        yerx=6;
                        yery=5;
                        for (int j = 0; j < 2; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                        
                        JOptionPane.showMessageDialog(null,"wasted");}  
                    continue;
                }
                
                //Garmagel 2 adım
                if(i == gargamelId){
                    start[0] = kkötüler[i][0]; start[1] = kkötüler[i][1];
                    end[0] = yerx ; end[1] = yery;
                if(ms.getPath(maze, start, end).get(1).x>0){
                    kkötüler[i][0]=ms.getPath(maze, start, end).get(1).x;//if 
                kkötüler[i][1]=ms.getPath(maze, start, end).get(1).y;
                }
                }
                //Garmagel 2 adım
                 if(kkötüler[gargamelId][0] == yerx && kkötüler[gargamelId][1]==yery){//gargamele çarpıyor mu?
                    score = score - 15;
                    System.out.println(" Puan : " + score);
                    if(score>=0){
                        a=6*35+100;
                        b=5*35+130;
                        yerx=6;
                        yery=5;
                        for (int j = 0; j < 2; j++) {
                            kkötüler[j][0]=bkötüler[j][0];
                            kkötüler[j][1]=bkötüler[j][1];
                        }
                      
                    }
                    if(score<=0)JOptionPane.showMessageDialog(null,"wasted"); 
                    continue;
                }
               
                 
                int[] s = {kkötüler[i][0],kkötüler[i][1]};
//                int [] r = {kkötüler[i][1]};
//                int [] p = {kkötüler[i][0]};
                int[] e = {yerx,yery};
//                System.out.println(ms.getPath(maze, p, e).getLast().dist);
//                System.out.println(ms.getPath(maze, r, e).getLast().dist);
               
                    if (kötüler[1]==0) {
                        if (u%2==0) {
                            System.out.print("Azman----->");
                        }
                       
                       else System.out.print("Gargamel-->");}
                  
                    if (kötüler[1]==1) {
                        
                        if (u%2==0) {
                            System.out.print("Gargamel-->");
                        }
                       
                       else System.out.print("Azman----->");}
                    
                     u++;
                  
                
                
                System.out.println(ms.getPath(maze, s, e).getLast().dist+" adımda ulaşır");

                 
          
                if(ms.getPath(maze, s, e).getLast().dist<1){
                    //Yakalanma anı
                     
                    if(kkötüler[gargamelId][0] == yerx && kkötüler[gargamelId][1]==yery){
                        //Gargamelin yakalama durumu    
                       score = score - 15;
                    }
                    else{
                        //Azmanın yakalama durumu    
                        score = score - 5;
                    }
                    System.out.println(" Puan : " + score);
                    
                }
                 
            }
        
        
            dx=0;
            dy=0;
            
        }
       
        
        for (int i = 0; i < count; i++) {
            
            int[] s = {kkötüler[i][0],kkötüler[i][1]};
            int[] e = {yerx,yery};
             for(int num=1; num<ms.getPath(maze, s, e).size()-1; num++)
                    {
                        if(i == gargamelId){
                            int xx = ms.getPath(maze, s, e).get(num).x;
                            int yy = ms.getPath(maze, s, e).get(num).y;        
                          
                            g.setColor(VERY_LIGHT_YELLOW);
                            g.fillRect(xx*35+100, yy*35+130, 35, 35);
                        }
                        else{
                            int xx = ms.getPath(maze, s, e).get(num).x;
                            int yy = ms.getPath(maze, s, e).get(num).y;        
                           g.setColor(VERY_LIGHT_RED);
                            g.fillRect(xx*35+100, yy*35+130, 35, 35);
                        }
                       // System.out.println(ms.getPath(maze, s, e).get(num));
                    }
            
            if(kötüler[i]==0)g.drawImage(gargamel, kkötüler[i][0]*35+100, kkötüler[i][1]*35+130, 35, 25, this);
            else g.drawImage(azman, kkötüler[i][0]*35+100, kkötüler[i][1]*35+130, 35, 25, this);
             //Yol çizme
            
             //Yol çizme
        } 
        
       
        
        
        
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/resources/star.png");
        star = ii.getImage();
        ImageIcon i1 = new ImageIcon("src/resources/road.png");
        yol = i1.getImage();
        ImageIcon i2 = new ImageIcon("src/resources/sirine.png");
        sirine = i2.getImage();
        ImageIcon i3 = new ImageIcon("src/resources/gözlüklü.png");
        gozlukluimg = i3.getImage();
        ImageIcon i4 = new ImageIcon("src/resources/tembel.png");
        tembelimg = i4.getImage();
        ImageIcon i6 = new ImageIcon("src/resources/azman.png");
        azman = i6.getImage();
        ImageIcon i7 = new ImageIcon("src/resources/gargamel.png");
        gargamel = i7.getImage();
        ImageIcon i5 = new ImageIcon("src/resources/red.png");
        red = i5.getImage();
     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }

   
    private class TAdapter extends KeyAdapter {

        
        
        
        
        @Override
        public void keyPressed(KeyEvent e) {

            tembel.hareket(e.getKeyCode());
           gozluklu.hareket(e.getKeyCode());
           
 
 int key = e.getKeyCode();
if(iyi==1){
    if (key == KeyEvent.VK_LEFT) {
        
        if(maze[yerx-1][yery]==1){
         
            dx = -1;
            a-=35;
            yerx-=1;
        }
    }

    if (key == KeyEvent.VK_RIGHT) {
        
        if(maze[yerx+1][yery]==1){
            dx = 1;
            a+=35;
            yerx+=1;
        }
        else if(yerx==12&&yery==7){
            a+=35;
            JOptionPane.showMessageDialog(null,"Score:"+score);
           
        }
    }

    if (key == KeyEvent.VK_UP) {
        
        if(maze[yerx][yery-1]==1){
            dy = -1;
            b-=35;
            yery-=1;
        }
    }

    if (key == KeyEvent.VK_DOWN) {
        
         if(maze[yerx][yery+1]==1){
            dy = 1;
            b+=35;
            yery+=1;
        }
    }
    dx=0;
    dy=0;
  
     if (key == KeyEvent.VK_LEFT) {
        
        if(maze[yerx-1][yery]==1){
         
            dx = -1;
            a-=35;
            yerx-=1;
          
          
        }
        
       
    }

    if (key == KeyEvent.VK_RIGHT) {
        
        if(maze[yerx+1][yery]==1){
            dx = 1;
            a+=35;
            yerx+=1;
        }
        else if(yerx==12&&yery==7){
            a+=35;
            JOptionPane.showMessageDialog(null,"Score:"+score);
           
        }
    }

    if (key == KeyEvent.VK_UP) {
        
        if(maze[yerx][yery-1]==1){
            dy = -1;
            b-=35;
            yery-=1;
        }
    }

    if (key == KeyEvent.VK_DOWN) {
        
         if(maze[yerx][yery+1]==1){
            dy = 1;
            b+=35;
            yery+=1;
        }
    }
    
    
    }
if(iyi==0)   {
if (key == KeyEvent.VK_LEFT) {
        
        if(maze[yerx-1][yery]==1){
         
            dx = -1;
            a-=35;
            yerx-=1;
          
          
        }
        
       
    }

    if (key == KeyEvent.VK_RIGHT) {
        
        if(maze[yerx+1][yery]==1){
            dx = 1;
            a+=35;
            yerx+=1;
        }
        else if(yerx==12&&yery==7){
            a+=35;
            JOptionPane.showMessageDialog(null,"Score:"+score);
           
        }
    }

    if (key == KeyEvent.VK_UP) {
        
        if(maze[yerx][yery-1]==1){
            dy = -1;
            b-=35;
            yery-=1;
        }
    }

    if (key == KeyEvent.VK_DOWN) {
        
         if(maze[yerx][yery+1]==1){
            dy = 1;
            b+=35;
            yery+=1;
        }
    }
   
    
}

}

     @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == Event.LEFT || key == Event.RIGHT
                    || key == Event.UP || key == Event.DOWN) {
                dx = 0;
                dy = 0;
            }
      }
    
    
        
}

  

    
    
}