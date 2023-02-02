package org.practice.quarkus;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;


    public List<Book> getAllBooks(){
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2020, genre),
                new Book(2, "Practicing Quarkus", "Antonio", 2019, "IT"),
                new Book(3, "Random Book", "Antonio", 2010, "IT")
        );
    }
    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
