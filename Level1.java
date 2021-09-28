import mayflower.*;

public class Level1 extends World
{
    private String[][] tiles;
    private Portal portal;
    private Spikes spikes;
    private Spikes spikes2;
    private Jack jack;
    private Jack jack2;
    private Shrooms mushroom;
    public Ninjagirl main;
    public Level1() 
    {
        setBackground("img/bg/mcbackground.png");
        main = new Ninjagirl();
        addObject(main, 10, 375);
        tiles = new String[17][10];
        
        portal = new Portal();
        addObject(portal, 800, 370);
        
        spikes = new Spikes();
        addObject(spikes,175, 390);
        
        spikes2 = new Spikes();
        addObject(spikes2,580, 390);
        

        
        jack = new Jack();
        addObject(jack, 450, 220);
        
        jack2 = new Jack();
        addObject(jack2, 470, 365);      
        
        buildWorld();
        
    }
    
    
    
    public void buildWorld()
    {
        String[][] tiles = {
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","lfb","fb","fb","fb","rfb","","","",""},
        {"","","","lfb","fb","rfb","","","","","","","","","","",""},
        {"","","spikes","spikes","spikes","spikes","","","","","","","","","","",""},
        {"ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground"}}; 
        int count = 0;
        for(int r=6; r<tiles.length;r++)
        {
            for(int c=2;c<tiles[0].length;c++)
            {
                int index = (int)(Math.random() * 100);
                if(index<50 && tiles[r][c].equals("")){
                    tiles[r][c] = "shroom"; //add shroom object randomly
                    break;
                }
            }
        }
        for(int r=0; r<tiles.length;r++)
        {
            for(int c=0;c<tiles[0].length;c++)
            {
                if(tiles[r][c].equals("ground"))
                {
                    int h =r*49;
                    int w =c*50;
                    addObject(new Block(), w, h);
                }
                if(tiles[r][c].equals("lfb")){
                    int h =r*47;
                    int w =c*50;
                    addObject(new LeftFloatingBlock(), w, h);
                }
                if(tiles[r][c].equals("fb")){
                    int h =r*47;
                    int w =c*50;
                    addObject(new FloatingBlock(), w, h);
                }
                if(tiles[r][c].equals("rfb")){
                    int h =r*47;
                    int w =c*50;
                    addObject(new RightFloatingBlock(), w, h);
                }
                if(tiles[r][c].equals("shroom")){
                    int h =r*47;
                    int w =c*50;
                    addObject(new Shrooms(), w, h);
                }
            }
        }              
    }
    
    public void act()
    {
       showText("Score: " + (main.getScore()) + " Lives: " + (main.getLives()), 30, 100);
       //updates score and lives
       if(main.getLives()==0){
              Mayflower.setWorld(new GameOverLose());// if lives ==0 game over
            }
       if(main.touchingPortal()&&main.getScore() >= 2){
           Mayflower.setWorld(new Level2());
       }
    }  
}
