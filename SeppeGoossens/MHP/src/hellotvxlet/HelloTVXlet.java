package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import java.awt.*;
import java.awt.event.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, HActionListener
{
    
    private HScene scene;
    private XletContext actueleXletContext;
    
    private boolean debug = true;
    
    private HStaticText tekstLabel;
    private HTextButton knop1, knop2, knop3, knop4, knop5;
    
    
    public HelloTVXlet()
    {
        
    }

    public void initXlet(XletContext context)
    {
      
        if(debug) System.out.println("Xlet Initialiseren");
        this.actueleXletContext = context;
        
        //Het template maken
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        //Grootte en positie ingeven
        sceneTemplate.setPreference(
            org.havi.ui.HSceneTemplate.SCENE_SCREEN_DIMENSION,
            new HScreenDimension(1.0f, 1.0f),
            org.havi.ui.HSceneTemplate.REQUIRED); 
    
        sceneTemplate.setPreference(
            org.havi.ui.HSceneTemplate.SCENE_SCREEN_LOCATION,
            new HScreenPoint(0.0f, 0.0f),
            org.havi.ui.HSceneTemplate.REQUIRED);
        
        //Een instantie van een Scene vragen aan de factory
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
            knop1 = new HTextButton("Heel cool");
            knop1.setLocation(100, 100);
            knop1.setSize(500, 50);
            knop1.setBackground(new DVBColor(0, 0, 0, 179));
            knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
            knop2 = new HTextButton("Extreem cool");
            knop2.setLocation(100, 200);
            knop2.setSize(500, 50);
            knop2.setBackground(new DVBColor(0, 0, 0, 179));
            knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
            knop3 = new HTextButton("Ongelofelijk cool");
            knop3.setLocation(100, 300);
            knop3.setSize(500, 50);
            knop3.setBackground(new DVBColor(0, 0, 0, 179));
            knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
            knop4 = new HTextButton("HEEL ONGELOFELIJK EXTREEM COOL");
            knop4.setLocation(100, 400);
            knop4.setSize(500, 50);
            knop4.setBackground(new DVBColor(0, 0, 0, 179));
            knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            knop5 = new HTextButton("Hulp Lijn");
            knop5.setLocation(300, 500);
            knop5.setSize(100, 50);
            knop5.setBackground(new DVBColor(0, 0, 0, 179));
            knop5.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop1);
        knop1.setFocusTraversal(knop5, knop2, null, null);
        
        knop1.addHActionListener(this);
        knop1.requestFocus();
            
        scene.add(knop2);
        knop2.setFocusTraversal(knop1, knop3, null, null);
        
        knop2.addHActionListener(this);
        
        scene.add(knop3);
        knop3.setFocusTraversal(knop2, knop4, null, null);
        
        knop3.addHActionListener(this);
            
        scene.add(knop4);
        knop4.setFocusTraversal(knop3, knop5, null, null);
        
        knop4.addHActionListener(this);
        
        scene.add(knop5);
        knop5.setFocusTraversal(knop4, knop1, null, null);
        
        knop5.addHActionListener(this);
        
        
        tekstLabel = new HStaticText("Hoe COOL is Seppe?");
        tekstLabel.setLocation(100, 25);
        tekstLabel.setSize(500, 50);
        tekstLabel.setBackground(new DVBColor(255, 255, 255, 179));
        tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(tekstLabel);
       
    }

    public void startXlet() throws XletStateChangeException
    {
        if(debug) System.out.println("Xlet Starten");
        
        //Scene zichtbaar maken
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet()
    {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
     
    }
    
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        
        if(e.getActionCommand().equals("knop4_actioned"))
        {
            System.out.println("You bet yah!!!");
            knop4.setBackground(new DVBColor(0, 255, 0, 179));
            /*tekstLabel.setTextContent("lala", 0);
            scene.repaint();*/
        }
        
        else if(e.getActionCommand().equals("knop5_actioned"))
        {
            knop1.setVisible(false);
            knop2.setVisible(false);
        }
        
        if(e.getActionCommand().equals("knop1_actioned"))
        {
            System.out.println("WRONG");
            knop1.setBackground(new DVBColor(255, 0, 0, 179));
        }
        
        if(e.getActionCommand().equals("knop2_actioned"))
        {
            System.out.println("WRONG");
            knop2.setBackground(new DVBColor(255, 0, 0, 179));
        }
        
        if(e.getActionCommand().equals("knop3_actioned"))
        {
            System.out.println("WRONG");
            knop3.setBackground(new DVBColor(255, 0, 0, 179));
        }
    }
}
