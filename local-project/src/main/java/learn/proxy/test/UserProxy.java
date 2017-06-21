package learn.proxy.test;


public class UserProxy {
	
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		UserServiceHandler handler = new UserServiceHandler(userService);
		UserService userServiceProxy  = (UserService)handler.getProxy();
		
		//UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);
		userServiceProxy.removeUser();
	}
}
