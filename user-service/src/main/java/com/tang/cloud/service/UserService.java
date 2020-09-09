package com.tang.cloud.service;

import com.tang.cloud.domain.User;

import java.util.List;

/**
 * @author: TangLiang
 * @date: 2020/9/9 9:57
 * @since: 1.0
 */
public interface UserService {
    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
