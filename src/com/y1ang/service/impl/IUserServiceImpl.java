package com.y1ang.service.impl;

import com.y1ang.dao.UserMapper;
import com.y1ang.entity.User;
import com.y1ang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author y1ang
 * @Data 2018年10月13日-上午10:27:39
 * @Description 用户操作服务层实现类
 */
@Service
public class IUserServiceImpl implements IUserService{

	@Autowired
	private UserMapper dao;
	
	@Override
	public User login(User user) {
		return dao.login(user);
	}

	/**
	 * 查询用户
	 *
	 * @return
	 */
	@Override
	public User findUser(int useID) {
		return dao.findUser(useID);
	}

	/**
	 * 检查原密码是否正确
	 *
	 * @param user
	 * @return
	 */
	@Override
	public User checkOldPwd(User user) {
		return dao.checkOldPwd(user);
	}

	/**
	 * 更新密码
	 *
	 * @param user
	 * @return
	 */
	@Override
	public int updatePwd(User user) {
		return dao.updatePwd(user);
	}
}
