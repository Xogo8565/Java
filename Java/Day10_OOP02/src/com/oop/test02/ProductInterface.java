package com.oop.test02;

import com.oop.shop01.Product;

public interface ProductInterface {
    //추상 메서드로만 이뤄진 클래스를 인터페이스
    // 상수, 디폴트메서드, 정적메서드 등

    public final int MAX_COUNT = 30;

    //default Method
    void selectAll();

    //Static Method
    static void add(Product product){
        Product[] list = new Product[] {product};
    }

    //Abastact Method

    public abstract void update(Product product);
    public abstract void delete(Product product);
}
