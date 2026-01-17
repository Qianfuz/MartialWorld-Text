package com.example.gameworld2.model.bag;

import lombok.Data;

import java.util.HashMap;

@Data
public class Bag {
    private HashMap<BagType,HashMap<String,Integer>>data=new HashMap<>();
    public Bag(){
        data.put(BagType.ITEM,new HashMap<>());
        data.put(BagType.DRUG,new HashMap<>());
        data.put(BagType.EQUIP,new HashMap<>());
    }
    public HashMap<String,Integer>getBag(BagType type){
        return data.get(type);
    }
}
