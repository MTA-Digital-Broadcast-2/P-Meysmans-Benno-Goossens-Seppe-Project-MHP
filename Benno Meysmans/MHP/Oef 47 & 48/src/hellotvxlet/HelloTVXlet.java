package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.HRcEvent;
import java.util.Timer;


public class HelloTVXlet implements Xlet, UserEventListener 
{
    private XletContext actueleXletContext;
    
    private int schipX = 10;
    private int schipY = 500;
    private int sterrenY1 = -570;
    private int sterrenY2 = 0;
    private MijnComponent mc = new MijnComponent("spaceship.png", schipX, schipY);        
    private MijnComponent mc2 = new MijnComponent("sterrenhemel.png", 0, sterrenY1);
    private MijnComponent mc3 = new MijnComponent("sterrenhemel.png", 0, sterrenY2);
    
    private HScene scene;
    private HSceneTemplate sceneTemplate = new HSceneTemplate();
    private boolean debug = true;
    
    private int sceneWidth;
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException 
    {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException 
    {
       if(debug)
       {
            System.out.println("Xlet initialiseren.");
       }
        
       this.actueleXletContext = ctx;
       
       sceneTemplate.setPreference(
            org.havi.ui.HSceneTemplate.SCENE_SCREEN_DIMENSION, 
            new HScreenDimension(1.0f, 1.0f), org.havi.ui.HSceneTemplate.REQUIRED);
       
       sceneTemplate.setPreference(
            org.havi.ui.HSceneTemplate.SCENE_SCREEN_LOCATION,
            new HScreenPoint(0.0f, 0.0f), org.havi.ui.HSceneTemplate.REQUIRED);
       
       scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
     
       scene.add(mc);
       scene.add(mc2);
       scene.add(mc3);
       scene.repaint();
       
       UserEventRepository verzameling = new UserEventRepository("mijn verz");
       verzameling.addKey(HRcEvent.VK_LEFT);
       verzameling.addKey(HRcEvent.VK_RIGHT);
       
       EventManager.getInstance().addUserEventListener(this, verzameling);
    }

    public void pauseXlet() 
    {
        
    }

    public void startXlet() throws XletStateChangeException 
    {    
       scene.validate();
       scene.setVisible(true);
       sceneWidth = scene.getWidth();
       
       MijnTimerTask objMijnTimerTask = new MijnTimerTask();
       Timer timer = new Timer();
       timer.scheduleAtFixedRate(objMijnTimerTask, 0, 50);
    }

    public void userEventReceived(UserEvent e)
    {
        if(e.getType() == HRcEvent.KEY_PRESSED)
        {   
            switch(e.getCode())
            {                
                case HRcEvent.VK_LEFT:
                    if(schipX > 3)
                    {
                        schipX-= 3;                     
                        mc.verplaats(schipX, schipY);
                    }                   
                    break;
                
                case HRcEvent.VK_RIGHT:
                    if(schipX < sceneWidth - 48)
                    {
                        schipX+= 3;
                        mc.verplaats(schipX, schipY);
                    }
                    break;
            }
        }
    }
    
    public void tick()
    {
        //Ik snap niet waarom dit niet werkt.
        //Om te testen of de Y coordinaat wordt aangepast heb ik 
        //mc2.getX() en sterrenY1 gelogd.
        
        sterrenY1 += 1;
        sterrenY2 += 1;
       
        mc2.verplaats(0, sterrenY1);
        mc3.verplaats(0, sterrenY2);
        
        if(sterrenY1 >= 570) sterrenY1 = -570;
        if(sterrenY2 >= 570) sterrenY2 = -570;   
    }
}
