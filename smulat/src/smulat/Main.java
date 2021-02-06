/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smulat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.sqrt;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Main {
public static void main(String[] args) {
        JFrame form=new JFrame("Monte-Carlo Simulation")  ;
        form.setVisible(true);
        form.setBackground(Color.lightGray)  ;
        form.add(new PaintPanel())   ;
        form.setSize(600, 600);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setVisible(true);
    }
}

class PaintPanel extends JPanel implements Runnable{
    private int x1,y1,x2,x,y2,y,r,r2 ,h1=100,m2=0,c=0,d=0,rx1,ry1,rnnum=0,n,sn;
    double crn=0;

    private Random rnd=new Random();
     Graphics g ;

    public PaintPanel(){
        //    ...............................r.............\\
 
 String sr = JOptionPane.showInputDialog(this, "Enter Radius Of The Circle Please") ;
 r = Integer.parseInt(sr) ;
//    ...................x,y.........................\\
// String sx = JOptionPane.showInputDialog(this, "enter x please") ;
// String sy = JOptionPane.showInputDialog(this, "enter y please") ;
// y = Integer.parseInt(sy) ;
// x = Integer.parseInt(sx) ;
 
 
 x=130;
 y=-130;
 
 
//..........................................................
        Thread th1=new Thread(this);
        th1.start();
    }
    @Override
    public void paintComponent(Graphics g){
    {
                 
                 g.setColor(Color.BLACK) ;
                 g.drawArc(141 + x - r ,151 - y - r,r *2 ,r * 2, 60, 360)  ;
                 g.setColor(Color.black) ;
                 g.drawLine(0, 290, 600, 290)  ;
                 g.drawLine(280, 0, 280, 600)  ;
                 g.setColor(Color.RED) ;
                 g.drawLine(141 + x + r , 0, 141 + x + r , 600)  ;
                 g.drawLine(141 + x - r , 0, 141 + x - r , 600)  ;
                 g.drawLine(0, 151 - y -r, 600, 151 - y -r)  ;
                 g.drawLine(0, 151 - y +r, 600, 151 - y +r)  ;
                 g.setColor(new Color(rnd.nextInt(255),rnd.nextInt(255) , rnd.nextInt(255)));
                 rx1 =  x  +rnd.nextInt( r )  - rnd.nextInt( r );
                 
                 ry1 =  y  + rnd.nextInt( r )  - rnd.nextInt( r ) ;
      
                 //JOptionPane.showMessageDialog(null,"crn : " +rx1+ry1);
                 g.fillArc(141 + rx1 ,151-  ry1, 2, 2, 60, 360) ;
                 rnnum  = ( (rx1 - x ) * (rx1 - x )) + ( (ry1 -y ) * (ry1 - y ))  ;
                 if (sqrt(rnnum) <= r )
                 { crn++ ;}       
    }
    }

    public void run() {
String sn = JOptionPane.showInputDialog(this, "Enter number of the points") ;
 n = Integer.parseInt(sn) ;

        for(int cn = 1 ; cn<n ; cn++) {
            try{
                 repaint();
                synchronized(this){
                Thread.sleep(1)  ;
                }
            }catch(Exception e){}
        }
 JOptionPane.showMessageDialog(null,"crn : " +crn);
double  sp =( crn / n ) * ((r+r) * (r+r)) ;
        JOptionPane.showMessageDialog(null,"Monte-Carlo Result ="  + sp + "\n Real Answer ="+ 3.14*r*r) ;
    }
}