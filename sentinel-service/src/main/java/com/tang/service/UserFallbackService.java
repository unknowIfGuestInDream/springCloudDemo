package com.tang.service;

import com.tang.domain.CommonResult;
import com.tang.domain.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: TangLiang
 * @date: 2020/9/19 20:45
 * @since: 1.0
 */
@Component
public class UserFallbackService implements FallbackFactory<UserService> {
    private static final Logger log = LoggerFactory.getLogger(UserFallbackService.class);

    @Override
    public UserService create(Throwable throwable) {
        log.error("服务调用失败:{}", throwable.getMessage());
        return new UserService() {
            @Override
            public CommonResult create(User user) {
                User defaultUser = new User(-1L, "defaultUser", "123456");
                return new CommonResult<>(defaultUser, "服务降级返回", 200);
            }

            @Override
            public CommonResult<User> getUser(Long id) {
                User defaultUser = new User(-1L, "defaultUser", "123456");
                return new CommonResult<>(defaultUser, "服务降级返回", 200);
            }

            @Override
            public CommonResult<User> getByUsername(String username) {
                User defaultUser = new User(-1L, "defaultUser", "123456");
                return new CommonResult<>(defaultUser, "服务降级返回", 200);
            }

            @Override
            public CommonResult update(User user) {
                return new CommonResult("调用失败，服务被降级", 500);
            }

            @Override
            public CommonResult delete(Long id) {
                return new CommonResult("调用失败，服务被降级", 500);
            }
        };
    }
}
