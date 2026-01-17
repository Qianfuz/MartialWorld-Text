package com.example.gameworld2.service;

import com.example.gameworld2.controller.req.FightReq;
import com.example.gameworld2.dao.EnemysMap;
import com.example.gameworld2.dao.FightsMap;
import com.example.gameworld2.dao.PlayersMap;
import com.example.gameworld2.model.Enemy;
import com.example.gameworld2.model.Fight;
import com.example.gameworld2.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FightService {

    private final PlayersMap playersMap;
    private final EnemysMap enemysMap;
    private final FightsMap fightsMap;
    @Autowired
    public FightService(PlayersMap playersMap,EnemysMap enemysMap,FightsMap fightsMap){
        this.playersMap=playersMap;
        this.enemysMap=enemysMap;
        this.fightsMap=fightsMap;
    }


    public Fight initFight(Integer id,String enemyId){
        Fight f = fightsMap.createFight(id);
        Player p = playersMap.getPlayer(id);
        Enemy e = enemysMap.getEnemy(enemyId);
        f.setCurPlayerHp(p.getHp());
        f.setCurEnemyHp(e.getHp());
        f.setCurPlayerMp(p.getMp());
        return f;
    }

}