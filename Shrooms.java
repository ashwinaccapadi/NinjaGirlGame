import mayflower.*;
public class Shrooms extends Actor
{
    

    public Shrooms()
    {
        setImage("img/shrooms/Mushroom_" + (int)(Math.random()* (2) + 1)+".png"); //random colors
    }
    
    public void act()
    {
        if(isTouching(Ninjagirl.class)){
            Object a = getOneIntersectingObject(Ninjagirl.class);
            Ninjagirl girl = (Ninjagirl) a;
            World w = getWorld();
            w.removeObject(this); //removes shroom from world it is in
            girl.increaseScore(1);
        }
        if(isTouching(Block.class)||isTouching(RightFloatingBlock.class)||isTouching(FloatingBlock.class)||
        isTouching(LeftFloatingBlock.class)||isTouching(Spikes.class)){
            Object a = getOneIntersectingObject(Ninjagirl.class);
            Ninjagirl girl = (Ninjagirl) a;
            World w = getWorld();
            w.removeObject(this); //removes shroom from world it is in
        }
        
    }
}
