package com.example.gameworld2.controller;

import com.example.gameworld2.dao.PlayersMap;
import com.example.gameworld2.dao.PlayerSkillShop;
import com.example.gameworld2.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final PlayersMap playersMap;

    @Autowired
    public RegisterController(PlayersMap playersMap, PlayerSkillShop skillShop) {
        this.playersMap = playersMap;
    }

    @PostMapping("/register")
    public Player register(@RequestBody Player player) {
        if (playersMap.getPlayer(player.getId()) == null) {
            playersMap.register(player.getId(), player.getName());
        }
        return playersMap.getPlayer(player.getId());
    }

}
