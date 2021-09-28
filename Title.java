import mayflower.*;

public class Title extends World 
{
    private Ninjagirl main;
    private String[][] tiles;
    public Level1 level1;
    public Title() 
    {
        level1 = new Level1();
        setBackground("img/bg/titlescreen.png");
        main = new Ninjagirl();
        addObject(main, 300, 300);
        tiles=new String[17][10];
        buildWorld();
        showText("Press Enter to Begin", 280, 150);
    }
    public void buildWorld()
    {
        String tiles[][]={
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground"}};
        
        for(int r=0; r<tiles.length;r++)
        {
            for(int c=0;c<tiles[r].length;c++)
            {
                if(tiles[r][c].equals("ground"))
                {
                    int h =r*49;
                    int w =c*50;
                    addObject(new Block(), w, h);//make ground
                }
            }
        }
        
    }
    
    public void act()
    {
        
        if(Mayflower.isKeyPressed(10)){
            Mayflower.setWorld(level1); //if enter is pressed start level1
        }
    }
    
}
