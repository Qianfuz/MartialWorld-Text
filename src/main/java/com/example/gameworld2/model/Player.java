package com.example.gameworld2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.gameworld2.model.bag.Bag;
import com.example.gameworld2.model.skill.PlayerSkill;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private Integer id;
    private String name;
    private Integer lv=5;
    private Integer hp=50;
    private Integer mp=100;
    private Integer exp=1;
    private Integer money=500;
    private Bag bag = new Bag();
    private PlayerSkill playerSkill = new PlayerSkill();

}
