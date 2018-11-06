package com.y1ang.service;

import com.y1ang.entity.User;

/**
 * @author y1ang
 * @Data 2018年10月13日-上午10:49:49
 * @Description 用户服务层接口类
 */
public interface IUserService {
    /**
     * 登录
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 查询用户
     *
     * @param userID
     * @return
     */
    public User findUser(int userID);

    /**
     * 检查原密码是否正确
     *
     * @param user
     * @return
     */
    public User checkOldPwd(User user);

    /**
     * 更新密码
     *
     * @param user
     * @return
     */
    public int updatePwd(User user);
}
