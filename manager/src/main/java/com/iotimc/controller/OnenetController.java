package com.iotimc.controller;

import com.alibaba.fastjson.JSONObject;
import com.iotimc.elsi.auth.annotation.NoneAuthorize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testClient/onenet")
@Slf4j
@NoneAuthorize
public class OnenetController {
    @RequestMapping(value="/listen", method = RequestMethod.GET)
    public ResponseEntity<String> listen(@RequestParam("nonce") String nonce,
                                         @RequestParam("msg") String msg,
                                         @RequestParam("signature")String signature ,
                                         @RequestParam(value = "token", required = false)String token) {
        log.debug("收到来自Onenet平台请求验证：msg: {}, nonce: {}, signature: {}, token: {}", msg, nonce, signature, token);
        log.info("Onenet平台验证成功");
        return ResponseEntity.ok(msg);
    }

    @RequestMapping(value="/listen", method = RequestMethod.POST)
    public ResponseEntity<String> listen(@RequestBody JSONObject entity) throws Exception {
        log.info("收到来自Onenet平台数据：{}", entity.toJSONString());
        return ResponseEntity.ok("");
    }
}
