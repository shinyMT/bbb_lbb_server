package com.thy.bbb_lbb.config;

import com.baomidou.mybatisplus.autoconfigure.DdlApplicationRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: thy
 * Date: 2024-10-17 16:26
 */
@Component
public class GlobalConfig {
    @Bean
    public DdlApplicationRunner ddlApplicationRunner(@Autowired(required = false) List ddlLrist){
        return new DdlApplicationRunner(ddlLrist);
    }
}
