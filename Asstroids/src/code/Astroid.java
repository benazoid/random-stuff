package code;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Astroid {
    public Polygon astroid = new Polygon();
    public Point loc;
    public Rectangle hitBox;
    
    public static ArrayList<Astroid> as = new ArrayList<>();
    
    public Astroid(Point loc_){
        loc = loc_;
        setPs(50);
    }
    
    public void setPs(int size){
        astroid.reset();
        for(int i = 0; i < 7; i++){
            astroid.addPoint((int)(size*(0.75+Math.random()/2)*Math.cos(Math.PI*2/7*i)) + 200, (int)(size*(0.75+Math.random()/2)*Math.sin(Math.PI*2/7*i)) + 200);
        }
    }
}
