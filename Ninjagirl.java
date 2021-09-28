import mayflower.*;
/**
 * Write a description of class ninjagirl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ninjagirl extends MovableAnimatedActor
{
    private Animation walkRight;
    private String currentAction;
    private Animation walkLeft;
    private Animation idleLeft;
    private Animation idleRight;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private Animation climbRight;
    private Animation climbLeft;
    private Animation attackRight;
    private Animation attackLeft;
    public int score;
    public int lives;
    public Ninjagirl()
    {
        score = 0;
        lives = 3;
        //sets the values of all animation variables with the appropriate sets of images 
        String[] images = new String[10];
        for (int i=0; i<10; i++)
        {
            int index = i;
            images[i] = "img/ninjagirl/Run__00" + (index) + ".png";
        }
        walkRight = new Animation(50, images);
        setWalkRightAnimation(walkRight);
       
        walkLeft = new Animation(50, images);
        walkLeft.mirrorHorizontally();
        setWalkLeftAnimation(walkLeft);
       
        String[] idleImages = new String[10];
        for (int i=0; i<10; i++)
        {
            int index = i;
            idleImages[i] = ("img/ninjagirl/Idle__00" + (index) + ".png");
        }
        idleRight = new Animation(50, idleImages);
        setIdleRightAnimation(idleRight);
       
        idleLeft= new Animation (50, idleImages);
        idleLeft.mirrorHorizontally();
        setIdleLeftAnimation(idleLeft);
       
        String[] fallingImages=new String[10];
        for (int i=0; i<10; i++)
        {
            int index=i;
            fallingImages[i]=("img/ninjagirl/Glide_00" + (index) + ".png");
        }
       
        fallRight= new Animation(50, fallingImages);
        setFallRightAnimation(fallRight);
       
        fallLeft= new Animation(50, fallingImages);
        fallLeft.mirrorHorizontally();
        setFallLeftAnimation(fallLeft);
       
        String[] jumpingImages=new String[10];
        for (int i=0; i<10; i++)
        {
            int index=i;
            jumpingImages[i]=("img/ninjagirl/Jump__00" + (index) + ".png");
        }
       
        jumpRight= new Animation(50, jumpingImages);
        setJumpRightAnimation(jumpRight);
       
        jumpLeft= new Animation(50, jumpingImages);
        jumpLeft.mirrorHorizontally();
        setJumpLeftAnimation(jumpLeft);
       
        String[] climbingImages=new String[10];
        for (int i=0;i<10;i++)
        {
            int index=i;
            climbingImages[i]=("img/ninjagirl/Climb_00" + (index) + ".png");
        }
        climbRight=new Animation(50,climbingImages);
        setClimbRightAnimation(climbRight);
        
        climbLeft=new Animation(50, climbingImages);
        climbLeft.mirrorHorizontally();
        setClimbLeftAnimation(climbLeft);
        
        String[] attackingImages=new String[10];
        for (int i=0;i<10;i++)
        {
            int index=i;
            attackingImages[i]=("img/ninjagirl/Attack__00" + (index) + ".png");
        }
        attackRight=new Animation(50,attackingImages);
        setAttackRightAnimation(attackRight);
        
        attackLeft=new Animation(50, attackingImages);
        attackLeft.mirrorHorizontally();
        setAttackLeftAnimation(attackLeft);        
    }

   
    public void increaseScore(int amount){
        score+=amount;
    }
    
    public void increaseLives(int amount){
        lives+=amount;
    }
   
    public int getScore(){
        return score;
    }
   
    public int getLives(){
        return lives;
    }
   
    public void touchingJack(int amount){
        lives+=amount;
        setLocation(50,275);
    }
    
    public boolean touchingPortal(){ //check if touching portal
        if(isTouching(Portal.class)||isTouching(Portal2.class)){
            return true;
        }
        return false;
    }
   
    private void updateText(){ //updates text when score or lives is changed
        World w = getWorld();

    }
      
    public void act()
    {
        super.act();
    }
}
