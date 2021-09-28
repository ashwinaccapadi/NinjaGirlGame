import mayflower.*;
/**
 * Write a description of class MovableAnimatedActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovableAnimatedActor extends AnimatedActor
{
    // instance variables - replace the example below with your own

    private Animation walkRight;
    private Animation idle;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation walkLeft;
    private String currentAction;
    private String lastCurrentAction;
    private String direction;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private Animation climbRight;
    private Animation climbLeft;
    private Animation attackRight;
    private Animation attackLeft;
    private Timer jumpTimer;
    /**
     * Constructor for objects of class MovableAnimatedActor
     */
    public MovableAnimatedActor()
    {
      walkRight=null;
      idle=null;
      walkLeft=null;
      currentAction=null;
      idleRight=null;
      idleLeft=null;
      fallLeft=null;
      fallRight=null;
      jumpRight=null;
      jumpLeft=null;
      climbRight=null;
      climbLeft=null;
      lastCurrentAction="";
      direction="right";
      jumpTimer = new Timer(100);
    }
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }
    public void setWalkRightAnimation(Animation ani)
    {
        walkRight=ani;
    }
    public void setWalkLeftAnimation(Animation ani)
    {
        walkLeft=ani;
    }
    public void setIdleAnimation(Animation ani)
    {
        idle=ani;
    }

    public void setIdleRightAnimation(Animation ani)
    {
        idleRight=ani;
    }
    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft=ani;
    }
    public void setFallRightAnimation(Animation ani)
    {
        fallRight=ani;
    }
    public void setFallLeftAnimation(Animation ani)
    {
        fallLeft=ani;
    }
    public void setJumpRightAnimation(Animation ani)
    {
        jumpRight=ani;
    }
    public void setJumpLeftAnimation(Animation ani)
    {
        jumpLeft=ani;
    }
    public void setClimbRightAnimation(Animation ani)
    {
        climbRight=ani;
    }
    public void setClimbLeftAnimation(Animation ani)
    {
        climbLeft=ani;
    }
    public void setAttackRightAnimation(Animation ani)
    {
        attackRight=ani;
    }
    public void setAttackLeftAnimation(Animation ani)
    {
        attackLeft=ani;
    }    
    public String getCurrentAction()
    {
        return currentAction;
    }
    public boolean isCurrentAction(String action)
    {
        if(action.equals(currentAction))
        {
            return true;
        }
        return false;
    }
    public boolean wasCurrentAction(String action)
    {
        if(action.equals(lastCurrentAction))
        {
            return true;
        }
        return false;
    }
    public void act()
    {
        super.act();
        String newAction=null;
        int x=getX();
        int y=getY();
        int w=getWorld().getWidth();
        int h=getWorld().getHeight();

       //all of these change the values of newAction depending on the ninjagirl's state and what key is down.
         if(Mayflower.isKeyDown(37))
        {
            if(getX()==0)
            {
                setLocation(x,y);
                newAction="idleLeft";
            }

            else if(currentAction.equals("walkLeft")&& !lastCurrentAction.equals("walkLeft"))              
            {
                setLocation(x-1,y);
            }
            newAction="walkLeft";
            direction="left";
        }
        
        else if(Mayflower.isKeyDown(39))
        {
            if(getX()==w)
            {
                setLocation(x,y);
                newAction="idleRight";
            }

            else if(currentAction.equals("walkRight")&& !lastCurrentAction.equals("walkRight"))
            {
                setLocation(x+1,y);
            }
            newAction="walkRight";
            direction="right";
        }

        else
        {  
            if(direction.equals("right"))
            {newAction="idleRight";
            }
            else if(direction.equals("left"))
            {
                newAction="idleLeft";
            }
        }

       

        if(isTouching(Ladder.class))
        {
            setLocation(x+1,y-2);
            newAction="climbRight";
        }
       if(Mayflower.isKeyDown(Keyboard.KEY_W))
       {
           if(direction.equals("right"))
           {
               newAction="attackRight";
            }
           else if(direction.equals("left"))
           {
               newAction="attackLeft";
            }
            
        }

       
        if(isFalling())
        {
            if(getVelocity()>0)
            {
                if(direction.equals("right"))
                {newAction="fallRight";
        
                }
                else if(direction.equals("left"))
                {
                newAction="fallLeft";
                }
            } 
            else if(getVelocity()<0)
            {
                if(direction.equals("right"))
                {newAction="jumpRight";
        
                }
                else if(direction.equals("left"))
                {
                newAction="jumpLeft";
                }   
            }
        }
        //changes the states of newAction and currentAction to change the animation
        if(newAction!=null && !newAction.equals(currentAction))
        {
         if(newAction.equals("walkRight"))
            {
             setAnimation(walkRight);
            }
         else if(newAction.equals("walkLeft"))
         {
             setAnimation(walkLeft);
            }
         else if(newAction.equals("idleRight"))
            {
             setAnimation(idleRight);
            }
         else if(newAction.equals("idleLeft"))
            {
             setAnimation(idleLeft);
            }  
         else if(newAction.equals("fallRight"))
         {
             setAnimation(fallRight);
            }
         else if(newAction.equals("fallLeft"))
         {
             setAnimation(fallLeft);
            }
         else if(newAction.equals("jumpRight"))
         {
             setAnimation(jumpRight);
            }  
         else if(newAction.equals("jumpLeft"))
         {
             setAnimation(jumpLeft);
            }
         else if(newAction.equals("climbRight"))
         {
             setAnimation(climbRight);
            }
         else if(newAction.equals("climbLeft"))
         {
             setAnimation(climbLeft);
            }
         else if(newAction.equals("attackRight"))
         {
             setAnimation(attackRight);
            }
         else if(newAction.equals("attackLeft"))
         {
             setAnimation(attackLeft);
            }
            lastCurrentAction=currentAction;
            currentAction=newAction;
        }
    }

}


