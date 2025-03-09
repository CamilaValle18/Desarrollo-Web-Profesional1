package edu.utvt.springdata.data.services;

import edu.utvt.springdata.data.entities.Player;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    public Player save (Player player);

    public Player update (Player player, Long playerId);

    public Optional<Player> findById(Long playerId);

    public List<Player> findAll();

    public void deleteById(Long playerId);

    public Page<Player> findAll(Integer page, Integer pageSize);
}

