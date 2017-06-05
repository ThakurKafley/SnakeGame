/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakemove;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author thaku
 */
public class SnakeMove {

   
    public static void main(String[] args) {
       JFrame frame= new JFrame();
       JComponent snakePanel=new SnakepaintClass();
       frame.setSize(900, 1000);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       frame.setResizable(false);
       frame.setTitle("Hungry Snake");
       frame.add(snakePanel);
    }
    
}
