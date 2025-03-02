package edu.utvt.springdata.data.entities.repositories;

import edu.utvt.springdata.data.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,
        Long> {
}
