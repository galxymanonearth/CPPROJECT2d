import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class thing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class thing extends Actor
{
    private int jumpHeight = 10;
    private int walkSpeed = 5;
    private double fallSpeed = 0.4;
    
    private boolean isInAir = false;
    private double deltaX =0;
    private double deltaY =0;
    private int groundHeight =getImage().getHeight()/2;
    private int sideLongness =getImage().getWidth()/2;
    private World myWorld;
    int worldHeight;
    int worldWidth;
    public void addedToWorld(World myWorld)
    {
        this.myWorld = myWorld;
        this.worldHeight = myWorld.getHeight();
        this.worldWidth = myWorld.getWidth();
    }
    /**
     * Act - do whatever the thing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isInAir)
        {
            fall();
        }
        else
        {
            getCommand();
            
        }
        move();
    }    
    private void run(String direction)
    {
        if(direction == "left")
        {
            deltaX = walkSpeed*-1;
        }
        else 
        {
            deltaX = walkSpeed;
        }
    }
    private void stop()
    {
        deltaX = 0;
    }
    private void jump()
    {
        deltaY +=jumpHeight;
        isInAir = true;//I dont want to be that guy who will eat all the things in this way you know
        
    }
    private void fall()
    {
        deltaY -= fallSpeed;
    }
    private void move()
    {
        double newX = getX() + deltaX;
        double newY = getY() - deltaY;
        Actor platformBellow= getOneObjectAtOffset(0, groundHeight + 5, Brick.class);
        if(platformBellow!=null)
        {
            deltaY =0;
            isInAir =false;
        }
        else
        {
            isInAir =true;
        }
        setLocation((int)newX,(int)newY);
    }
    private void getCommand()
    {
        if(Greenfoot.isKeyDown("left"))
        {
           run("left");
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            run("right");
        }
        else
        {
            stop();
        }
        if(Greenfoot.isKeyDown("up"))
        {
            jump();
        }
        
        
       
        
        
    }

}
