package com.posakya.roshan.rxjava2.modal;

/**
 * Created by lokesh on 5/20/18.
 */

public class MenuClass
{
    private String Date;

    private String Image;

    private String Item_Price;

    private String Discount_percent;

    private String Id;

    private String Item_Name;

    private String Menu_Type;

    public String getDate ()
    {
        return Date;
    }

    public void setDate (String Date)
    {
        this.Date = Date;
    }

    public String getImage ()
    {
        return Image;
    }

    public void setImage (String Image)
    {
        this.Image = Image;
    }

    public String getItem_Price ()
    {
        return Item_Price;
    }

    public void setItem_Price (String Item_Price)
    {
        this.Item_Price = Item_Price;
    }

    public String getDiscount_percent ()
    {
        return Discount_percent;
    }

    public void setDiscount_percent (String Discount_percent)
    {
        this.Discount_percent = Discount_percent;
    }

    public String getId ()
    {
        return Id;
    }

    public void setId (String Id)
    {
        this.Id = Id;
    }

    public String getItem_Name ()
    {
        return Item_Name;
    }

    public void setItem_Name (String Item_Name)
    {
        this.Item_Name = Item_Name;
    }

    public String getMenu_Type ()
    {
        return Menu_Type;
    }

    public void setMenu_Type (String Menu_Type)
    {
        this.Menu_Type = Menu_Type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Date = "+Date+", Image = "+Image+", Item_Price = "+Item_Price+", Discount_percent = "+Discount_percent+", Id = "+Id+", Item_Name = "+Item_Name+", Menu_Type = "+Menu_Type+"]";
    }
}
