package com.example.gameworld2.dao;

import com.example.gameworld2.model.Enemy;
import com.example.gameworld2.model.Player;
import com.example.gameworld2.model.skill.EnemySkillDefine;
import com.example.gameworld2.model.skill.PlayerSkillDefine;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
@Repository
public class EnemysMap {

    HashMap<String, Enemy>enemyHashMap=new HashMap<>();

    public Enemy getEnemy(String id){
        if(enemyHashMap.containsKey(id)){
            return enemyHashMap.get(id);
        }
        return null;
    }
    public void register(String id,String name){
        if(!enemyHashMap.containsKey(id)){
            enemyHashMap.put(id,new Enemy());
            enemyHashMap.get(id).setName(name);
            enemyHashMap.get(id).setId(id);
        }
    }
    public Collection<Enemy> listAll() {
        return enemyHashMap.values();
    }

    @PostConstruct
    public void init() {

        // ===== 山贼 =====
        Enemy shanzei = new Enemy();
        shanzei.setId("shanzei");
        shanzei.setName("山贼");
        shanzei.setLv(5);
        shanzei.setHp(50);

        EnemySkill shanzeiSkill = new EnemySkill();
        shanzeiSkill.register(new EnemySkillDefine("斩击", 5, ""));
        shanzeiSkill.register(new EnemySkillDefine("连续斩击", 8, ""));
        shanzeiSkill.register(new EnemySkillDefine("冲撞", 10, ""));

        shanzei.setEnemySkill(shanzeiSkill);
        enemyHashMap.put(shanzei.getId(), shanzei);

        // ===== 野兽 =====
        Enemy yeshou = new Enemy();
        yeshou.setId("yeshou");
        yeshou.setName("野兽");
        yeshou.setLv(8);
        yeshou.setHp(100);

        EnemySkill yeshouSkill = new EnemySkill();
        yeshouSkill.register(new EnemySkillDefine("冲撞", 15, ""));
        yeshouSkill.register(new EnemySkillDefine("投石", 20, ""));
        yeshouSkill.register(new EnemySkillDefine("群攻", 30, ""));

        yeshou.setEnemySkill(yeshouSkill);
        enemyHashMap.put(yeshou.getId(), yeshou);

        System.out.println("✅ Enemy 初始化完成，数量：" + enemyHashMap.size());
    }
}


