package code;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

public class Ship {
    
    private Point pos = new Point(250,200);
    private double velX;
    private double velY;
    private double ang;
    
    private ArrayList<Projectile> projs = new ArrayList<>();
    
    double acc = 0.1;
    
    public void update(ArrayList<Boolean> keys){
        pos.x += velX;
        pos.y += velY;
        
        if(keys.get(KeyEvent.VK_A) || keys.get(KeyEvent.VK_LEFT)){
            ang -= 0.05;
        }
        if(keys.get(KeyEvent.VK_D) || keys.get(KeyEvent.VK_RIGHT)){
            ang += 0.05;
        }
        
        if(keys.get(KeyEvent.VK_UP) || keys.get(KeyEvent.VK_W)){
            if(velX*velX + velY*velY < 50){
                velX += acc * Math.cos(ang);
                velY += acc * Math.sin(ang);
            }
        }
        else{
            velX /= 1.04;
            velY /= 1.04;
            if(Math.abs(velX) < 0.1){
                velX = 0;
            }
            if(Math.abs(velY) < 0.1){
                velY = 0;
            }
        }
        
        if(keys.get(KeyEvent.VK_SPACE)){
            projs.add(new Projectile(pos,ang,velX,velY));
        }
        
        for(int i = 0 ; i < projs.size(); i++){
            projs.get(i).go();
        }
    }
    
    public void show(Graphics g){
        g.drawLine(pos.x, pos.y, (int)(pos.x + (20*Math.cos(ang))), (int)(pos.y + (20*Math.sin(ang))));
        for(int i = 0 ; i < projs.size(); i++){
            projs.get(i).show(g);
        }
    }
}
