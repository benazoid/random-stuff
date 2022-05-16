package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.sound.sampled.Clip;


public class AsstroidsGame extends AnimationPanel 
{

    //Constants
    //-------------------------------------------------------

    //Instance Variables
    //-------------------------------------------------------

    ArrayList<Boolean> keys = new ArrayList<>();
    Ship ship = new Ship();
    Rectangle frame = new Rectangle(0,0,600,600);
    
    Alien a = new Alien(new Point(250,0));
    
    //Constructor
    //-------------------------------------------------------
    public AsstroidsGame()
    {   //Enter the name and width and height.  
        super("ArcadeDemo", 600,600);
        
        for(int i = 0; i < 8; i++){
            Astroid.as.add(new Astroid(ship.pos));
            
        }
        for(int i = 0; i < 200; i++){
            keys.add(false);
        }
    }
    
    
   
    /*
    public boolean CollisionDetection()
    {
        return null;
    }
     */
    
    //The renderFrame method is the one which is called each time a frame is drawn.
    //-------------------------------------------------------
    protected void renderFrame(Graphics g) 
    {
       for(int i = 0; i < Astroid.as.size(); i++){
           Polygon p = Astroid.as.get(i).astroid;
           g.drawPolygon(Astroid.as.get(i).astroid);
           Astroid.as.get(i).update(keys);
       }
       ship.show(g);
       ship.update(keys);
       
       for(int i = 0 ; i < Astroid.as.size(); i++){
           for(int j = 0; j < ship.getProjs().size(); j++){
               if(Astroid.as.get(i).astroid.intersects(ship.getProjs().get(j).getRect())){
                  Astroid.as.get(i).resetPs((int)(Astroid.as.get(i).getSize()-10));
                  ship.getProjs().remove(j);
               }
           }
       }
       
       a.show(g, ship.pos);
       
    }//--end of renderFrame method--
    
    //-------------------------------------------------------
    //Respond to Mouse Events
    //-------------------------------------------------------
    public void mouseClicked(MouseEvent e)  
    { 
        
    }
    
    //-------------------------------------------------------
    //Respond to Keyboard Events
    //-------------------------------------------------------
    
    public void keyPressed(KeyEvent e)
    {
        keys.set(e.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent e)
    {
        keys.set(e.getKeyCode(), false);
    }
    
    
    //-------------------------------------------------------
    //Initialize Graphics
    //-------------------------------------------------------
//-----------------------------------------------------------------------
/*  Image section... 
 *  To add a new image to the program, do three things.
 *  1.  Make a declaration of the Image by name ...  Image imagename;
 *  2.  Actually make the image and store it in the same directory as the code.
 *  3.  Add a line into the initGraphics() function to load the file. 
//-----------------------------------------------------------------------*/
    Image ballImage;        
    Image starImage;
    
    public void initGraphics() 
    {      
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        ballImage = toolkit.getImage("src/images/ball.gif");
        starImage = toolkit.getImage("src/images/star.gif");
    } //--end of initGraphics()--
    
    //-------------------------------------------------------
    //Initialize Sounds
    //-------------------------------------------------------
//-----------------------------------------------------------------------
/*  Music section... 
 *  To add music clips to the program, do four things.
 *  1.  Make a declaration of the AudioClip by name ...  AudioClip clipname;
 *  2.  Actually make/get the .wav file and store it in the same directory as the code.
 *  3.  Add a line into the initMusic() function to load the clip. 
 *  4.  Use the play(), stop() and loop() functions as needed in your code.
//-----------------------------------------------------------------------*/
    Clip themeMusic;
    Clip bellSound;
    
    public void initMusic() 
    {
        themeMusic = loadClip("src/audio/under.wav");
        bellSound = loadClip("src/audio/ding.wav");
        if(themeMusic != null)
//            themeMusic.start(); //This would make it play once!
            themeMusic.loop(2); //This would make it loop 2 times.
    }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}//--end of ArcadeDemo class--

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
