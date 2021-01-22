package model.Rogin;

public class RoginCheck {

	public boolean check(User user) {

		if(user.getPass().equals("1234")) {
			return true;
		}

		return false;
	}

}
