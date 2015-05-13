package hellotvxlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Section 
{
    private String name;
    private List articles = new ArrayList();
    
    public Section(String iName)
    {
        name = iName;    
    }
    
    private Object selectRandomArticle()
    {
        Random rndGen = new Random();
        int rnd = rndGen.nextInt(articles.size());
        
        Object item = articles.get(rnd);
              
        return item;
    }
}