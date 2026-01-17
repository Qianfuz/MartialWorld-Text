package com.example.gameworld2.model.skill;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnemySkillDefine {
    private String name;
    private Integer hp;
    private String extraEffect;
}
