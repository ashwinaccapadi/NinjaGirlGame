import mayflower.*;

public class GameOverWin extends World 
{
    
    public GameOverWin() 
    {
    	setBackground("img/bg/mcbackground.png");
    	
    }
    
    public void act()
    {
        showText("You Win!",335, 200, Color.BLACK);
    }
    
}
