package manning.bigdata.ch3;

public class Login {
	public String userName;
	public long loginUnixTime;
	 
	public Login(String _user, long _login) {
		userName = _user;
		loginUnixTime = _login;
	}
}