package edu.utvt.springdata;

import edu.utvt.springdata.data.common.PublishingCompanies;

import edu.utvt.springdata.data.common.RatingOptions;
import edu.utvt.springdata.data.entities.Author;
import edu.utvt.springdata.data.entities.Book;
import edu.utvt.springdata.data.entities.Rating;
import edu.utvt.springdata.data.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.AbstractList;
import java.util.ArrayList;

@SpringBootTest
public class OneToManyTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void addAll(){
        Book book = new Book(null, "El Hobbit",
                PublishingCompanies.PEARSON, 1937, new ArrayList<Rating>(),
                new ArrayList<Author>() {
            @Override
            public Author get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        });
        Rating rating = new Rating(null, RatingOptions.NOT_FOR_ME, book);
        book.getRatings().add(rating);
        this.bookRepository.save(book);
    }

    @Test
    void addBook(){
        Book book = new Book(null, "El señor de los anillos",
                PublishingCompanies.PEARSON, 1956, new ArrayList<Rating>(), new ArrayList<>());
        this.bookRepository.save(book);
    }

    @Test
    @Transactional
    @Rollback(false)
    void addRating(){

        Book book = null;

        if(this.bookRepository.count() > 0){
            book = this.bookRepository.findAll().getLast();
            Rating rating = new Rating(null, RatingOptions.I_LIKE_THIS, book);
            book.getRatings().add(rating);
            this.bookRepository.save(book);
        }
    }

    @Test
    void eagerFeatch(){
        Book book = null;

        if(this.bookRepository.count() > 0){

            book = this.bookRepository.findAll().getFirst();

            Rating rating = new Rating(null, RatingOptions.I_LIKE_THIS, book);
            book.getRatings().add(rating);
            this.bookRepository.save(book);

            for(Rating rat : book.getRatings()){
                System.out.println(rating);
            }

        }

    }

    @Test
    void delete(){

        Book book = this.bookRepository.findAll().getFirst();

        if(book != null){
            this.bookRepository.delete(book);
        }
    }
}
