package com.example.gameworld2.model.skill;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Data
@NoArgsConstructor
public class PlayerSkill {
    private HashSet<String>owned=new HashSet<>();
    private Integer LENGTH=5;
    private List<String>slots=new ArrayList<>();

    {
        // 实例初始化块：所有构造器都会执行
        for (int i = 0; i < LENGTH; i++) {
            slots.add(null);
        }
    }


    public void learnSkill1(String id){
        owned.add(id);
    }
    public void equipSkill(String id,Integer index) {
        slots.set(index-1,id);
    }
}
