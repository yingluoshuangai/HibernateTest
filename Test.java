package test;

import biz.UserBiz;
import po.User;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *测试添加 
		User user = new User();
		user.setName("张三");
		UserBiz ub = new UserBiz();
		ub.addNewUser(user);*/
		
		/*增加
		 * UserBiz ub = new UserBiz();
		User user = ub.getUser(1000);
		System.out.println(user.getUsername());
		 * */
		
		UserBiz ub = new UserBiz();
		User user = new User();
		user.setId(1004);
		user.setPassword("666");
		ub.modifyUser(user);
		
	}

}
