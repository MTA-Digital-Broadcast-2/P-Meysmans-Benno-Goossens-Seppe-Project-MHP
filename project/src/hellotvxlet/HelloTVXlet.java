package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import org.dvb.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, HActionListener
{
    private XletContext actueleXletContext;
       
    private HScene scene;
    private HSceneTemplate sceneTemplate = new HSceneTemplate();
    private boolean debug = true;
    private Section section = new Section("Nieuws");
    
    private HStaticText titleArticle;
    private HStaticText textArticle;
    private HStaticText dateArticle;
    private HTextButton knopNextArticle;
    
    private NewsItem FirstNewsItem, SecondNewsItem, ThirdNewsItem, FourthNewsItem, FifthNewsItem;

    
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
       
       //Artikel   
       FirstNewsItem = new NewsItem(   "Té enthousiaste naaktfietser aan de kant gezet",
                                        "Een deelnemer aan de Naked Bike Ride in het Engelse graafschap Kent trok vorig weekend aan het kortste eind. " +
                                        "Nog voor de eigenlijke start van de naakfietshappening werd de man aan de kant gezet. Bleek dat hij zich iets " +
                                        "te veel had laten meeslepen bij de aanblik van de hem omringende blote mensen. " +
                                        "Ik hoorde kreten van afschuw en ik keek wat er aan de hand was, getuigt een andere deelnemer tegenover The Cambridge News. " +
                                        "Wat ik zag was redelijk ontnuchterend. We kunnen gerust stellen dat een van de fietsers iets te opgewonden was geraakt, " +
                                        "wat zich vertaalde in de toestand waarin zijn lid zich bevond. Iemand van de organisatie begaf zich naar de enthousiasteling " +
                                        "en vroeg hem zijn kleren aan te trekken. Tegelijk bracht hij via een walkietalkie de politie op de hoogte. De man deed alsof " +
                                        "hij het in Keulen hoorde donderen toen de agenten hem tot de orde riepen. Dergelijk gedrag kunnen we niet aanvaarden, " +
                                        "zegt organisator Barry Freeman. De persoon in kwestie werd weggestuurd nog voor de Naked Bike Ride van start ging",
                                        "Een",
                                        "2015-06-01");
        
        SecondNewsItem = new NewsItem(  "Veel wateroverlast door kort maar hevig onweer",
                                        "Er trekt deze namiddag een hevig onweer over Vlaanderen. Vooral West- en Oost-Vlaanderen kregen heel wat neerslag te verwerken. " +
                                        "Onder meer de Gentse Feesten en het BK wielrennen voor nieuwelingen in Hooglede kregen daaronder te lijden. In Gent stortte de " +
                                        "kartonnen toren van MiraMiro in en het BK wielrennen moest zelfs afgelast worden. Omstreeks 15.45 uur gingen de hemelsluizen open " +
                                        "en de felle regenval ging gepaard met hevige rukwinden. De wedstrijd werd eerst stilgelegd maar uiteindelijk besliste de jury om " +
                                        "het kampioenschap stop te zetten. Het is nog niet duidelijk wanneer de titelstrijd zal doorgaan. In West-Vlaanderen kregen " +
                                        "de brandweerkorpsen tientallen oproepen binnen. Behalve het BK wielrennen moest de brandweer in Hooglede op nog verschillende " +
                                        "andere plaatsen water wegpompen. Ook in andere West-Vlaamse gemeenten en steden waren er her en der problemen. Dat was onder " +
                                        "meer het geval in Ieper. De komende uren en morgen wordt er nog meer regen verwacht. In Charleroi kreeg de brandweer tegen " +
                                        "het eind van de middag meer dan honderd oproepen, en onder meer de kelders en liftkooien van het ziekenhuis Notre-Dame liepen " +
                                        "onder water. De brandweer zette er meerdere pompen in.",
                                        "Twee",
                                        "2014-07-27");
        
        ThirdNewsItem = new NewsItem(  "Voetbalclub zet speler die kanker overwon in kort telefoontje aan de deur",
                                        "Jonas Gutierrez, de Newcastle-speler die na een lange strijd teelbalkanker overwon, heeft in een kort telefoontje te horen " +
                                        "gekregen dat de club hem geen nieuw contract aanbiedt. Het was John Carver, interim-coach bij de 'Magpies', die Gutierrez de " +
                                        "onheilsboodschap bracht. Opmerkelijk: Carver had net voordien Ryan Taylor, een ploegmaat van Gutierrez, hetzelfde nieuws " +
                                        "overgemaakt. Carver belde mij op en vertelde dat de club mij geen nieuwe overeenkomst zou aanbieden, zegt Taylor. " +
                                        "Ik praatte nog even met hem en toen vroeg hij me om Jonas (die samen met Taylor een trainerscursus volgde in Belfast, red.) " +
                                        "door te geven. Ongelooflijk maar waar. Ach, ik kan John niks verwijten. Hij voert enkel maar de instructies uit die hij krijgt. " +
                                        "Ik hoorde aan zijn stem dat hij het moeilijk had om twee spelers die zo lang bij Newcastle zijn geweest, op deze wijze te ontslaan. " +
                                        "Gutierrez, die nota bene op de slotdag van de competitie met een goal een belangrijk aandeel had in de redding van Newcastle, " +
                                        "reageerde kort op zijn ontslag. Ik verwachtte niet om een nieuw contract te krijgen, aldus de Argentijn. Het leven gaat verder. " +
                                        "Supporters van Newcastle drukken hun afschuw uit voor de manier waarop de club met beide spelers omging. " +
                                        "Respectloos, harteloos, regent het reacties op sociale media.",
                                        "Drie",
                                        "2015-06-02");
        
        FourthNewsItem = new NewsItem(  "Kort geding tegen Facebook om wraakporno",
                                        "Een Nederlands slachtoffer van wraakporno spant een kort geding aan tegen Facebook omdat ze via gebruikersgegevens wil " +
                                        "achterhalen wie een seksfilmpje van haar daarop heeft gezet. Het is volgens haar advocaat, Thomas van Vugt, de allereerste " +
                                        "keer dat zoiets in Nederland gebeurt. De uitspraak van de rechter is dus van groot belang voor andere slachtoffers'', zegt Van Vugt. " +
                                        "Deze avond gaat het tv-programma Internetpesters Aangepakt, van Peter R. de Vries op de commerciële zender RTL, over deze zaak. " +
                                        "De Vries stelt er al maanden mee bezig te zijn. Een kort geding tegen Facebook zou de enige manier zijn om de dader te achterhalen. " +
                                        "Volgens advocaat Van Vugt is het dus de eerste keer dat de rechter wordt gevraagd om Facebook te bevelen gebruikersgegevens te " +
                                        "verstrekken. Wat vindt de rechter zwaarder wegen: de privacy van de personen achter dit soort anonieme nepaccounts op Facebook, " +
                                        "of het belang van het slachtoffer om te weten wie dat op zijn of haar geweten heeft. Mijn cliënte heeft ontzettend veel last van " +
                                        "dat filmpje. Haar reputatie is geruïneerd.",
                                        "Vier",
                                        "2015-06-01");
        
        FifthNewsItem = new NewsItem(  "Jennifer Lopez kiest voor korte coupe",
                                       "Jennifer Lopez (45) heeft gedag gezegd tegen haar sexy lange lokken. De latinovamp is gespot op het vliegveld van Los Angeles met " +
                                       "een verrassende korte coupe. Haar donkerblonde haarkleur is hetzelfde gebleven. Een grote zwarte zonnebril kon La Lopez niet " +
                                       "anoniem over LAX doen gaan. Een handjevol fans herkenden hun idool, die arriveerde in een spijkerbroek en een blauwe naveltrui. " +
                                       "De aankomst van Jennifer werd enthousiast ontvangen. Haar bewonderaars applaudisseerden en bestrooiden de actrice met confetti. " +
                                       "Het is niet bekend waarom Jennifer haar sexy look gedag heeft gezegd. Mocht ze heimwee krijgen naar lang haar, dan kan de " +
                                       "Amerikaanse altijd nog kiezen voor hairextensions.",
                                       "Vijf",
                                       "2015-05-27");
       
       section.addArticle(FirstNewsItem);
       section.addArticle(SecondNewsItem);
       section.addArticle(ThirdNewsItem);
       section.addArticle(FourthNewsItem);
       section.addArticle(FifthNewsItem);
              
           section.selectRandomArticle();
       
            titleArticle = new HStaticText(section.getSelectedArticle().getName());
            titleArticle.setLocation(100, 75);
            titleArticle.setSize(500, 50);
            titleArticle.setBackground(new DVBColor(0, 0, 0, 179));
            titleArticle.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            textArticle = new HStaticText(section.getSelectedArticle().getDesc());
            textArticle.setLocation(50, 175);
            textArticle.setSize(600, 300);
            textArticle.setBackground(new DVBColor(0, 0, 0, 179));
            textArticle.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
            knopNextArticle = new HTextButton("Volgende artikel");
            knopNextArticle.setLocation(500, 500);
            knopNextArticle.setSize(175, 50);
            knopNextArticle.setBackground(new DVBColor(0, 0, 0, 179));
            knopNextArticle.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            dateArticle = new HStaticText(section.getSelectedArticle().getDate());
            dateArticle.setLocation(50, 500);
            dateArticle.setSize(100, 50);
            dateArticle.setBackground(new DVBColor(0, 0, 0, 179));
            dateArticle.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
       scene.add(titleArticle);
       scene.add(textArticle);
       scene.add(dateArticle);
       
       scene.add(knopNextArticle);
       knopNextArticle.requestFocus();
       knopNextArticle.addHActionListener(this);

       

        
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
    
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        
        if(e.getActionCommand().equals("knopNextArticle_actioned"))
        {
            changeArticle();
        }
    }
    
    public void changeArticle()
    {
           System.out.println("Next Article");
           section.selectRandomArticle();
           scene.remove(titleArticle);
           scene.remove(textArticle);
           scene.remove(dateArticle);
           
           titleArticle = new HStaticText(section.getSelectedArticle().getName());
           titleArticle.setLocation(100, 75);
           titleArticle.setSize(500, 50);
           titleArticle.setBackground(new DVBColor(0, 0, 0, 179));
           titleArticle.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
           textArticle = new HStaticText(section.getSelectedArticle().getDesc());
           textArticle.setLocation(50, 175);
           textArticle.setSize(600, 300);
           textArticle.setBackground(new DVBColor(0, 0, 0, 179));
           textArticle.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
           dateArticle = new HStaticText(section.getSelectedArticle().getDate());
           dateArticle.setLocation(50, 500);
           dateArticle.setSize(100, 50);
           dateArticle.setBackground(new DVBColor(0, 0, 0, 179));
           dateArticle.setBackgroundMode(HVisible.BACKGROUND_FILL);
           
           scene.add(titleArticle);
           scene.add(textArticle);
           scene.add(dateArticle);
           
           scene.repaint(); 
    }
}
