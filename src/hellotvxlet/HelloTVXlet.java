package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;


public class HelloTVXlet implements Xlet 
{
    private XletContext actueleXletContext;
       
    private HScene scene;
    private HSceneTemplate sceneTemplate = new HSceneTemplate();
    private boolean debug = true;
    
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
       
       scene.repaint();
    }

    public void pauseXlet() 
    {
        
    }

    public void startXlet() throws XletStateChangeException 
    {    
       scene.validate();
       scene.setVisible(true);
    }
}
