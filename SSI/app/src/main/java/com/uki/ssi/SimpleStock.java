package com.uki.ssi;

import android.graphics.drawable.Drawable;

public class SimpleStock {
    private String rank="-1";
    private String name="sample";
    private Drawable img1, img2, img3;
    private Stock[] mstock;
    SimpleStock(){ mstock = new Stock[3];}
    //set
    public void setRank(String _rank) { this.rank=_rank;}
    public void setName(String _name) { this.name=_name;}

    public void setImg1(Drawable img1) {
        this.img1 = img1;
    }
    public void setImg2(Drawable img2) {
        this.img2 = img2;
    }
    public void setImg3(Drawable img3) {
        this.img3 = img3;
    }
    //get
    public String getRank() {return this.rank;}
    public String getName() {return this.name;}
    public Drawable getImg1() {
        return img1;
    }
    public Drawable getImg2() {
        return img2;
    }
    public Drawable getImg3() {
        return img3;
    }
    //method
    public void syncImgByScore() {
        //growth
        //stability
        //interest
    }
}
