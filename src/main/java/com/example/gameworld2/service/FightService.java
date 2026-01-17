package com.example.gameworld2.service;

import com.example.gameworld2.controller.req.FightReq;
import com.example.gameworld2.controller.req.UseSkillReq;
import com.example.gameworld2.dao.EnemysMap;
import com.example.gameworld2.dao.FightsMap;
import com.example.gameworld2.dao.PlayerSkillShop;
import com.example.gameworld2.dao.PlayersMap;
import com.example.gameworld2.model.Enemy;
import com.example.gameworld2.model.Fight;
import com.example.gameworld2.model.Player;
import com.example.gameworld2.model.skill.EnemySkillDefine;
import com.example.gameworld2.model.skill.PlayerSkillDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FightService {

    private final PlayersMap playersMap;
    private final EnemysMap enemysMap;
    private final FightsMap fightsMap;
    private final PlayerSkillShop playerSkillShop;
    @Autowired
    public FightService(PlayerSkillShop playerSkillShop,PlayersMap playersMap,EnemysMap enemysMap,FightsMap fightsMap){
        this.playersMap=playersMap;
        this.enemysMap=enemysMap;
        this.fightsMap=fightsMap;
        this.playerSkillShop=playerSkillShop;

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

    public Fight useSkill(UseSkillReq useSkillReq){
        //Player p = playersMap.getPlayer(useSkillReq.getPlayerId());
        StringBuilder sb = new StringBuilder();
        Fight f = fightsMap.createFight(useSkillReq.getPlayerId());
        Enemy e = enemysMap.getEnemy(useSkillReq.getEnemyId());
        PlayerSkillDefine playerSkillDefine=playerSkillShop.getSkillDefine(useSkillReq.getSkillId());

        if(f.getCurPlayerMp()-playerSkillDefine.getMpCost()>=0){
            f.setCurPlayerMp(f.getCurPlayerMp()-playerSkillDefine.getMpCost());
        }else{
            return f;
        }
        f.setCurEnemyHp(f.getCurEnemyHp()-playerSkillDefine.getHp());
        sb.append("你 使用 ").append("[").append(playerSkillDefine.getName()).append("] ")
                .append("造成了 ").append(playerSkillDefine.getHp()).append(" 点 伤害")
                .append("\n");
        if(f.getCurEnemyHp()<=0){
            f.setCurEnemyHp(0);
            f.getLog().add(sb.toString());
            return f;
        }

        Random random = new Random();
        Integer r = random.nextInt(4);
        EnemySkillDefine enemySkillDefine=e.getEnemySkill().getEnemySkillDefine(r);
        f.setCurPlayerHp(f.getCurPlayerHp()-enemySkillDefine.getHp());

        sb.append("[").append(e.getName()).append("] ")
                .append("使用 ").append("[").append(enemySkillDefine.getName()).append("] ")
                .append("造成了 ").append(enemySkillDefine.getHp()).append(" 点 伤害").append("\n");
        f.getLog().add(sb.toString());
        return f;
    }

}