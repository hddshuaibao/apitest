package com.weixt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@Api(value = "zhongzhao",description = "中招")
@RequestMapping("zhongzhao")
public class zhongzhao {


    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/recruitmentVersionSave",method = RequestMethod.GET)
    @ApiOperation(value = "新增学年版本",httpMethod = "GET")
    public int recruitmentVersionSave(){
       return template.selectOne("recruitmentVersionSave");

    }
}
