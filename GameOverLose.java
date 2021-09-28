import mayflower.*;

public class GameOverLose extends World 
{
    
    public GameOverLose() 
    {
    	setBackground("img/bg/mcbackground.png");
    	
    }
    
    public void act()
    {
        showText("You Lost!",335, 200, Color.BLACK);
        if(Mayflower.isKeyPressed(10)){
            Mayflower.setWorld(new Title()); //if enter is pressed start level1
        }
    }
    
}
