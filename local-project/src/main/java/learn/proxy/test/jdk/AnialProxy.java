package learn.proxy.test.jdk;
/*
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class AnimalProxy extends Proxy
  implements learn.proxy.test.jdk.Animal
{
  private static Method m1;
  private static Method m8;
  private static Method m2;
  private static Method m3;
  private static Method m6;
  private static Method m5;
  private static Method m7;
  private static Method m9;
  private static Method m0;
  private static Method m4;

  public Animal(InvocationHandler paramInvocationHandler)
    throws 
  {
    super(paramInvocationHandler);
  }

  public final boolean equals(Object paramObject)
    throws 
  {
    try
    {
      return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final void notify()
    throws 
  {
    try
    {
      this.h.invoke(this, m8, null);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final String toString()
    throws 
  {
    try
    {
      return ((String)this.h.invoke(this, m2, null));
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final void saySomething(String paramString)
    throws 
  {
    try
    {
      this.h.invoke(this, m3, new Object[] { paramString });
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final void wait(long paramLong)
    throws InterruptedException
  {
    try
    {
      this.h.invoke(this, m6, new Object[] { Long.valueOf(paramLong) });
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final void wait(long paramLong, int paramInt)
    throws InterruptedException
  {
    try
    {
      this.h.invoke(this, m5, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final Class getClass()
    throws 
  {
    try
    {
      return ((Class)this.h.invoke(this, m7, null));
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final void notifyAll()
    throws 
  {
    try
    {
      this.h.invoke(this, m9, null);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final int hashCode()
    throws 
  {
    try
    {
      return ((Integer)this.h.invoke(this, m0, null)).intValue();
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  public final void wait()
    throws InterruptedException
  {
    try
    {
      this.h.invoke(this, m4, null);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Throwable localThrowable)
    {
      throw new UndeclaredThrowableException(localThrowable);
    }
  }

  static
  {
    try
    {
      m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
      m8 = Class.forName("learn.proxy.test.jdk.Animal").getMethod("notify", new Class[0]);
      m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
      m3 = Class.forName("learn.proxy.test.jdk.Animal").getMethod("saySomething", new Class[] { Class.forName("java.lang.String") });
      m6 = Class.forName("learn.proxy.test.jdk.Animal").getMethod("wait", new Class[] { Long.TYPE });
      m5 = Class.forName("learn.proxy.test.jdk.Animal").getMethod("wait", new Class[] { Long.TYPE, Integer.TYPE });
      m7 = Class.forName("learn.proxy.test.jdk.Animal").getMethod("getClass", new Class[0]);
      m9 = Class.forName("learn.proxy.test.jdk.Animal").getMethod("notifyAll", new Class[0]);
      m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
      m4 = Class.forName("learn.proxy.test.jdk.Animal").getMethod("wait", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }
}
*/