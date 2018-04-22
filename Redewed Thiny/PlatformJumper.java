import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformJumper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformJumper extends Actor
{
    GreenfootImage myImage = getImage();
    String[] imageNames = {"runningtoleft0.png","runningtoleft1.png", "running to left2.png"};
    private int jumpHeight = 10;
    
    private int walkSpeed = 5;
    private double fallSpeed = 0.4;

    private boolean inTheAir = false;
    private double deltaX = 0;
    private double deltaY = 0; 
    private int groundHeight = (getImage().getHeight()/4)-20;
    private int sideWidth = (getImage().getWidth()/4)-20;
    private World myWorld;
    int worldHeight;
    int worldWidth;

    public void addedToWorld(World myWorld)
    {
        this.myWorld = myWorld;
        this.worldHeight = myWorld.getHeight();
        this.worldWidth = myWorld.getWidth();
    }
    public PlatformJumper()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() +100, image.getHeight()+100);
        setImage(image);
        groundHeight = (getImage().getHeight()/4)-20;
            sideWidth = (getImage().getWidth()/4)-20;
    }
    private int frame;
    public void animateWalkingLeft()
    {
        if(frame == 0) {setImage("runningtoleft0.png");
            GreenfootImage image = getImage();
            ;
            image.scale(image.getWidth() +100, image.getHeight()+100);
            groundHeight = (getImage().getHeight()/4)-20;
            sideWidth = (getImage().getWidth()/4)-20;
            setImage(image);}
        else if(frame == 5) {setImage("runningtoleft1.png");
            GreenfootImage image = getImage();

            image.scale(image.getWidth() +100, image.getHeight()+100);
            groundHeight = (getImage().getHeight()/4)-20;
            sideWidth = (getImage().getWidth()/4)-20;
            setImage(image);}
        else if(frame == 10) {setImage("running to left2.png");
            GreenfootImage image = getImage();

            image.scale(image.getWidth() +100, image.getHeight()+100);
            groundHeight = (getImage().getHeight()/4)-20;
            sideWidth = (getImage().getWidth()/4)-20;
            setImage(image);
        }
        else if(frame == 15)
        {
            frame = 0;
            return;
        }

        frame++;

    }

    public void animateWalkingRight()
    {
        if(frame == 0) {setImage("Layer 1_runningright1.png");
            GreenfootImage image = getImage();

            image.scale(image.getWidth() +100, image.getHeight()+100);
            groundHeight = (getImage().getHeight()/4)-20;
            sideWidth = (getImage().getWidth()/4)-20;
            setImage(image);}
        else if(frame == 5) {setImage("Layer 1_runningright2.png");
            GreenfootImage image = getImage();

            image.scale(image.getWidth() +100, image.getHeight()+100);
            setImage(image);}
        else if(frame == 10) {setImage("Layer 1_runningright3.png");
            GreenfootImage image = getImage();

            image.scale(image.getWidth() +100, image.getHeight()+100);
            setImage(image);
        }
        else if(frame == 15)
        {
            frame = 0;
            return;
        }

        frame++;

    }
    /**
     * Act - do whatever the PlatformJumper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
          Actor platformBelow = getOneObjectAtOffset(0, groundHeight + 5, Platform.class);
        Actor platformAbove = getOneObjectAtOffset(0, -(groundHeight + 5), Platform.class);
        Actor platformToRight = getOneObjectAtOffset(sideWidth+5, 0, Platform.class);
        Actor platformToLeft = getOneObjectAtOffset(-(sideWidth+5), 0, Platform.class);
          if(platformBelow == null&&!inTheAir)
        {

            fall();
        }
         if(inTheAir)
        {
            fall();
            if(Greenfoot.isKeyDown("left"))
            {
                run("left");
            } else if (Greenfoot.isKeyDown("right"))
            {
                run("right");

            }
            if(platformToRight!=null)
            {
                stop();
            }
            if(platformToLeft!=null)
            {
                stop();
            }
        } else {
            getCommand();
        }

        move();
         if(right==0&&left==1&&isNotPressed)
        {
            setImage("Layer 1_sprite11111_1.png");
            GreenfootImage image = getImage();

            image.scale(image.getWidth() +100, image.getHeight()+100);
            setImage(image);
        }
        if(right==1&&left==0&&isNotPressed)
        {
            setImage("Layer 1_sprite11111_2.png");
            GreenfootImage image = getImage();

            image.scale(image.getWidth() +100, image.getHeight()+100);
            setImage(image);
        }
    }    

    private void run (String direction)
    {
        if(direction=="left")
            deltaX = walkSpeed*-1;
        else
            deltaX = walkSpeed;
    }

    private void stop ()
    {
        deltaX = 0;
    }

    private void jump()
    {
        deltaY += jumpHeight;
        inTheAir = true;
    }

    /*
     * fall() will be called whenever BallGuy is in the air. Decreases the deltaY by 1, creating
     * gravity.
     */
    private void fall()
    {
        deltaY-=fallSpeed;
    }

    private void move()
    {
        double newX = getX() + deltaX;
        double newY = getY() - deltaY;

        Actor platformBelow = getOneObjectAtOffset(0, groundHeight + 5, Platform.class);
        Actor platformAbove = getOneObjectAtOffset(0, -(groundHeight + 5), Platform.class);
        Actor platformToRight = getOneObjectAtOffset(sideWidth+5, 0, Platform.class);
        Actor platformToLeft = getOneObjectAtOffset(-(sideWidth+5), 0, Platform.class);
        if(platformBelow!=null)
        {
            if(deltaY<0)
            {
                deltaY = 0;
                inTheAir = false;
                GreenfootImage platformImage = platformBelow.getImage();
                int topOfPlatform = platformBelow.getY() - platformImage.getHeight()/4;
                newY = topOfPlatform - groundHeight;
            }
        }else if(getY() >= worldHeight - groundHeight) {
            if(deltaY < 0)
            {
                deltaY = 0;
                inTheAir = false;
                newY = worldHeight - groundHeight;
            }
        } else {
            inTheAir = true;
        }
        if(platformAbove != null)
        {
            if(deltaY>0)
            {
                deltaY=0;
                
                GreenfootImage platformImage = platformAbove.getImage();
                int bottomOfPlatform = platformAbove.getY() + platformImage.getHeight()/4;
                newY = bottomOfPlatform + groundHeight;
            }
        }
        if(getX()<=sideWidth)
        {
            deltaX = Math.abs(deltaX);
        }
        if(getX()>=worldWidth-sideWidth)
        {
            deltaX = Math.abs(deltaX) * -1;
        }
        if(platformToRight!=null)
        {
            deltaX = Math.abs(deltaX) * -1;
        }
        if(platformToLeft!=null)
        {
            deltaX = Math.abs(deltaX);
        }
        setLocation((int)newX,(int)newY);
    }
     int left;
    int right;
    boolean isNotPressed;
    boolean bb=false;
    private void getCommand()
    { 
        int attime =0;
        Actor platformToRight = getOneObjectAtOffset(sideWidth+5, 0, Platform.class);
        Actor platformToLeft = getOneObjectAtOffset(-(sideWidth+5), 0, Platform.class);
        if(Greenfoot.isKeyDown("left"))
        {
            animateWalkingLeft();
            run("left");
            left =1;
            right = 0;
            isNotPressed = false;
        } else if (Greenfoot.isKeyDown("right"))
        {
            animateWalkingRight();
            run("right");
            left = 0;
            right =1;
            isNotPressed = false;
        } else 
        {
            stop();
            isNotPressed = true;
        }

        if(Greenfoot.isKeyDown("up"))
        {
            jump();
            
        }
    }

}
