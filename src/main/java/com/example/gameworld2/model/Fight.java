package com.example.gameworld2.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Fight {
    private Integer curPlayerHp;
    private Integer curPlayerMp;
    private Integer curEnemyHp;
    private List<String> log=new ArrayList<>();
}