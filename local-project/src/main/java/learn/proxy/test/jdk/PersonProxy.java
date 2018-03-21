package learn.proxy.test.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import learn.proxy.test.jdk.Person;

public final class PersonProxy extends Proxy implements Person {

	private static final long serialVersionUID = 1L;
	private static Method m1;
	private static Method m2;
	private static Method m3;
	private static Method m0;

	static {
		try {
			m1 = Class.forName("java.lang.Object").getMethod("equals",new Class[] { Class.forName("java.lang.Object") });
			m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
			m3 = Class.forName("learn.proxy.test.jdk.Person").getMethod("speak",new Class[] { Class.forName("java.lang.String") });
			m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public PersonProxy(InvocationHandler paramInvocationHandler) {
		super(paramInvocationHandler);
	}

	public final boolean equals(Object paramObject) {
		try {
			return ((Boolean) this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
		} catch (RuntimeException localRuntimeException) {
			throw localRuntimeException;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final String toString() {
		try {
			return ((String) this.h.invoke(this, m2, null));
		} catch (RuntimeException localRuntimeException) {
			throw localRuntimeException;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final void speak(String paramString) {
		try {
			this.h.invoke(this, m3, new Object[] { paramString });
			return;
		} catch (RuntimeException localRuntimeException) {
			throw localRuntimeException;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final int hashCode() {
		try {
			return ((Integer) this.h.invoke(this, m0, null)).intValue();
		} catch (RuntimeException localRuntimeException) {
			throw localRuntimeException;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

}