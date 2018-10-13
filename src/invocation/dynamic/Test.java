package invocation.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author JaneMin
 * @create 2018/10/13
 */
interface ITarget{
    void doSomething();
}

class Target implements ITarget{
    @Override
    public void doSomething() {
        System.out.println("Target.doSomething");
    }
}

class MyInvocationHandler implements InvocationHandler{

    Object obj;

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(this.obj.getClass().getClassLoader(), this.obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(obj, args);
        return result;
    }
}

public class Test {
    public static void main(String[] args) {
      Target target = new Target();
      MyInvocationHandler handler = new MyInvocationHandler();
      ITarget iTarget = (ITarget)handler.bind(target);
      iTarget.doSomething();
    }
}


