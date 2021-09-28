import mayflower.*;

public class Level2 extends World 
{
    private String[][] tiles;
    private Portal2 portal;
    private Ladder ladder;
    private Ladder ladder2;
    private Spikes spikes;
    private Jack jack;
    private Shrooms mushroom;
    private Shrooms mushroom2;
    private Shrooms mushroom3;
    private Ninjagirl main;
    private int score;
    public Level2() 
    {
        setBackground("img/bg/mcbackground.png");
        
        main = new Ninjagirl();
    	addObject(main, 50, 375);
        main.increaseScore(3);
        main.increaseLives(1);
        
        portal = new Portal2();
        //addObject(portal, 390, 300);
              
        tiles=new String[17][10];
        
        ladder = new Ladder();
        addObject(ladder,292 ,344);
        
        ladder2 = new Ladder();
        addObject(ladder2,292 ,244);
        
        mushroom = new Shrooms();
        addObject(mushroom, 350, 390);
        
        mushroom2 = new Shrooms();
        addObject(mushroom2, 665, 115);
        
        mushroom3 = new Shrooms();
        addObject(mushroom3, 400, 10);
        
        jack = new Jack();
        addObject(jack,560, 375);
        
        //spikes = new Spikes();
        //addObject(spikes, 500, 140);
        
        buildWorld();
    }
    public void buildWorld()
    {
        String[][]tiles = {
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","lfb","fb","rfb","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","lfb","fb","rfb",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","lfb","fb","fb","fb","rfb","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","",""},
        {"","","","","","","","","","","","","","","","",""},
        {"ground","ground","ground","waves","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground","ground"}};
                  //instantiate 2d array with strings
        for(int r=0; r<tiles.length;r++)
        {
            for(int c=0;c<tiles[r].length;c++)
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
               if(tiles[r][c].equals("waves")){
                    int h =r*51;
                    int w =c*50;
                    addObject(new Waves(), w, h);//add tiles based on strings
               }
            }
        } 
    }

    public void act()
    {
        if(main.getLives()==0){
              Mayflower.setWorld(new GameOverLose());// if lives ==0 game over
            }
        showText("Score: " + main.getScore() + " Lives: " + (main.getLives()), 30, 100);
        if (main.getScore() == 6){
              addObject(portal, 390, 150);
        }
    }
    
}
