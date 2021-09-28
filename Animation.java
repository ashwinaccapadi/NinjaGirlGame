import mayflower.*;

public class Animation
{
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;
//sets up frames for each animation object
    public Animation(int animationFrameRate, String[] pictures)
    {
        currentFrame = 0;
        framerate = animationFrameRate;
        frames = new MayflowerImage[pictures.length];
        for(int i=0; i<pictures.length; i++)
        {
            frames[i] = new MayflowerImage(pictures[i]);
            frames[i].scale(50, 50);
        }
    }

    public int getFrameRate()
    {
        return framerate;
    }

    public MayflowerImage getNextFrame() 
    {
        MayflowerImage nextFrame = frames[currentFrame];
        currentFrame += 1;
        if (currentFrame%frames.length == 0){
            currentFrame = 0;
        }
        return nextFrame;
    }
    
    public void mirrorHorizontally(){
        for(int a = 0;a<frames.length; a++){
            frames[a].mirrorHorizontally();
        }
    }
}