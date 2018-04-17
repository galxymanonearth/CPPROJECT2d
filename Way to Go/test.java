import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test extends Actor
{
       GreenfootImage myImage = getImage();
    
  
     int currentImage=0;
     int attime =0;
    String[] imageNames = {"runningtoleft0.png","runningtoleft1.png", "running to left2.png"};
    /**
     * Act - do whatever the test wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
             if(Greenfoot.isKeyDown("left"))
      {
            if(attime == 18){
             attime = 0;
            }
            if(attime == 0)
            {
                setImage(imageNames[0]);
                
            }
             if(attime == 6)
            {
                setImage(imageNames[1]);
                
            }
              if(attime == 12)
            {
                setImage(imageNames[2]);
                
            }
          attime= attime+1;
          
        }// Add your action code here.
    }    
}
