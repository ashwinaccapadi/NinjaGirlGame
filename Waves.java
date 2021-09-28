import mayflower.*;
public class Waves extends Actor
{
    

    public Waves()
    {
        setImage("img/Tiles/17.png");
    }
    
    public void act()
    {
        if(isTouching (Ninjagirl.class)){
          Object a = getOneIntersectingObject(Ninjagirl.class);
          Ninjagirl girl = (Ninjagirl) a;
          World w = getWorld();
          if(girl.getLives()==0){
              Mayflower.setWorld(new GameOverLose());
            }
          girl.touchingJack(-1); //same method used as when touching jack.class
        }  
    }
}
