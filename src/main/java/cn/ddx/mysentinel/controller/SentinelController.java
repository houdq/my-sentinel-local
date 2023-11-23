package cn.ddx.mysentinel.controller;

import cn.ddx.mysentinel.service.SentinelService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daniel.hou
 * @date 2023/11/23 18:50
 * @Desc
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @Autowired
    SentinelService sentinelService;

    @GetMapping("/hello")
    @SentinelResource(value = "sentinel", blockHandler = "blockHandler")
    public String sentinel() {
        return sentinelService.sentinel();
    }

}
