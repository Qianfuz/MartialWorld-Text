package com.example.gameworld2.controller.req;

import lombok.Data;

@Data
public class UpgradeSkillReq {
    private Integer playerId;
    private String skillId;
}
