 import mayflower.*;

public class Jack extends Actor
{
    private int timer;
    private int count;
    public Jack()
    {
        timer = 0;
        count = 0;
        setImage("img/enemy/Run (6).png"); 
    }
   
    public void act()
    {
      timer++;
      int x = getX();
      int y = getY();
      if (timer%10==0){
          setImage("img/enemy/Run (6).png");
          setLocation(x+7,y);
          timer=0;
          count++;
        }
      if (count%20 ==0){
          setImage("img/enemy/mirror.png");
          setLocation(x-10,y);
        }
      if(Mayflower.isKeyDown(Keyboard.KEY_W)&&isTouching (Ninjagirl.class)){
          Object a = getOneIntersectingObject(Ninjagirl.class);
            Ninjagirl girl = (Ninjagirl) a;
            World w = getWorld();
            w.removeObject(this); //removes jack from world it is in
        }
      
      if(isTouching (Ninjagirl.class)){
          Object a = getOneIntersectingObject(Ninjagirl.class);
          Ninjagirl girl = (Ninjagirl) a;
          World w = getWorld();
          if(girl.getLives()==0){
              Mayflower.setWorld(new GameOverLose());
          }
          girl.touchingJack(-1);
      } 
      

      
    }
    
        
}

