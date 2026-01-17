package com.example.gameworld2.controller.req;

import lombok.Data;

@Data
public class LearnSkillReq {
    private Integer playerId;
    private String skillId;
}
