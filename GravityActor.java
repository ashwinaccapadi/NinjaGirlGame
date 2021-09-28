import mayflower.*;
/**
 * Write a description of class GravityActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GravityActor extends Actor
{
    // instance variables - replace the example below with your own
    private boolean landed;
    private int velocity;
    /**
     * Constructor for objects of class GravityActor
     */
    public GravityActor()
    {
        landed = false;
        velocity=0;
    }
    
    public boolean isFalling(){
        if(!isBlocked()&&!isTouching(Ladder.class)){
            return true;
        }
        return false;
    }
        
    public boolean isBlocked(){
        if(isTouching(Block.class)||isTouching(RightFloatingBlock.class)||isTouching(FloatingBlock.class)||
        isTouching(LeftFloatingBlock.class)){ //check if is touching any tiles
            return true;
        }
        return false;
    }
    
    
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
                fall();
                //allows ninjagirl to only jump when its on the ground
        if(Mayflower.isKeyDown(38)&&isBlocked())
        {
            jump();
        }
        //allows actor to move while falling
        if(Mayflower.isKeyDown(37))
        {
            setLocation(getX()-4,getY());
        }
        if(Mayflower.isKeyDown(39))
        {
            setLocation(getX()+4,getY());
        }
        if (isBlocked())
        {
            landed = true; //if it is landed stay
        }
        if(Mayflower.isKeyDown(32))
        {
            setLocation(getX(),getY()-5);
        }
        


    }
    //controls gravity and causes ninjagirl to accelerate while falling
    public void fall()
    {
        if(velocity>=20)
        {
            velocity=10;
        }
        if(isBlocked() )
        {
            landed=true;
            velocity=0;
        }
        if(isFalling())
        {
        setLocation(getX(),getY()+velocity);
        velocity+=1;
        }
    
    }
    public void jump()
    {
        setLocation(getX(),getY()-5);
        velocity=-25;
    }
    public int getVelocity()
    {
        return velocity;
    }
}