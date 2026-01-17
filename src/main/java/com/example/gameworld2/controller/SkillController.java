package com.example.gameworld2.controller;

import com.example.gameworld2.controller.req.EquipSkillReq;
import com.example.gameworld2.controller.req.LearnSkillReq;
import com.example.gameworld2.dao.PlayersMap;
import com.example.gameworld2.dao.PlayerSkillShop;
import com.example.gameworld2.model.Player;
import com.example.gameworld2.model.skill.PlayerSkillDefine;
import com.example.gameworld2.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class SkillController {

    private final PlayerSkillShop skillShop;
    private final PlayersMap playersMap;
    private final SkillService skillService;
    @Autowired
    public SkillController(PlayerSkillShop skillShop, PlayersMap playersMap, SkillService skillService){
        this.skillShop=skillShop;
        this.playersMap=playersMap;
        this.skillService=skillService;
    }


    @PostMapping("/learnskill")
    public Player learnskill(@RequestBody LearnSkillReq learnSkillReq){
        return skillService.learnSkill(learnSkillReq.getSkillId(), learnSkillReq.getPlayerId());
    }
    @GetMapping("/skillshop")
    public Collection<PlayerSkillDefine> showShop(){
        return skillShop.listAll();
    }
    @PostMapping("/equipskill")
    public Player equipSkill(@RequestBody EquipSkillReq equipSkillReq){
        return skillService.equipSkill(equipSkillReq.getSkillId(),equipSkillReq.getPlayerId(),equipSkillReq.getIndex());
    }


}
