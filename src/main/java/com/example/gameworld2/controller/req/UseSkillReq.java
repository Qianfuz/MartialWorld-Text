package com.example.gameworld2.controller.req;

import lombok.Data;

@Data
public class UseSkillReq {
    Integer playerId;
    String skillId;
    String enemyId;
}
