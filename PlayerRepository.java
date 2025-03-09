package edu.utvt.springdata.data.repositories;

import edu.utvt.springdata.data.entities.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    //JPA QueryMethods

    List<Player> findByFullName(String name);

    List<Player> findByFullNameContaining(String fullName);

    List<Player> findByTeamAndAge(String team, Integer age);

    Page<Player> findByTeam(String team, Pageable pageable);
}
