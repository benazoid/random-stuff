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
    
    private double vel = 3;
    
    public Projectile(Point pos_, double ang_, double v){
        pos.x = pos_.x;
        pos.y = pos_.y;
        ang = ang_;
        vel += v;
    }
    
    public void go(){
        pos.x += vel * Math.cos(ang);
        pos.y += vel * Math.sin(ang);
    }
    
    public void show(Graphics g){
        g.drawOval(pos.x, pos.y, 5, 5);
    }
}
