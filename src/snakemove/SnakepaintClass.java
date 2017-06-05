
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakemove;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author thaku
 */
public class SnakepaintClass extends JComponent implements ActionListener, KeyListener{
    private int start=0;
  private ImageIcon images;
  private Timer timer=new Timer(100,this);
  
 private boolean colide=false;
 // private int yval=1;
  
  private int[] xpos=new int[200];
  private int[]ypos=new int[200];
  private String[] body=new String[200];
  private String[] tail=new String[200];
  
  private int headxpos=200;
  private int headypos=405;
  private int randx;
  private int randy;
  private int score=0;
  private int ballcol=0;
  
  private boolean up=false;
   private boolean down=false;
    private boolean right=false;
     private boolean left=false;
  private boolean play=false;
  private int tailpos=3;
  private String head="images/headleft.gif";
   public void SnakePaintClass()
   {
     xpos[0]=825; ypos[0]=405;
     xpos[1]=852; ypos[1]=406;
     xpos[2]=867; ypos[2]=406;
     xpos[3]=882; ypos[3]=406;
     xpos[4]=897; ypos[4]=406;
     body[0]="images/bodyright.gif";
     body[1]="images/bodyright.gif";
     body[2]="images/bodyright.gif";
     tail[3]="images/tailright.gif"; 
    
     
   }
   public void randomcl()
   {
   randx=((int)(Math.random()*52)+3)*15;
   randy=((int)(Math.random()*48)+12)*15;
   while(randx>=150&&randx<=650&&randy>=300&&randy<=320)
   {
   randx=((int)(Math.random()*52)+3)*15;
   randy=((int)(Math.random()*48)+12)*15;
   }
   }
  
    public void paint(Graphics g)
    {
       

        if(!play)
            SnakePaintClass();
        if(start==0)
        {
        randomcl();
         start=1;
        }
     g.setColor(Color.WHITE);
     g.fillRect(50, 180, 800, 800);
   // images=new ImageIcon(this.getClass().getResource("images/lefthead.png"));
    // images.paintIcon(this, g, 50, 180);
   
    g.setColor(Color.red);
    g.drawString("score"+score, 800, 190);
    if(ballcol==0)
    {
        g.fillOval(randx, randy, 15, 15);
    }
    else{
    g.setColor(Color.MAGENTA);
    g.fillOval(randx, randy, 15, 15);
    }
    
    g.setColor(Color.GREEN);
     images =new ImageIcon(this.getClass().getResource(head));
    images.paintIcon(this, g, xpos[0], ypos[0]);
   images=new ImageIcon(this.getClass().getResource(body[0]));
   for(int i=0;i<200;i++)
   {
       if(i>0&&body[i]!=null)
       { images=new ImageIcon(this.getClass().getResource(body[i]));
       images.paintIcon(this, g, xpos[i], ypos[i]);
   
          tailpos=i+1;
       } 
   }
    images=new ImageIcon(this.getClass().getResource(tail[tailpos]));
    images.paintIcon(this, g, xpos[tailpos], ypos[tailpos]);
   // g.fillOval(xpos[1], ypos[1],20,20);
    //  g.fillOval(xpos[2], ypos[2],20,20);
     //  g.fillOval(xpos[3], ypos[3],20,20);
     images=new ImageIcon(this.getClass().getResource("images/Capture.png"));
    images.paintIcon(this, g, 50, 00);
      g.setColor(Color.BLUE);
     g.fillRect(0, 170, 900, 10);
     g.fillRect(0, 0, 50, 910);
      g.fillRect(850, 0, 50, 910);
       g.fillRect(0, 910, 900, 100);
        g.fillRect(0, 0, 900, 10);
        g.setColor(Color.DARK_GRAY);
         g.fillRect(150,300 ,500, 20);
    addKeyListener(this);
    setFocusable(true);
    requestFocusInWindow();
    setFocusTraversalKeysEnabled(false);
    //timer=new Timer(100,this);
    
    if(play&&tailpos<=10&&!colide)
       timer.start();
    else if(play&&tailpos>10||colide)
    {
        timer.stop();
        g.setColor(Color.red);
        Font myFont = new Font ("Garamond",Font.ITALIC|Font.BOLD, 30);
        g.setFont(myFont);
        g.drawString("Your total score: "+score, 200, 450);
        Font newFont=myFont.deriveFont(70F);
        g.setFont(newFont);
        g.drawString("Game Over:", 200, 400);
        if(tailpos<10)
            g.drawString("You Loose the game:", 200, 500);
        else
            g.drawString("You wiln!:", 200, 500);
            
        
    }
    }
     
