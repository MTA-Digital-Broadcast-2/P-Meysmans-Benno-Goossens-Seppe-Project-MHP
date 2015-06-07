package hellotvxlet;

import java.awt.*;
import org.dvb.ui.*;
import org.havi.ui.HComponent;

public class MijnComponent extends HComponent 
{
    private Image bmpNaam;
    
    private int width, height;
    
    public MijnComponent(String bmpNaam, int x, int y)
    {   
        this.bmpNaam = this.getToolkit().getImage(bmpNaam);
   
        MediaTracker mtrack = new MediaTracker(this);
        mtrack.addImage(this.bmpNaam, 1);
        
        try 
        {
            mtrack.waitForAll();
        }
        
        catch (InterruptedException ex) 
        {
            ex.printStackTrace();
        }
                
        this.width = this.bmpNaam.getWidth(null);
        this.height = this.bmpNaam.getHeight(null);
        this.setBounds(x, y, this.width, this.height);
    }
    
    public void paint(Graphics g)
    {        
        g.drawImage(this.bmpNaam, 0, 0, null);
    }
    
    public void verplaats(int x, int y)
    {
        System.out.println("ticked");
        this.setBounds(x, y, this.width, this.height);
    }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public int getHeight()
    {
        return this.height;
    }
}
