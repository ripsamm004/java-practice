package com.designpattern;

/**
 * Created by shiful on 05/05/2018.
 * Substitute principle we can use a subclass for a base class without break the things.
 * We can extends a api base class and add extra functions in the subclass without break the
 * api base class.
 *
 */

class Rectangle{

    protected int width, hight;

    public Rectangle() {
    }

    public Rectangle(int width, int hight) {
        this.width = width;
        this.hight = hight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public int getArea(){
        return width * hight;
    }
}

class Square extends Rectangle {

    public Square(int size) {
        width = hight = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHight(width);
    }

    @Override
    public void setHight(int height) {
        super.setHight(height);
        super.setWidth(height);
    }

}


public class SubstitutionPrinciple {

    static void userIt(Rectangle r){
        int width = r.getWidth();



    }
}
