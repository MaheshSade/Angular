package com.mahesh.player.service;

import com.mahesh.player.model.Player;
import com.mahesh.player.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepo repo;

    @Autowired
    Player p;

    public List<Player> getAllPlayers() throws Exception{
        List<Player> list = repo.findAll();
        for(Player p:list){
            double totalRuns = p.getMatch1()+p.getMatch2()+p.getMatch3();
            double totalBalls = p.getBalls1()+p.getBalls2()+p.getBalls3();
            p.setTotal((int) totalRuns);
            if(totalBalls>0){
                p.setStrikeRate(Math.round((totalRuns/totalBalls)*100));
            }
        }
        list.sort((a,b)->{
            return a.getTotal()>b.getTotal()?-1:1;
        });

        return list;
    }
    public Player getPlayer(int jerseyNo) {
        return repo.findById(jerseyNo).get();
    }
    public Player addPlayer(Player player){
        return repo.save(player);
    }

    public void deletePlayer(int jerseyNo) {
        repo.deleteById(jerseyNo);
    }

    public Player updatePlayer(Player player, int jerseyNo) {
        Player p = repo.findById(jerseyNo).get();

        if(player.getMatch1()!=0){
            p.setMatch1(player.getMatch1());
        }
        else {
            p.setMatch1(0);
        }
        if(player.getMatch2()!=0){
            p.setMatch2(player.getMatch2());
        }
        else {
            p.setMatch2(0);
        }
        if(player.getMatch3()!=0){
            p.setMatch3(player.getMatch3());
        }
        else {
            p.setMatch3(0);
        }
        if(player.getBalls1()!=0){
            p.setBalls1(player.getBalls1());
        }
        else {
            p.setBalls1(0);
        }
        if(player.getBalls2()!=0){
            p.setBalls2(player.getBalls2());
        }
        else {
            p.setBalls2(0);
        }
        if(player.getBalls3()!=0){
            p.setBalls3(player.getBalls3());
        }
        else {
            p.setBalls3(0);
        }

        repo.save(p);
        return p;
    }
}
