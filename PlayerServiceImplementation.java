package edu.utvt.springdata.data.services;

import edu.utvt.springdata.common.NotFoundElementException;
import edu.utvt.springdata.data.entities.Player;
import edu.utvt.springdata.data.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
            newPlayer.setFullname(player.getFullname());
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
    public void deleteById(Long playerId) {

        /*
        if(this.playerRepository.existsById(playerId)){
            this.playerRepository.deleteById(playerId);
        } else {
            throw new NoSuchElementException("No existe el jugador");
        }
        */
        Player playerOptional = this.playerRepository.findById(playerId).orElseThrow(()-> new NotFoundElementException("No existe el jugador"));
        this.playerRepository.delete(playerOptional);
    }

    @Override
    public Page<Player> findAll(Integer page, Integer pageSize){
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "full nmae"));
        return this.playerRepository.findAll(pageRequest);
    }
}