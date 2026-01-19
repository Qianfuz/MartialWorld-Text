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
//
    public Player upgradeSkill(String skillId,Integer id){
        PlayerSkillDefine define = skillShop.getSkillDefine(skillId);
        Player p = playersMap.getPlayer(id);
        if(p.getSkillLvMap().get(skillId)==0 && p.getLv()>=define.getLvLimited() && p.getMoney()>=define.getMoneyCost()){
            p.getSkillLvMap().put(skillId,1);
            p.setMoney(p.getMoney()-define.getMoneyCost());
            p.getPlayerSkill().learnSkill1(skillId);
        } else {
            if(p.getMoney()>=(define.getMpCost()+p.getSkillLvMap().get(skillId)*1500)){
                p.setMoney(p.getMoney()-define.getMpCost()-p.getSkillLvMap().get(skillId)*1500);
                p.getSkillLvMap().put(skillId,p.getSkillLvMap().get(skillId)+1);
            }
        }
        return p;
    }
//
    public Player equipSkill(String skillId,Integer id,Integer index){
        Player p = playersMap.getPlayer(id);
        if(p.getPlayerSkill().getOwned().contains(skillId)){
            p.getPlayerSkill().equipSkill(skillId,index);
        }
        return p;
    }
}
