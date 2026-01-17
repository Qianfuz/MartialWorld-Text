package com.example.gameworld2.dao;

import com.example.gameworld2.model.Player;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class PlayersMap {
    HashMap<Integer, Player>playersMap=new HashMap<>();

    public Player getPlayer(Integer id){
        if(playersMap.containsKey(id)){
         return playersMap.get(id);
        }
        return null;
    }
    public void register(Integer id,String name){
        if(!playersMap.containsKey(id)){
            playersMap.put(id,new Player());
            playersMap.get(id).setName(name);
            playersMap.get(id).setId(id);

        }
    }
}
