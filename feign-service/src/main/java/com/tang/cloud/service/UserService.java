package com.tang.cloud.service;

import com.tang.cloud.domain.CommonResult;
import com.tang.cloud.domain.User;
import com.tang.cloud.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: TangLiang
 * @date: 2020/9/9 14:21
 * @since: 1.0
 */
//@FeignClient(value = "user-service", fallback = UserFallbackService.class)  实现UserService 接口
@FeignClient(value = "user-service", fallbackFactory = UserFallbackService.class) //实现FallbackFactory 接口
public interface UserService {
    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    @GetMapping("/user/{id}")
    CommonResult<User> getUser(@PathVariable Long id);

    @GetMapping("/user/getByUsername")
    CommonResult<User> getByUsername(@RequestParam String username);

    @PostMapping("/user/update")
    CommonResult update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    CommonResult delete(@PathVariable Long id);
}
