package DynamicProxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/3/10.
 */
public class testProxy {
    @Test
    public void testForProxy(){
        RealSubject realSub = new RealSubject();
        InvocationHandler handler = new DynamicSubject(realSub);
        Class<?> classType = handler.getClass();
        Subject sub = (Subject) Proxy.newProxyInstance(classType.getClassLoader(),
                realSub.getClass().getInterfaces(), handler);
        System.out.println(sub.getClass());

        sub.Request();
    }
}
