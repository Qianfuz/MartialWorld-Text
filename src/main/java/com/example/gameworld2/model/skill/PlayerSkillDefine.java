package com.example.gameworld2.model.skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSkillDefine {
    private String id;
    private String name;
    private Integer lv;
    private Integer upgradeCost;
    private Integer hp;
    private Integer mpCost;
    private SkillType type;
    private String extraEffect;
    private Integer lvLimited;
    private Integer moneyCost;

}
