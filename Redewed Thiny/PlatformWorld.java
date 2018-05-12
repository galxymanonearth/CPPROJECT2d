import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class PlatformWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformWorld extends World
{

    /**
     * Constructor for objects of class PlatformWorld.
     * 
     */
    public PlatformWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Platform[] platforms = new Platform[32];
        for(int i = 0; i < platforms.length; i++)
            platforms[i] = new Platform();
        int[] addObjectX = new int[32];
        int[] addObjectY = new int[32];
        Random r = new Random();
        for(int i = 0; i < 32; i++){
            addObject(platforms[i], r.nextInt(800), r.nextInt(600));
        }
        PlatformJumper broken = new PlatformJumper();
        addObject(broken, 50+r.nextInt(700),580 );
    }
}
