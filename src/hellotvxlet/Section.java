package hellotvxlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Section 
{
    private String name;
    private List articles = new ArrayList();
    private NewsItem selectedArticle;
    
    public Section(String iName)
    {
        this.name = iName;
    }
    
    public List getArticles()
    {
        return this.articles;
    }
    
    public NewsItem getSelectedArticle()
    {
        return this.selectedArticle;
    }
    
    public void selectRandomArticle()
    {
        Random rndGen = new Random();
        int rnd = rndGen.nextInt(articles.size());
        
        Object obj = articles.get(rnd);        
        NewsItem item = null;
        
        if(obj instanceof NewsItem)
        {
            item = (NewsItem)obj;
        }
        
        this.selectedArticle = item;
    }
    
    public void addArticle(NewsItem article)
    {
        this.articles.add(article);
    }
}