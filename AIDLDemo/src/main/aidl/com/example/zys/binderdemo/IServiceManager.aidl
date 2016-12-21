// IServiceManager.aidl
package com.example.zys.binderdemo;

import com.example.zys.binderdemo.Book;

// Declare any non-default types here with import statements

interface IServiceManager {

    List<Book> getBooks();

    void addBook(in Book book);

}
