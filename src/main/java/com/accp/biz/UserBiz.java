package com.accp.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.accp.dao.UserMapper;
import com.accp.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class UserBiz {
	@Autowired
	private UserMapper userdao;
	public User denglu(String username,String usermm) {
		QueryWrapper<User> qw=Wrappers.query();
		qw.eq("username", username).eq("usermm", usermm);
		User user=userdao.selectOne(qw);
		return user;
	}
	public int zhuce(User u) {
		return userdao.insert(u);
	}
}
