package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 347);
        Book book2 = new Book("My - my", 123);
        Book book3 = new Book("Koran", 400);
        Book book4 = new Book("Sonet", 47);
        Book[] myLibrary = new Book[4];
        myLibrary[0] = book1;
        myLibrary[1] = book2;
        myLibrary[2] = book3;
        myLibrary[3] = book4;

        for (int i = 0; i < 4; i++) {
            System.out.println(myLibrary[i]);
        }
        Book temp = myLibrary[0];
        myLibrary[0] = myLibrary[3];
        myLibrary[3] = temp;
        for (int i = 0; i < 4; i++) {
            System.out.println(myLibrary[i]);
        }
        for (int i = 0; i < 4; i++) {
            if (myLibrary[i].getName().equals("Clean code")) {
                System.out.println(myLibrary[i]);
            }
        }
    }
}

