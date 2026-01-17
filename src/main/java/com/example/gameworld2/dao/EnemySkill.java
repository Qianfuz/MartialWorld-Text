package com.example.gameworld2.dao;


import com.example.gameworld2.model.skill.EnemySkillDefine;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EnemySkill {
    private List<EnemySkillDefine>enemySkillDefineList=new ArrayList<>();

    public void register(EnemySkillDefine def) {
        enemySkillDefineList.add(def);
    }

    public EnemySkillDefine getEnemySkillDefine(Integer index){
        return enemySkillDefineList.get(index);
    }



}
