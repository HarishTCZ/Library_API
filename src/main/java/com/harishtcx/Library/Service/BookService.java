package com.harishtcx.Library.Service;

import com.harishtcx.Library.Entity.Book;
import com.harishtcx.Library.Entity.User;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book createUser(Book book);
    Book borrowBook(Long bookId, Long userId);
    Book returnBook(Long bookId);
    void deleteUser(Long id);
}
