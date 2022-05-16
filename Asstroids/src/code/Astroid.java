package code;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Astroid {

    public Polygon astroid = new Polygon();
    public Rectangle hitBox;
    public double velX = 0;
    public double velY = 0;
    public double ang;
    public int size = 50;
    public int count = 0;
    public static ArrayList<Astroid> as = new ArrayList<>();

    public Astroid(Point p) {
        setPs(size);
        while (astroid.intersects(new Rectangle(150, 150, 200, 200))) {
            astroid.translate((int) (Math.random() * 600) - 300, (int) (Math.random() * 400) - 200);
        }

        while (Math.abs(velX) < 1 || Math.abs(velY) < 1) {
            velX = (4 * Math.random()) - 2;
            velY = (4 * Math.random()) - 2;
        }
    }

    public int getSize() {
        return size;
    }

    public void resetPs(int size) {
        Point p = astroid.getBounds().getLocation();
        for (int i = 0; i < 7; i++) {
            astroid.xpoints[i]= ((int) (size * (0.25 + Math.random() / 2) * Math.cos(Math.PI * 2 / 7 * i)) + ave(astroid).x+20);
            astroid.ypoints[i]= ((int) (size * (0.25 + Math.random() / 2) * Math.sin(Math.PI * 2 / 7 * i)) + ave(astroid).y+20);
        }
    }

    public void setPs(int size) {
        astroid.reset();
        for (int i = 0; i < 7; i++) {
            astroid.addPoint((int) (size * (0.75 + Math.random() / 2) * Math.cos(Math.PI * 2 / 7 * i)) + 200, (int) (size * (0.75 + Math.random() / 2) * Math.sin(Math.PI * 2 / 7 * i)) + 200);
        }
    }

    public void update(ArrayList<Boolean> keys) {
        changePs((int) velX, (int) velY);

        if (!astroid.intersects(new Rectangle(0, 0, 500, 500))) {
            Point p = getColPos(new Rectangle(0, 0, 500, 500), astroid.getBounds());

            velX *= p.x;
            velY *= p.y;
        }

    }

    private Point getColPos(Rectangle r1, Rectangle r2) {
        double x1 = (r1.x + Math.floor((r1.width) / 2));
        double y1 = (r1.y + Math.floor((r1.height) / 2));
        double x2 = (r2.x + Math.floor((r2.width) / 2));
        double y2 = (r2.y + Math.floor((r2.height) / 2));
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

    public void changePs(int px, int py) {
        astroid.translate(px, py);
    }
    
    public Point ave(Polygon p){
        int ax = 0;
        int ay = 0;
        for(int po : p.xpoints){
            ax += po;
        }
        for(int po : p.ypoints){
            ay += po;
        }
        return new Point(ax/=p.xpoints.length, ay/=p.ypoints.length);
    }
}
