package com.example.gameworld2.controller.req;

import lombok.Data;

@Data
public class FightReq {
    private Integer playerId;
    private String enemyId;

}