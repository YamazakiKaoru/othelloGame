package model.Rogin;

public class User {
	/**  ユーザー名　*/
	private String name;
	/**  パスワード */
	private String pass;

	/** 白か黒かの情報 */
	private String state;

	//以下getter,setter
	public User(String name,String pass){
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}



}
