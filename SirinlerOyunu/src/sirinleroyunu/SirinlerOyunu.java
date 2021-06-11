/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirinleroyunu;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Fsociety
 */
public class SirinlerOyunu extends JFrame{



    public SirinlerOyunu() throws IOException {
        
        initUI();
    }
    
    private void initUI() throws IOException {
        
        add(new Pencere());
        
        setResizable(false);
        pack();
        
        setTitle("StarWars");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        
        EventQueue.invokeLater(() -> {
            try {
                SirinlerOyunu ex = new SirinlerOyunu();
                ex.setVisible(true);
            } catch (IOException ex1) {
                Logger.getLogger(SirinlerOyunu.class.getName()).log(Level.SEVERE, null, ex1);
            }
        });
    }
}
