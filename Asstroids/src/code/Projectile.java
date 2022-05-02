/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author 23richardsb
 */
public class Projectile {
    
    private Point pos = new Point();
    private double ang;
    
    private double velX = 2;
    private double velY = 2;
    
    public Projectile(Point pos_, double ang_, double vX, double vY){
        pos.x = pos_.x;
        pos.y = pos_.y;
        ang = ang_;
        velX += vX;
        velY += vY;
    }
    
    public void go(){
        pos.x += velX * Math.cos(ang);
        pos.y += velY * Math.sin(ang);
    }
    
    public void show(Graphics g){
        g.drawOval(pos.x, pos.y, 5, 5);
    }
}
