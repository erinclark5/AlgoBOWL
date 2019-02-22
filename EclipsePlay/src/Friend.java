/**
 * @author Erin Clark
 *
 */
public class Friend {

	private String name;
	private String email;
	
	public Friend(String string, String string2) {
		// TODO Auto-generated constructor stub
		name = string;
		email = string2;
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", email=" + email + "]";
	}

}
