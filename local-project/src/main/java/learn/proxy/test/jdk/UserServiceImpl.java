package learn.proxy.test.jdk;

public class UserServiceImpl implements UserService,Person {

	public void addUser() {
		System.out.println("user add");
		
	}
	public void removeUser() {
		System.out.println("user remove");
		
	}
	public void speak(String words) {
		System.out.println("speaking" + words);
	}
}
