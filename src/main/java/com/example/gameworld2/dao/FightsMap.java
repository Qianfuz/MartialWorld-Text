package com.example.gameworld2.dao;

import com.example.gameworld2.model.Fight;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class FightsMap {
    private final HashMap<Integer, Fight>fightHashMap=new HashMap<>();

    public Fight createFight(Integer id){
        if(!fightHashMap.containsKey(id)){
            fightHashMap.put(id,new Fight());
        }
        return fightHashMap.get(id);
    }


}