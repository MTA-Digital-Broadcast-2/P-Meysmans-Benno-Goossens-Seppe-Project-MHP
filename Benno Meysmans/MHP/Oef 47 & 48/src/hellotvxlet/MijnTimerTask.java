package hellotvxlet;

import java.util.TimerTask;

public class MijnTimerTask extends TimerTask
{   
    private HelloTVXlet xlet = new HelloTVXlet();
    
    public MijnTimerTask()
    {
        
    }
    
    public void run() 
    {
        xlet.tick();
    }
}
