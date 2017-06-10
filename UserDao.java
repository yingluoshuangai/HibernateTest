package dao;

import common.HibernateSessionFactory;

import po.User;

public class UserDao {

	//=============增============================
	/*
	 * 增加user*/
	public void save(User user){
		HibernateSessionFactory.getSession().save(user);
	}
	
	
	//==============删==============================
	//==============改==============================
	
	/*
	 * 修改user*/
	public void update(User user){
		HibernateSessionFactory.getSession().update(user);
	}
	public void test(User user){
		User u = (User)HibernateSessionFactory.getSession().get(User.class, user.getId());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setTelephone(user.getTelephone());
		u.setUsername(user.getUsername());
		u.setIsAdmin(user.getIsAdmin());
	}
	
	
	//==============查==============================
	
	/*
	 * 根据id查user*/
	public User findById(java.io.Serializable id){
		return (User)HibernateSessionFactory.getSession().get(User.class, id);
	}
	
	
	
}
