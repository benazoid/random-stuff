package code;

import java.awt.Graphics;
import java.awt.Point;

public class Alien {

    public Point pos;
    public static int size = 50;
    public Point goal;
    public Point proj;

    public Alien(Point p) {
        pos = p;
        goal = new Point((int) (Math.random() * 500), (int) (Math.random() * 500));
    }

    public int t;

    public void show(Graphics g, Point player) {
        t++;
        g.drawOval(pos.x, pos.y, size, size);
        g.drawOval(pos.x + 17, pos.y + 17, size / 3, size / 3);

        if (Math.abs(pos.x - goal.x) < 10 && Math.abs(pos.y - goal.y) < 10) {
            goal = new Point((int) (Math.random() * 500), (int) (Math.random() * 500));
        } else {
            double a = findAng(pos.x, pos.y, goal.x, goal.y);
            pos.x += 2 * Math.cos(a);
            pos.y += 2 * Math.sin(a);
        }
        if (t % 1000 == 0 && proj != null) {

        }
    }

    public static double findAng(double x1, double y1, double x2, double y2) {
        double angle = (Math.atan2(x2 - x1, y2 - y1));
        // Keep angle between 0 and 360
        angle = angle + Math.ceil(-angle / Math.PI * 2) * Math.PI * 2;

        return -angle + Math.PI / 2;
    }
}
