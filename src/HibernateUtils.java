
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * 创建hibernate工具，获取Session
 * 
 * @author 伍豪
 *
 */
public class HibernateUtils {

	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		// 当虚拟机关闭时自动进行释放资源
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				sessionFactory.close();
			}
		}));
	}

	/**
	 * 获取一个新的Session
	 * 
	 * @return
	 */
	public static Session openSession() {
		return sessionFactory.openSession();
	}

	/**
	 * 获取与当前线程绑定的Session
	 * 
	 * @return
	 */
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		System.out.println(openSession());
	}
}
