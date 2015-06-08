package hellotvxlet;

import org.havi.ui.HComponent;
import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

public class MijnComponent extends HComponent {
    
    public String txt;
    
    public MijnComponent(int x, int y, int h, int w, String txt)
    {
        this.setBounds(x, y, h, w);
        this.txt = txt;
    } 

    public void paint(Graphics g)
    {
        g.setColor(new DVBColor(255,255,255,255));
        g.drawString(txt, 10, 20);
    }

}