package dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

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
	
	/*
	 * 动态查询User表*/
	public List<User> findUsers(String hql,Map<String,Object> user){
		//Query对象可以使用方法链，因为Query对象的方法返回的都是一个Query对象
		/*Query q = HibernateSessionFactory.getSession().createQuery("from User");
		return q.list();*/
		return HibernateSessionFactory.getSession()
				.createQuery(hql)
				.setProperties(user)
				.list();
	}
	
	/*
	 * 分页查询User表*/
	public List<User> findUsers(int page,int size){
		return HibernateSessionFactory.getSession()
				.createQuery("from User")
				.setFirstResult((page -1)*size)
				.setMaxResults(size)
				.list();
	}
	
	
}

