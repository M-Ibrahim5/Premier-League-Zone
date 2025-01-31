package com.PL.Premier_Zone.Service;

import com.PL.Premier_Zone.Model.Player;
import com.PL.Premier_Zone.Repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayer(){
        return playerRepository.findAll();
    }
    public List<Player> getPlayerFromTeam(String teamName){
        return playerRepository.findAll().stream().filter(
                player -> player.getTeam().toLowerCase().equals(teamName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByName(String seacrhText){
        return playerRepository.findAll().stream()
                .filter(player-> player.getName().toLowerCase().contains(seacrhText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByPosition(String searchText){
        return playerRepository.findAll().stream()
                .filter(player-> player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByNation(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors
                        .toList());
    }

    public List<Player> getPlayerByTeamAndPosition(String team, String position){
        return playerRepository.findAll().stream()
                .filter(player -> team.equals(player.getTeam().toLowerCase())&& position.equals(player.getPos().toLowerCase()))
                        .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatePlayer) {
        Optional<Player> existPlayer = playerRepository.findByName(updatePlayer.getName());

        if (existPlayer.isPresent()) {
            Player player = existPlayer.get();
            player.setTeam(updatePlayer.getTeam());
            player.setName(updatePlayer.getName());
            player.setPos(updatePlayer.getPos());
            player.setNation(updatePlayer.getNation());

            playerRepository.save(player);
            return player;
        } else {

            //throw new RuntimeException("Player not found");
            return null;
        }
    }

    @Transactional // this annotation make sure if the deletion fails for any reason, the transaction will be rolled back.
    public void deletPlayer(String playerName){
        playerRepository.deleteByName(playerName);
    }

}
