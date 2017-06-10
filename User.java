package po;

/*实体类继承Serializable类，是为了方便实现序列化*/
public class User implements java.io.Serializable {

	/**
	 * 生成该实体类唯一的编号，用于与其他实体类区分。
	 * 由Serializable类负责生成。
	 */
	private static final long serialVersionUID = -2998707288951184222L;
	
	private Integer id;//使用包装类，是因为包装类与数据库的对应关系更好。
	private String name;
	private String password;
	private String telephone;
	private String username;
	private String isAdmin;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
