package hellotvxlet;

import java.awt.event.*;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import org.dvb.ui.*;


public class HelloTVXlet implements Xlet, HActionListener 
{
    private XletContext actueleXletContext;
    private HScene scene;
    private HSceneTemplate sceneTemplate = new HSceneTemplate();
    private boolean debug = true;
    
    private HStaticText tekstLabel;
    private HTextButton knop1, knop2, knop3, knop4, knop5;

    public HelloTVXlet() 
    {
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException
    {
       if(debug)
       {
            System.out.println("Xlet initialiseren.");
       }
        
       this.actueleXletContext = context;
       
       sceneTemplate.setPreference(
            org.havi.ui.HSceneTemplate.SCENE_SCREEN_DIMENSION, 
            new HScreenDimension(1.0f, 1.0f), org.havi.ui.HSceneTemplate.REQUIRED);
       
       sceneTemplate.setPreference(
            org.havi.ui.HSceneTemplate.SCENE_SCREEN_LOCATION,
            new HScreenPoint(0.0f, 0.0f), org.havi.ui.HSceneTemplate.REQUIRED);
       
       scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
       
       tekstLabel = new HStaticText("Who wants to be a milionaire?");
       tekstLabel.setLocation(200, 80);
       tekstLabel.setSize(300, 30);
       tekstLabel.setBackground(new DVBColor(255, 255, 255, 179));
       tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
       knop1 = new HTextButton("Antwoord 1");
       knop1.setLocation(200, 120);
       knop1.setSize(120, 30);
       knop1.setBackground(new DVBColor(0, 0, 0, 179));
       knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
       knop2 = new HTextButton("Antwoord 2");
       knop2.setLocation(200, 220);
       knop2.setSize(120, 30);
       knop2.setBackground(new DVBColor(0, 0, 0, 179));
       knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
       knop3 = new HTextButton("Antwoord 3");
       knop3.setLocation(200, 320);
       knop3.setSize(120, 30);
       knop3.setBackground(new DVBColor(0, 0, 0, 179));
       knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
       knop4 = new HTextButton("Antwoord 4");
       knop4.setLocation(200, 420);
       knop4.setSize(120, 30);
       knop4.setBackground(new DVBColor(0, 0, 0, 179));
       knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
       knop5 = new HTextButton("Hulplijn inschakelen");
       knop5.setLocation(200, 500);
       knop5.setSize(250, 50);
       knop5.setBackground(new DVBColor(255, 255, 255, 179));
       knop5.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
       knop1.setFocusTraversal(null, knop2, null, null);
       knop2.setFocusTraversal(knop1, knop3, null, null);
       knop3.setFocusTraversal(knop2, knop4, null, null);
       knop4.setFocusTraversal(knop3, knop5, null, null);
       knop5.setFocusTraversal(knop4, null, null, null);
       
       knop1.setActionCommand("knop1_actioned");
       knop2.setActionCommand("knop2_actioned");
       knop3.setActionCommand("knop3_actioned");
       knop4.setActionCommand("knop4_actioned");
       knop5.setActionCommand("knop5_actioned");
       knop1.addHActionListener(this);
       knop2.addHActionListener(this);
       knop3.addHActionListener(this);
       knop4.addHActionListener(this);
       knop5.addHActionListener(this);
       
       scene.add(tekstLabel);
       scene.add(knop1);
       scene.add(knop2);
       scene.add(knop3);
       scene.add(knop4);
       scene.add(knop5);
       
       knop1.requestFocus();
    }

    public void startXlet() throws XletStateChangeException 
    {
        if(debug)
        {
            System.out.println("Xlet starten");
        }
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() 
    {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
        if(unconditional)
        {
            System.out.println("De Xlet moet beëindigd worden.");
        }
        
        else
        {
            System.out.println("De mogelijkheid bestaat " + 
                                "door het werpen van een exceptie " 
                                + "de Xlet in leven te houden.");
            throw new XletStateChangeException("Laat me leven!");
        }
    }
    
    //CUSTOM METHODS
    public void actionPerformed(ActionEvent e)
    {        
        if(e.getActionCommand().equals("knop3_actioned"))
        {
            System.out.println("Correct, You win!");
        }
        
        else if(e.getActionCommand().equals("knop5_actioned"))
        {
            knop1.setVisible(false);
            knop4.setVisible(false);
            
            knop5.setFocusTraversal(knop3, null, null, null);
            knop3.setFocusTraversal(knop2, knop5, null, null);
            knop2.setFocusTraversal(null, knop3, null, null);
        }
        
        else
        {
            System.out.println("Wrong, You lose!");
        }
    }
}
