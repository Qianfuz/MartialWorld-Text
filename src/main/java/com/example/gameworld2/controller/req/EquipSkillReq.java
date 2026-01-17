package com.example.gameworld2.controller.req;

import lombok.Data;

@Data
public class EquipSkillReq {
    private Integer playerId;
    private String skillId;
    private Integer index;
}
