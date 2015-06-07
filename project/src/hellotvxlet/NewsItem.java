package hellotvxlet;

import java.util.Date;

public class NewsItem 
{
    private String name;
    private String desc;
    private String section;
    private String publishedDate;
    
    public NewsItem(String iName, String iDesc, String iSection, String iDate)
    {
        this.name = iName;
        this.desc = iDesc;
        this.section = iSection;
        this.publishedDate = iDate;
    }
    
    public String getDesc()
    {
        return this.desc;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getDate()
    {
        return this.publishedDate;
    }
}