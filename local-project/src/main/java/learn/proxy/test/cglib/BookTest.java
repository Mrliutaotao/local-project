package learn.proxy.test.cglib;

public class BookTest {
	public static void main(String[] args) {
		BookServiceBean bookService = BookServiceFactory.getInstance();
		doMethod(bookService);
		
		BookServiceBean service = BookServiceFactory.getProxyInstance(new MyCglibProxy("boss"));  
		service.create();  
 		BookServiceBean service2 = BookServiceFactory.getProxyInstance(new MyCglibProxy("john"));  
		service2.create(); 
		
		BookServiceBean serviceFilter = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("jhon"));
		serviceFilter.create();
		BookServiceBean serviceFilter2 = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("jhon"));
		serviceFilter2.query();  
		BookServiceBean serviceFilter3 = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("boss"));
		serviceFilter3.create();
 	}

	public static void doMethod(BookServiceBean service) {
		service.create();
		service.update();
		service.query();
		service.delete();
	}
}
