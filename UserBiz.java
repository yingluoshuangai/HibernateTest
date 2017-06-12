package biz;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import common.HibernateSessionFactory;

import po.User;
import dao.UserDao;

public class UserBiz {
	
	private UserDao dao = new UserDao();
	
	//===================增===============================
	
	/*增加user*/
	public void addNewUser(User user){
		Transaction tx = null;//声明事务
		try{
			tx = HibernateSessionFactory.getSession().beginTransaction();//开启事务
			dao.save(user);//执行
			tx.commit();//事务提交
		}catch(HibernateException e){
			e.printStackTrace();
			if(tx != null){//事务开启成功的话，进行事务回滚
				tx.rollback();//事务回滚
			}
		}
	}
	
	
	
	//===================删===============================
	//===================改===============================
	
	/**/
	public void modifyUser(User user){
		Transaction tx = null;//声明事务
		try{
			tx = HibernateSessionFactory.getSession().beginTransaction();//开启事务
			dao.update(user);//执行
			tx.commit();//事务提交
		}catch(HibernateException e){
			e.printStackTrace();
			if(tx != null){//事务开启成功的话，进行事务回滚
				tx.rollback();//事务回滚
			}
		}
	}
	
	//===================查===============================
	
	/*
	 * 通过id获得user*/
	public User getUser(java.io.Serializable id){
		Transaction tx = null;
		User user = null;
		try{
			tx = HibernateSessionFactory.getSession().beginTransaction();
			user = dao.findById(id);
			
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
		return user;
	}
	
	/*
	 * 动态查询User表
	 * 条件1：username列为admin
	 * 条件2：telephone在15000000000和1800000000之间*/
	public List<User> findUsers(Map<String,Object> user){
		Transaction tx = null;
		List<User> users = null;
		
		StringBuilder hql = new StringBuilder("from User u where 1=1");
		if(user != null){
			if(user.get("username") != null){
				hql.append(" and u.username = :username ");
			}
			if(user.get("begin") != null){
				hql.append(" and u.telephone > :begin ");
			}
			if(user.get("end") != null){
				hql.append(" and u.telephone < :end ");
			}
		}
		try{
			tx = HibernateSessionFactory.getSession().beginTransaction();
			users = dao.findUsers(hql.toString(), user);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
		return users;
				
	}
	
	/*分页查询User表*/
	public List<User> findUsers(int page,int size){
		Transaction tx = null;
		List<User> users = null;
		try{
			tx = HibernateSessionFactory.getSession().beginTransaction();
			users = dao.findUsers(page,size);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
		return users;
	}
	
	
	
	
	
	
	
}

