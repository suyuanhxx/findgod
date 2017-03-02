package com.findgods.fly.entity;

import org.springframework.data.annotation.Id;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang@baidao.com xiaoxu.huang
 * @date 2017/2/24  17:48
 *
 */
public class User {

	@Id
	private Long id;

	private String username;

	/**
	 * return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	public User(){

	}

	public User(Long id ,String username){
		this.id=id;
		this.username = username;
	}
}
