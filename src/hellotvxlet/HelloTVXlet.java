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
    
    private HStaticText titelBinnenland, titelBuitenland, titelSport, titelEconomie, titelCultuur;
    private HStaticText tekstBinnenland, tekstBuitenland, tekstSport, tekstEconomie, tekstCultuur;
    private HTextButton knopBinnenlandMeer, knopBuitenlandMeer, knopSportMeer, knopEconomieMeer, knopCultuurMeer;

    
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
            titelBinnenland = new HStaticText("Titel binnenland");
            titelBinnenland.setLocation(10, 75);
            titelBinnenland.setSize(100, 50);
            titelBinnenland.setBackground(new DVBColor(0, 0, 0, 179));
            titelBinnenland.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            tekstBinnenland = new HStaticText("Tekst binnenland");
            tekstBinnenland.setLocation(10, 75);
            tekstBinnenland.setSize(200, 100);
            tekstBinnenland.setBackground(new DVBColor(0, 0, 0, 179));
            tekstBinnenland.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
            knopBinnenlandMeer = new HTextButton("Lees meer BINNENLAND ...");
            knopBinnenlandMeer.setLocation(10, 100);
            knopBinnenlandMeer.setSize(50, 20);
            knopBinnenlandMeer.setBackground(new DVBColor(0, 0, 0, 179));
            knopBinnenlandMeer.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
       //Buitenland
            titelBuitenland = new HStaticText("Titel buitenland");
            titelBuitenland.setLocation(10, 175);
            titelBuitenland.setSize(100, 50);
            titelBuitenland.setBackground(new DVBColor(0, 0, 0, 179));
            titelBuitenland.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            tekstBuitenland = new HStaticText("Tekst buitenland");
            tekstBuitenland.setLocation(10, 175);
            tekstBuitenland.setSize(200, 100);
            tekstBuitenland.setBackground(new DVBColor(0, 0, 0, 179));
            tekstBuitenland.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            knopBuitenlandMeer = new HTextButton("Lees meer BUITENLAND ...");
            knopBuitenlandMeer.setLocation(10, 200);
            knopBuitenlandMeer.setSize(50, 20);
            knopBuitenlandMeer.setBackground(new DVBColor(0, 0, 0, 179));
            knopBuitenlandMeer.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
       //Sport
            titelSport = new HStaticText("Titel sport");
            titelSport.setLocation(10, 275);
            titelSport.setSize(100, 50);
            titelSport.setBackground(new DVBColor(0, 0, 0, 179));
            titelSport.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            tekstSport = new HStaticText("Tekst sport");
            tekstSport.setLocation(10, 275);
            tekstSport.setSize(200, 100);
            tekstSport.setBackground(new DVBColor(0, 0, 0, 179));
            tekstSport.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            knopSportMeer = new HTextButton("Lees meer SPORT ...");
            knopSportMeer.setLocation(10, 300);
            knopSportMeer.setSize(50, 20);
            knopSportMeer.setBackground(new DVBColor(0, 0, 0, 179));
            knopSportMeer.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
       //Economie
            titelEconomie = new HStaticText("Titel economie");
            titelEconomie.setLocation(10, 375);
            titelEconomie.setSize(100, 50);
            titelEconomie.setBackground(new DVBColor(0, 0, 0, 179));
            titelEconomie.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            tekstEconomie = new HStaticText("Tekst economie");
            tekstEconomie.setLocation(10, 375);
            tekstEconomie.setSize(200, 100);
            tekstEconomie.setBackground(new DVBColor(0, 0, 0, 179));
            tekstEconomie.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            knopEconomieMeer = new HTextButton("Lees meer ECONOMIE ...");
            knopEconomieMeer.setLocation(10, 400);
            knopEconomieMeer.setSize(50, 20);
            knopEconomieMeer.setBackground(new DVBColor(0, 0, 0, 179));
            knopEconomieMeer.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
       //Cultuur
            titelCultuur = new HStaticText("Titel cultuur");
            titelCultuur.setLocation(10, 475);
            titelCultuur.setSize(100, 50);
            titelCultuur.setBackground(new DVBColor(0, 0, 0, 179));
            titelCultuur.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            tekstCultuur = new HStaticText("Tekst cultuur");
            tekstCultuur.setLocation(10, 475);
            tekstCultuur.setSize(200, 100);
            tekstCultuur.setBackground(new DVBColor(0, 0, 0, 179));
            tekstCultuur.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            knopCultuurMeer = new HTextButton("Lees meer CULTUUR ...");
            knopCultuurMeer.setLocation(10, 500);
            knopCultuurMeer.setSize(50, 20);
            knopCultuurMeer.setBackground(new DVBColor(0, 0, 0, 179));
            knopCultuurMeer.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
       scene.add(titelBinnenland);
       //scene.add(tekstBinnenland);
       scene.add(knopBinnenlandMeer);
       
       scene.add(titelBuitenland);
       //scene.add(tekstBuitenland);
       scene.add(knopBuitenlandMeer);
       
       scene.add(titelSport);
       //scene.add(tekstSport);
       scene.add(knopSportMeer);
       
       scene.add(titelEconomie);
       //scene.add(tekstEconomie);
       scene.add(knopEconomieMeer);
       
       scene.add(titelCultuur);
       //scene.add(tekstCultuur);
       scene.add(knopCultuurMeer);

       
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
