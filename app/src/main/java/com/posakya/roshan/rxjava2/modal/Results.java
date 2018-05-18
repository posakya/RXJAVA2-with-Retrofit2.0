package com.posakya.roshan.rxjava2.modal;

/**
 * Created by lokesh on 5/17/18.
 */


public class Results
{
    private String id;

    private String title;

    private String description;

    private String image;

    private String newsdate;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getNewsdate ()
    {
        return newsdate;
    }

    public String setNewsdate (String newsdate)
    {
        this.newsdate = newsdate;
        return newsdate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", title = "+title+", description = "+description+", image = "+image+", newsdate = "+newsdate+"]";
    }
}

