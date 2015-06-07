package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import org.dvb.ui.*;


public class HelloTVXlet implements Xlet 
{
    private XletContext actueleXletContext;
       
    private HScene scene;
    private HSceneTemplate sceneTemplate = new HSceneTemplate();
    private boolean debug = true;
    
    private HStaticText titelArtikel;
    private HStaticText tekstArtikel;
    private HTextButton knopVolgendArtikel;

    
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
       
       //Binnenland
            titelArtikel = new HStaticText("Titel binnenland");
            titelArtikel.setLocation(100, 175);
            titelArtikel.setSize(300, 50);
            titelArtikel.setBackground(new DVBColor(0, 0, 0, 179));
            titelArtikel.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            tekstArtikel = new HStaticText("Tekst binnenland");
            tekstArtikel.setLocation(150, 75);
            tekstArtikel.setSize(200, 100);
            tekstArtikel.setBackground(new DVBColor(0, 0, 0, 179));
            tekstArtikel.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
            knopVolgendArtikel = new HTextButton("Lees meer BINNENLAND ...");
            knopVolgendArtikel.setLocation(500, 500);
            knopVolgendArtikel.setSize(50, 20);
            knopVolgendArtikel.setBackground(new DVBColor(0, 0, 0, 179));
            knopVolgendArtikel.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
       
       
       scene.add(titelArtikel);
       scene.add(tekstArtikel);
       scene.add(knopVolgendArtikel);

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
        
    //CREATE NEWSITEMS
    //CREATE SECTIONS
    //
    //for(int i = 0; i < sections; i++)
    //{
    //  for(int j = 0; j < articles; j++)
    //  {
    //      if(articles[j].getSection() == section[i].getName())
    //      {
    //          section[i].addArticle(articles[j]);
    //      }    
    //  }
    //
    //  section[i].selectRandomArticle();
    //}
}
