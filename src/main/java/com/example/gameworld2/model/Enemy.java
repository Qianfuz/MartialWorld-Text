package com.example.gameworld2.model;

import com.example.gameworld2.dao.EnemySkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enemy {
    private String id;
    private String name;
    private Integer lv=5;
    private Integer hp=50;
    private EnemySkill enemySkill = new EnemySkill();

}
