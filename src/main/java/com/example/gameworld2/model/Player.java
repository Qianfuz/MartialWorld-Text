package com.example.gameworld2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.gameworld2.model.bag.Bag;
import com.example.gameworld2.model.skill.PlayerSkill;

import java.util.ArrayList;
import java.util.List;


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
    private Integer expMax=300;
    private Integer money=50000;
    private List<String>log=new ArrayList<>();
    private Bag bag = new Bag();
    private PlayerSkill playerSkill = new PlayerSkill();

}
