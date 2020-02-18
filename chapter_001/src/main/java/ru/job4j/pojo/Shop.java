package ru.job4j.pojo;

public class Shop {

    public Product[] delete(Product[] products, int index) {
       for (int i = index; i < products.length; i++) {
            products[index] = products[index + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
    public static void main(String[] args) {
        Shop shop = new Shop();
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (Product p : products) {
            System.out.println(p.getName() + " " + p.getCount());
        }
        shop.delete(products, 1);
        for (Product p : products) {
            if (p != null) {
                System.out.println(p.getName() + " " + p.getCount());
            }
        }

    }
}
