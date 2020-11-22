package product.impl;

import product.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside product.product.impl.Square::draw() method.");
    }
}
