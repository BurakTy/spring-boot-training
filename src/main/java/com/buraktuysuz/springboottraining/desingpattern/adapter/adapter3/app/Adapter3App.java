package com.buraktuysuz.springboottraining.desingpattern.adapter.adapter3.app;

import com.buraktuysuz.springboottraining.desingpattern.adapter.adapter3.lib1.Book;
import com.buraktuysuz.springboottraining.desingpattern.adapter.adapter3.lib1.BookProvider;
import com.buraktuysuz.springboottraining.desingpattern.adapter.adapter3.lib2.Library;

import java.util.List;

public class Adapter3App {

    public static void main(String[] args) {

        BookProvider bookProvider = new BookProvider();
        Library library = new Library();

        List<Book> bookList = bookProvider.getBooks();

        for (Book book : bookList) {

            LibBookAdapter libBookAdapter = new LibBookAdapter(book);
            library.print(libBookAdapter);
        }
    }
}
