package com.example.gameworld2.dao;

import com.example.gameworld2.model.skill.PlayerSkillDefine;
import com.example.gameworld2.model.skill.SkillType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class PlayerSkillShop {
    private final HashMap<String, PlayerSkillDefine> map=new HashMap<>();

    public void register(PlayerSkillDefine def) {
        map.put(def.getId(), def);
    }

    public PlayerSkillDefine getSkillDefine(String id) {
        return map.get(id);
    }
    public Collection<PlayerSkillDefine> listAll() {
        return map.values();
    }

    @PostConstruct
    public void init() {

        // nianlifeishan 念力飞扇 26 15 general "" 5 0
        register(new PlayerSkillDefine(
                "nianlifeishan",
                "念力飞扇",
                25,
                15,
                SkillType.GENERAL,
                "",
                5,
                0
        ));

        // baibuliehuo 百步烈火 100 20 special "" 5 200
        register(new PlayerSkillDefine(
                "baibuliehuo",
                "百步烈火",
                100,
                20,
                SkillType.SPECIAL,
                "",
                5,
                200
        ));

        // jingtianhunyuanzhang 惊天浑元掌 80 limited "" 0 0
        register(new PlayerSkillDefine(
                "jingtianhunyuanzhang",
                "惊天浑元掌",
                80,
                15,
                SkillType.LIMITED,
                "",
                0,
                0
        ));

        // jinzhongzhao 金钟罩 0 passive "" 0 100
        register(new PlayerSkillDefine(
                "jinzhongzhao",
                "金钟罩",
                0,
                0,
                SkillType.PASSIVE,
                "",
                0,
                100
        ));

        System.out.println("✅ SkillShop 初始化完成，技能数量：" + map.size());
    }



}
