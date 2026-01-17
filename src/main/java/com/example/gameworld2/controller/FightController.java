package com.example.gameworld2.controller;

import com.example.gameworld2.controller.req.FightReq;
import com.example.gameworld2.dao.EnemysMap;
import com.example.gameworld2.dao.FightsMap;
import com.example.gameworld2.dao.PlayerSkillShop;
import com.example.gameworld2.dao.PlayersMap;
import com.example.gameworld2.model.Enemy;
import com.example.gameworld2.model.Fight;
import com.example.gameworld2.service.FightService;
import com.example.gameworld2.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class FightController {

    private final PlayerSkillShop skillShop;
    private final PlayersMap playersMap;
    private final SkillService skillService;
    private final EnemysMap enemysMap;
    private final FightsMap fightsMap;
    private final FightService fightService;
    @Autowired
    public FightController(FightService fightService,PlayerSkillShop skillShop, PlayersMap playersMap, SkillService skillService,EnemysMap enemysMap,FightsMap fightsMap){
        this.skillShop=skillShop;
        this.playersMap=playersMap;
        this.skillService=skillService;
        this.enemysMap=enemysMap;
        this.fightsMap=fightsMap;
        this.fightService=fightService;
    }


    @GetMapping("/enemylist")
    public Collection<Enemy> showEnemy(){
        return enemysMap.listAll();
    }

    @PostMapping("/fight")
    public Fight startFight(@RequestBody FightReq fightReq){
        fightsMap.createFight(fightReq.getPlayerId());
        return fightService.initFight(fightReq.getPlayerId(),fightReq.getEnemyId());
    }
}