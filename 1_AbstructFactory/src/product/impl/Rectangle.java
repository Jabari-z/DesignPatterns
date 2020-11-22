package product.impl;

import product.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside product.product.impl.Rectangle::draw() method.");
    }
}
