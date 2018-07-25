package com.iotimc.controller;

import com.iotimc.elsi.bean.PageRequestBean;
import com.iotimc.elsi.bean.SortRequestBean;
import com.iotimc.domain.DemoEntity;
import com.iotimc.elsi.msg.common.HandleEntitySuccessMsg;
import com.iotimc.util.MQBody;
import com.iotimc.util.MQUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * DemoController
 *
 * @author lieber
 * @create 2018/2/10
 **/
@RestController
@RequestMapping("/testClient/demo")
@Api(value = "DemoController RESTful", description = "demo REST api")
public class DemoController {

    @Autowired
    private MQUtil mqUtil;

    @ApiOperation(value = "通过name字段查询Demo数据", notes="通过name查询Demo数据2", response = DemoEntity.class, responseContainer="List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "ELSIID", value = "与Token绑定的请求标识", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name="name",value="name字段值",required = true, paramType = "path", dataType = "String")
    })
    @RequestMapping(value="/listByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<DemoEntity>> list(@PathVariable("name") String name) {
        //执行Service的方法
        List<DemoEntity> list = new ArrayList<>();
        return ResponseEntity.ok(list);
    }


    @ApiOperation(value = "通过name字段分页查询Demo数据", notes="通过name分页查询Demo数据2", response = Page.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "ELSIID", value = "与Token绑定的请求标识", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name="name",value="name字段值",required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name="page",value="分页信息",required = true, paramType = "query", dataType = "String", example = "{\"pageSize\":20,\"pageNum\":0}"),
            @ApiImplicitParam(name="sorts",value="排序信息",required = true, paramType = "query", dataType = "String", example = "[{\"column\":\"id\",\"sortType\":\"DESC\"}]")
    })
    @RequestMapping(value="/listByPage", method = RequestMethod.GET)
    public ResponseEntity<Page<DemoEntity>> listByPage(@RequestParam("name")String name, @RequestParam("page")PageRequestBean pageRequestBean,
        @RequestParam("sorts")SortRequestBean[] sortRequestBeans) {
        //执行Service的方法
        List<DemoEntity> list = new ArrayList<>();
        Page<DemoEntity> page = new PageImpl<DemoEntity>(list);
        return ResponseEntity.ok(page);
    }


    @ApiOperation(value = "保存Demo数据", notes="保存Demo数据", response = HandleEntitySuccessMsg.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "ELSIID", value = "与Token绑定的请求标识", required = true, paramType = "header", dataType = "String")
    })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<HandleEntitySuccessMsg> insertDemo(@RequestBody DemoEntity entity) {
        //执行Service的方法
        int id = 0;
        HandleEntitySuccessMsg msg = new HandleEntitySuccessMsg("插入成功", String.valueOf(id));
        return ResponseEntity.ok(msg);
    }

    @ApiOperation(value = "修改Demo数据", notes="修改Demo数据", response = HandleEntitySuccessMsg.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "ELSIID", value = "与Token绑定的请求标识", required = true, paramType = "header", dataType = "String")
    })
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<HandleEntitySuccessMsg> updateDemo(@RequestBody DemoEntity entity) {
        //执行Service的方法
        int id = 0;
        HandleEntitySuccessMsg msg = new HandleEntitySuccessMsg("修改成功", String.valueOf(id));
        return ResponseEntity.ok(msg);
    }

    @ApiOperation(value = "通过ID删除Demo数据", response = HandleEntitySuccessMsg.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "ELSIID", value = "与Token绑定的请求标识", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name="id",value="id字段值",required = true, paramType = "path", dataType = "int")
    })
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HandleEntitySuccessMsg> deleteDemo(@PathVariable("id")int id) {
        //执行Service的方法
        HandleEntitySuccessMsg msg = new HandleEntitySuccessMsg("修改成功", String.valueOf(id));
        return ResponseEntity.ok(msg);
    }

    @RequestMapping(value = "/mq", method = RequestMethod.GET)
    public ResponseEntity<HandleEntitySuccessMsg> testMq() throws Exception {
        MQBody body = new MQBody("123", "Attr", "value", "send");
        mqUtil.send(body);
        return ResponseEntity.ok(new HandleEntitySuccessMsg("请求成功", "1"));
    }
}
