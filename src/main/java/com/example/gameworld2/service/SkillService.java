package com.example.gameworld2.service;

import com.example.gameworld2.dao.PlayersMap;
import com.example.gameworld2.model.Player;
import com.example.gameworld2.model.skill.PlayerSkillDefine;
import com.example.gameworld2.dao.PlayerSkillShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillService {

    private final PlayerSkillShop skillShop;
    private final PlayersMap playersMap;
    @Autowired
    public SkillService(PlayerSkillShop skillShop, PlayersMap playersMap){
        this.skillShop=skillShop;
        this.playersMap=playersMap;
    }

    public Player upgradeSkill(String skillId,Integer id){
        PlayerSkillDefine define = skillShop.getSkillDefine(skillId);
        Player p = playersMap.getPlayer(id);
        if(define.getLv()==0){
            if(p.getLv()>=define.getLvLimited() && p.getMoney()>=define.getMoneyCost()){
                p.setMoney(p.getMoney()-define.getMoneyCost());
                p.getPlayerSkill().learnSkill1(skillId);
                define.setLv(define.getLv()+1);
            }
        } else {
            if(p.getMoney()>=define.getUpgradeCost()){
                p.setMoney(p.getMoney()-define.getUpgradeCost());
                define.setLv(define.getLv()+1);
                define.setHp(define.getHp()*23/20);
                define.setMpCost(define.getMpCost()*23/20);
                define.setUpgradeCost(define.getUpgradeCost()+1000);
            }
        }
        return p;
    }

    public Player equipSkill(String skillId,Integer id,Integer index){
        Player p = playersMap.getPlayer(id);
        if(p.getPlayerSkill().getOwned().contains(skillId)){
            p.getPlayerSkill().equipSkill(skillId,index);
        }
        return p;
    }




}
