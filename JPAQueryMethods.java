package edu.utvt.springdata;

import edu.utvt.springdata.data.repositories.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JPAQueryMethods {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void findByFullName() {
        String fullName = "Harrison Ingram";
        playerRepository.findByFullName(fullName).forEach(System.out::println);
    }
}
