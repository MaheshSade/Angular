package com.mahesh.player.controller;

import com.mahesh.player.model.Player;
import com.mahesh.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
@CrossOrigin("http://localhost:4200/")
public class PlayerController {
    @Autowired
    PlayerService service;


    @GetMapping("players")
    public List<Player> getAllPlayers() throws Exception {
        return service.getAllPlayers();
    }

    @GetMapping("players/{jerseyNo}")
    public Player getPlayer(@PathVariable int jerseyNo) {
        return service.getPlayer(jerseyNo);
    }

    @PostMapping(value = "players")
    public Player addPlayer(@RequestBody Player player) {
        return service.addPlayer(player);
    }


    @PutMapping("players/{jerseyNo}")
    public Player updatePlayer(@RequestBody Player player,@PathVariable int jerseyNo) {
        return service.updatePlayer(player,jerseyNo);
    }


    @DeleteMapping("players/{jerseyNo}")
    public void deletePlayer(@PathVariable int jerseyNo) {
        service.deletePlayer(jerseyNo);
    }
}
