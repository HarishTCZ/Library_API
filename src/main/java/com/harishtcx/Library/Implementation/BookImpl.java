package com.harishtcx.Library.Implementation;

import com.harishtcx.Library.Entity.Book;
import com.harishtcx.Library.Entity.User;
import com.harishtcx.Library.Repository.BookRepository;
import com.harishtcx.Library.Repository.UserRepository;
import com.harishtcx.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Book> findAll() { //RETURN ALL OBJECTS
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) { //RETURN THE OBJECT WITH THAT SPECIFIC ID
        return bookRepository.findById(id);
    }

    @Override
    public Book createUser(Book book) { //CREATE A NEW OBJECT
        return bookRepository.save(book);
    }

    @Override
    public void deleteUser(Long id) { //DELETE AN OBJECT
        bookRepository.deleteById(id);
    }

    @Override
    public Book borrowBook(Long bookId, Long userId) { //UPDATE AN OBJECT
        Book book = bookRepository.findById(bookId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if(book!=null && user!=null){
           book.setBorrowed(true);
           book.setBorrowed_by(user);
           return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public Book returnBook(Long bookId) { //AGAIN UPDATING THE OBJECT BUT TO DIFFERENT CONDITIONS
        Book book = bookRepository.findById(bookId).orElse(null);
        if(book!=null){
            book.setBorrowed_by(null); //SET USER TO NULL
            book.setBorrowed(false);
            return bookRepository.save(book);
        }
        return null;
    }
}
