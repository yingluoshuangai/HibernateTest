package common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//读取hibernate配置文件(hibernate.cfg.xml),获得session
public class HibernateSessionFactory {
	private static Configuration cfg;
	private static SessionFactory sessionFactory;
	
	static{
		try{
			/*使用configure()读取配置文件
			 *如果位置在src下，且文件名是：hibernate.cfg.xml，用configure()即可
			 *如果位置或者文件名变更，用configure("myhibernate.cfg.xml");*/
			cfg = new Configuration().configure();
			sessionFactory = cfg.buildSessionFactory();//创建session工厂
		}catch(HibernateException e){
			throw new RuntimeException("hibernate初始化失败",e);
		}
	}
	
	public static Session getSession(){
		/*sessionFactory.getCurrentSession()
		 * 该方法获得的session与线程绑定，保证不同的用户获得的session不同。
		 * 但需要在配置文件声明“current_session_context_class”属性.
		 * 必须在事务的环境下，才能运行。
		 * 在进行事务提交或回滚后，会自动关闭。
		*/
		return sessionFactory.getCurrentSession();//获得session
		//sessionFactory.openSession()获得的session不与线程绑定
	}
}
