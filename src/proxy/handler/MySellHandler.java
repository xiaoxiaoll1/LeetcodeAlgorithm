package proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MySellHandler implements InvocationHandler {
    private Object target;

    public MySellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object sell = method.invoke(target, args);
        if(sell!=null){
            Float sellF = (Float)sell;
            float price = sellF+25f;
            sell=price;
            System.out.println(price+"元");
        }
        System.out.println("代理");
        return sell;
    }
}
