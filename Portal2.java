import mayflower.*;
public class Portal2 extends Actor
{
    

    public Portal2()
    {
        setImage("img/portal/npor.png");
    }
    
    public void act()
    {
        if(isTouching(Ninjagirl.class)){
            Mayflower.setWorld(new GameOverWin()); //switch to winning world
        }  
    }
}