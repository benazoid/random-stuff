package code;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

public class Ship {
    
    private static int length = 20;
    
    public Point pos = new Point(250,200);
    public double velX;
    public double velY;
    public double ang;
    
    private ArrayList<Projectile> projs = new ArrayList<>();
    
    double acc = 0.1;
    
    public void update(ArrayList<Boolean> keys){
        
        //Astroid.as;
        
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
            projs.add(new Projectile(new Point((int)(pos.x + length*Math.cos(ang)),(int)(pos.y + length*Math.sin(ang))),ang,Math.sqrt(velX*velX+velY*velY)));
        }
        
        for(int i = 0 ; i < projs.size(); i++){
            projs.get(i).go();
        }
        
        if(!new Rectangle(0,0,500,500).contains(pos)){
            
            Point p = getColPos(new Rectangle(0,0,500,500),pos);
            velX *= p.x;
            velY *= p.y;
            
        }
    }
    
    public void show(Graphics g){
        g.drawLine(pos.x, pos.y, (int)(pos.x + (20*Math.cos(ang))), (int)(pos.y + (20*Math.sin(ang))));
        for(int i = 0 ; i < projs.size(); i++){
            projs.get(i).show(g);
        }
    }
    
    public ArrayList<Projectile> getProjs(){
        return projs;
    }
    
    private Point getColPos(Rectangle r1, Point p) {
        double x1 = (r1.x + Math.floor((r1.width) / 2));
        double y1 = (r1.y + Math.floor((r1.height) / 2));
        double x2 = (p.x);
        double y2 = (p.y);
        double distH, distV;
        String horiz, vert;

        distH = Math.abs(x1 - x2);
        distV = Math.abs(y1 - y2);

        if (distH >= distV) {
            return new Point(-1, 1);
        } else {
            return new Point(1, -1);
        }
    }
}
