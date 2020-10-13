package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository =publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println ("Started in Bootstrap2");
//added this section

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());


        //to here

        Author eric = new Author("Eric", "Carle");
        Book caterpillar = new Book ("Very Hungry Caterpillar", "1234");
        eric.getBooks().add(caterpillar);
        caterpillar.getAuthors().add(eric);

        caterpillar.setPublisher(publisher);
        publisher.getBooks().add(caterpillar);

        authorRepository.save(eric);
        bookRepository.save(caterpillar);
        publisherRepository.save(publisher);


        Author shel = new Author("Shel", "Silverstein");
        Book tree = new Book ("The Giving Tree", "2345");
        shel.getBooks().add(tree);
        tree.getAuthors().add(shel);

        tree.setPublisher(publisher);
        publisher.getBooks().add(tree);

        authorRepository.save(shel);
        bookRepository.save(tree);
        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());
    }
}
