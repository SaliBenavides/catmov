/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
    
    private int xref = 10;
    private int xGato = 0;
    private int numImagen = 0;
    private final int delay = 50;//cada 25 ms
    private Timer timer;
    
    public Board(){
        timer = new Timer (this.delay,this);
        timer.start();
        boolean llego = false;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  
        
        Image fondo = loadImage ("fondo.png");
        g.drawImage(fondo,0,0,null);
        
        Image cat = loadImage("cats.gif");
        g.drawImage(cat, this.xGato, 340, (this.xGato+132), 420, (this.numImagen*132), 0, (this.numImagen*132)+132, 80, this);
        //g.drawImage(cat, 152, 340, 152+132, 420, 264, 0, 396, 80, this);
        
        //Trapecio
        g.setColor(Color.DARK_GRAY);
        int x1[] = {xref+10,xref+20,xref+30,xref+40};
        int y1[] = {440,425,425,440};
        g.fillPolygon(x1,y1,4);
        
        //Rectángulo
        g.setColor(Color.red);
        int x2[] = {xref,xref,xref+55,xref+55};
        int y2[] = {440,455,455,440};
        g.fillPolygon(x2,y2,4);
        
        //Llantas
        g.setColor(Color.BLACK);
        g.fillOval(xref+10, 450, 15, 15);
        g.fillOval(xref+30, 450, 15, 15);
        
        //Rectángulo
        g.drawRect(xref, 425, 55, 40);
        Rectangle carro = new Rectangle (xref, 425, 55, 40);
        
        
        //Ovalo
        g.setColor(Color.MAGENTA);
        g.fillOval(1024-xref, 425, 40, 40);
        g.drawRect(1024-xref, 425, 40, 40);
        Rectangle oval = new Rectangle (1024-xref, 425, 30, 30);
        
        if (carro.intersects(oval)){
            //this.timer.stop();
        }
        
        
    }
       
    @Override
    public void actionPerformed(ActionEvent e){        
        this.xref+=5;
        this.xGato+=3;
        this.numImagen++;
        
        if (this.numImagen==6){
            this.numImagen=0;
        }
        repaint();
        
    }
    
    public Image loadImage (String imageName){
        ImageIcon ii = new ImageIcon (imageName);
        Image image = ii.getImage();
        return image;
    }
    
}