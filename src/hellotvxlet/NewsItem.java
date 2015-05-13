package hellotvxlet;

import java.util.Date;

public class NewsItem 
{
    private String name;
    private String desc;
    private String section;
    private Date publishedDate;
    
    public NewsItem(String iName, String iDesc, String iSection, Date iDate)
    {
        this.name = iName;
        this.desc = iDesc;
        this.section = iSection;
        this.publishedDate = iDate;
    }
       
    public String getPreview()
    {
        String textAr[] = this.desc.split(" ");
        String preview = "";
        
        for(int i = 0; i < 12; i++)
        {
           preview += textAr[i];
        }
        
        return preview;
    }
    
    public String getDesc()
    {
        return this.desc;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public Date getDate()
    {
        return this.publishedDate;
    }
}