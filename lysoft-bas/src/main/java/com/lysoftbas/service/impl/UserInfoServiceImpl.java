package com.lysoftbas.service.impl;


import com.lysoftbas.entity.UserInfo;
import com.lysoftbas.service.UserInfoService;
import com.lysoftbas.util.DomainValidator;

import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {


	@Override
	public int insertUserInfo(UserInfo userInfo) {
		boolean isValidate = DomainValidator.validate2(userInfo,UserInfo.InsertGroup.class);
		if(isValidate) {
			System.out.println("userInfo:"+userInfo);
		}else {
			System.out.println("参数错误！");
		}

		return 0;
	}
}