    @Override
     public void actionPerformed(ActionEvent e) {
       
    if(left)
      {
          for(int i=xpos.length-1;i>0;i--)
          {
              if(i==1)
              {
                 xpos[i]=xpos[i-1]+12;
                 ypos[i]=ypos[i-1]+1;
                  body[i]= body[i-1];
                 //tail[i-1]=tail[i];
              }
              else{
                xpos[i]=xpos[i-1];
                ypos[i]=ypos[i-1];
                if(body[i]!=null)
                   body[i]= body[i-1];
                if(i<=tailpos&&i>2)
                {
                 tail[i]=tail[i-1];
                }
              }
          }
         
          tail[3]="images/tailright.gif";
          body[0]="images/bodyright.gif";
           xpos[0]-=15;
      }
    if( right)
      {
          
          for(int i=xpos.length-1;i>0;i--)
          {
             if(i==1)
              {
                 xpos[i]=xpos[i-1]-2;
                 ypos[i]=ypos[i-1]+1;
                  body[i]= body[i-1];
              }
              else{
                xpos[i]=xpos[i-1];
                ypos[i]=ypos[i-1];
                if(body[i]!=null)
                    body[i]= body[i-1];
                if(i<=tailpos&&i>2)
                {
                 tail[i]=tail[i-1];
                }
              }

          
          }
          
           tail[3]="images/tailleft.gif";
          body[0]="images/bodyleft.gif";
        xpos[0]+=15;
      }
    if(up)
      {
          
          for(int i=xpos.length-1;i>0;i--)
          {
              if(i==1)
              {
              ypos[i]=ypos[i-1]+12;
              xpos[i]=xpos[i-1];
              body[i]=body[0];
              }
              else{
            
                 xpos[i]=xpos[i-1];
                 ypos[i]=ypos[i-1];
                 if(body[i]!=null)
                    body[i]= body[i-1];
                 if(i<=tailpos&&i>2)
                {
                 tail[i]=tail[i-1];
                }
              }
            
          }
           tail[3]="images/taildown.gif";
          body[0]="images/bodydown.gif";
        ypos[0]-=15;
       
        //headypos-=4;
      }
    if(down)
      {
           for(int i=xpos.length-1;i>0;i--)
          {
             if(i==1)
              {
                  ypos[i]=ypos[i-1]-2;
                  xpos[i]=xpos[i-1];
                   body[i]= body[i-1];
              }
              else
             {
                xpos[i]=xpos[i-1];
                ypos[i]=ypos[i-1];
                if(body[i]!=null)
                 body[i]= body[i-1];
                if(i<=tailpos&&i>2)
                {
                 tail[i]=tail[i-1];
                }
             }
              }
            tail[3]="images/tailup.gif";
          body[0]="images/bodyup.gif";
        ypos[0]+=15;
        //headypos+=4;
      }

     if(xpos[0]<=40)
            {
                
            xpos[0]=850;
            }
     if(xpos[0]>=860)
            {
                
            xpos[0]=50;
            }
     if(ypos[0]<=170)
            {
                
            ypos[0]=910;
            }
     if(ypos[0]>=930)
            {     
            ypos[0]=180;
            }
     
     
     A:if(left){
         if(new Rectangle(xpos[0],ypos[0]+5,10,10).intersects(new Rectangle(randx,randy,15,15)))
         {
             start=0;
             score+=10;
             if(ballcol==0)
             {
                 ballcol=1;
             }
             else
                 ballcol=0;
             for(int i=0;i<body.length-1;i++)
             {
             if(body[i]==null)
             {
             body[i]=body[i-1];
              tail[i+1]=tail[i];
             break A;
             }
             }
         }
     }
     A: if(down){
             if(new Rectangle(xpos[0]+5,ypos[0]+17,10,10).intersects(new Rectangle(randx,randy,15,15)))
             {
              start=0;
              score+=10;
               if(ballcol==0)
             {
                 ballcol=1;
             }
             else
                 ballcol=0;
              for(int i=0;i<body.length-1;i++)
             {
             if(body[i]==null)
             {
             body[i]=body[i-1];
              tail[i+1]=tail[i];
             break A;
             }
             }
             }
     }
     A:if(right){
          if(new Rectangle(xpos[0]+17,ypos[0]+5,10,10).intersects(new Rectangle(randx,randy,15,15)))
          {
             start=0;
          score+=10;
           if(ballcol==0)
             {
                 ballcol=1;
             }
             else
                 ballcol=0;
           for(int i=0;i<body.length-1;i++)
             {
             if(body[i]==null)
             {
             body[i]=body[i-1];
             tail[i+1]=tail[i];
             break A;
             }
             }
          }
     }
     A: if(up){
          if(new Rectangle(xpos[0]+5,ypos[0],10,10).intersects(new Rectangle(randx,randy,15,15)))
          {
            start=0;
            score+=10;
             if(ballcol==0)
             {
                 ballcol=1;
             }
             else
                 ballcol=0;
           for(int i=0;i<body.length-1;i++)
             {
             if(body[i]==null)
             {
             body[i]=body[i-1];
              tail[i+1]=tail[i];
             break A;
             }
             }
          }
      }
     if(new Rectangle(xpos[0],ypos[0],24,24).intersects(new Rectangle(150,300,500,20)))
     {
     colide=true;
     }
      repaint();
        
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
         }

    @Override
    public void keyPressed(KeyEvent e) {
       // timer.start();
        int c=e.getKeyCode();
        play=true;
        if(!left&&c==KeyEvent.VK_RIGHT)
        {
        right=true;
        left=false;
        up=false;
        down=false;
         head="images/headright.gif";
        }
        if(!up&&c==KeyEvent.VK_DOWN)
        {
       right=false;
        left=false;
        up=false;
        down=true;
        head="images/headdownn.gif";
        }
         if(!down&&c==KeyEvent.VK_UP)
        {
        right=false;
        left=false;
        up=true;
        down=false;
         head="images/headup.gif";
        }
        if(!right&&c==KeyEvent.VK_LEFT)
        {
       right=false;
        left=true;
        up=false;
        down=false;
        head="images/headleft.gif";
        }
        repaint();
        }

    @Override
    public void keyReleased(KeyEvent e) {
          }
    
}
