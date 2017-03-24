package com.dcs.service;

import com.dcs.pojo.User;

public interface UserService extends BaseService<User> {
	
	int deleteById(Object id, Object reviser) throws Exception;

	Integer confirm(User user, Object dataStatus) throws Exception;
}
