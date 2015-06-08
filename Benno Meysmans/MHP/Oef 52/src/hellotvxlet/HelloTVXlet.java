package hellotvxlet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.tv.xlet.*;
import org.dvb.event.UserEvent;
import org.havi.ui.*;
import org.davic.resources.*;
import org.dvb.event.EventManager;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener 
{
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage pizza1 = new HBackgroundImage("pizza1.jpg");
    private HBackgroundImage pizza2 = new HBackgroundImage("pizza2.jpg");
    private HBackgroundImage pizza3 = new HBackgroundImage("pizza3.jpg");
    private HBackgroundImage pizza4 = new HBackgroundImage("pizza4.jpg");
    
    HScene scene = HSceneFactory.getInstance().getDefaultHScene();
    public int index = 1;
    public void notifyRelease(ResourceProxy proxy){};
    public void release(ResourceProxy proxy){};
    public boolean requestRelease(ResourceProxy proxy, Object requestData){return false;}
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException 
    {
        pizza1.flush();
        pizza2.flush();
        pizza3.flush();
        pizza4.flush();
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException 
    {   
        screen = HScreen.getDefaultHScreen();
        MijnComponent mc = new MijnComponent(450, 30, 200, 200, "Uw keuze:");
        
        scene.add(mc);
        scene.validate();
        scene.setVisible(true);
        
        bgDevice = screen.getDefaultHBackgroundDevice();
        
        if(bgDevice.reserveDevice(this))
        {
            System.out.println("BackgroundImage device has been reserverd");
        }
        else
        {
            System.out.println("Background image device cannot be reserved");
        }
        
        bgTemplate = new HBackgroundConfigTemplate();       
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);   
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        
        try
        {
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        
        catch(java.lang.Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void pauseXlet() 
    {
        
    }

    public void startXlet() throws XletStateChangeException {
       
       pizza1.load(this);
       pizza2.load(this);
       pizza3.load(this);
       pizza4.load(this);
       
       EventManager manager = EventManager.getInstance();      
       UserEventRepository repository = new UserEventRepository("PizzaControls");
        
       repository.addKey(org.havi.ui.event.HRcEvent.VK_UP);
       repository.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
       repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
       repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
       repository.addKey(org.havi.ui.event.HRcEvent.VK_ENTER);       
       manager.addUserEventListener(this, repository);
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        
        try
        {
            bgConfiguration.displayImage(pizza1);
        }
        catch(Exception s)
        {
            System.out.println(s.toString());
        }
    }
    
    public void swapImage(int i)
    {
        String image = "pizza" + i;
  
        if(image.equals("pizza1"))
        {
            try
            {
                bgConfiguration.displayImage(pizza1);
            }
            
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("pizza2"))
        {
            try
            {
                bgConfiguration.displayImage(pizza2);
            }
            
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("pizza3"))
        {
            try
            {
                bgConfiguration.displayImage(pizza3);
            }
            
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("pizza4"))
        {
            try
            {
                bgConfiguration.displayImage(pizza4);
            }
            
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }       
    }
    
    public void changePizza(int nr)
    {   
        MijnComponent gekozenPizza;
        if(nr == 1)
        {
            gekozenPizza = new MijnComponent(450, 75, 200, 200, "Meat Lover's");
        }
        
        else if(nr == 2)
        {
            gekozenPizza = new MijnComponent(450, 100, 200, 200, "Pepperoni Lover's");
        }
        
        else if(nr == 3)
        {
            gekozenPizza = new MijnComponent(450, 125, 200, 200, "Cheese Lover's");
        }
        
        else
        {
            gekozenPizza = new MijnComponent(450, 150, 200, 200, "Vegi Lover's");
        }

        scene.add(gekozenPizza);
        scene.validate();
        scene.setVisible(true);
        scene.repaint();
    }

    public void imageLoadFailed(HBackgroundImageEvent e) 
    {
        System.out.println("Image kan niet geladen worden");
    }

    public void userEventReceived(UserEvent e) 
    {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed button");
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    System.out.println("VK_UP is PRESSED");
                    index++;
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN PRESSED");
                    index--;
                    break;
                case HRcEvent.VK_LEFT:
                    System.out.println("VK_LEFT PRESSED");
                    index--;
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("VK_RIGHT PRESSED");
                    index++;
                    break;
                case HRcEvent.VK_ENTER:
                    System.out.println("VK_ENTER PRESSED");
                    changePizza(index);
                break;
            }
            
            if(index > 4) index = 1;
            if(index < 1) index = 4;
            
            swapImage(index);
            System.out.println(index);
        }
    }   
}