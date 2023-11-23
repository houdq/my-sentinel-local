package cn.ddx.mysentinel.service;

import org.springframework.stereotype.Service;

/**
 * @author daniel.hou
 * @date 2023/11/23 18:53
 * @Desc
 */
@Service
public class SentinelServiceImpl implements SentinelService {
    @Override
    public String sentinel() {
        return "hell sentinel";
    }
}
