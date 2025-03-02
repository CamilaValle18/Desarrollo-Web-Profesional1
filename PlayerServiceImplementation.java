package edu.utvt.springdata.data.services;

import edu.utvt.springdata.data.entities.Player;
import edu.utvt.springdata.data.entities.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImplementation implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;


    @Override
    public Player save(Player player) {
        return this.playerRepository.save(player);
    }

    @Override
    public Player update(Player player, Long playerId) {

        Optional<Player> playerOptional = this.playerRepository.findById(playerId);

        if (playerOptional.isPresent()) {
            Player newPlayer = playerOptional.get();
            newPlayer.setAge(player.getAge());
            newPlayer.setDrtg(player.getDrtg());
            newPlayer.setTeam(player.getTeam());
            newPlayer.setFullName(player.getFullName());
            this.playerRepository.save(newPlayer);
        }
        return playerOptional.orElseThrow();
    }

    @Override
    public Optional<Player> findById(Long playerId) {
        return this.playerRepository.findById(playerId);
    }

    @Override
    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public Player deleteById(Long playerId) {
        return null;
    }
}
