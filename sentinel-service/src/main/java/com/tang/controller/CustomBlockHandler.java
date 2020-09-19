package com.tang.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tang.domain.CommonResult;

/**
 * @author: TangLiang
 * @date: 2020/9/19 20:32
 * @since: 1.0
 */
public class CustomBlockHandler {

    public CommonResult handleException(BlockException exception){
        return new CommonResult("自定义限流信息",200);
    }
}
