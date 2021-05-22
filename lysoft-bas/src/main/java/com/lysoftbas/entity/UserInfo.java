package com.lysoftbas.entity;


import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

public class UserInfo implements Serializable {
	
	@NotNull(message="id不能为空",groups= {InsertGroup.class})
	private Integer id;
	
	@NotEmpty(message="用户名不能为空",groups= {InsertGroup.class})
	private String userName;
	
	@NotEmpty(message="密码不能为空")
	@Size(min=6,max=8,message="密码长度必须在6~8位")
	private String password;
	
	@NotEmpty(message="邮箱不能为空")
	@Email
	private String email;
	
	private Integer age;
	
	public interface InsertGroup extends Default{};
	public interface UpdateGroup extends Default{};
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", age=" + age + "]";
	}
	public UserInfo(Integer id, String userName, String password, String email, Integer age) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.age = age;
	}
	public UserInfo() {
		super();
	}
	
	
	
	
	
}
