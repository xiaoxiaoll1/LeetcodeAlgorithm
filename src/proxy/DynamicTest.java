package proxy;

import proxy.handler.MySellHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicTest {

    public static void main(String[] args) {
        KingsFactory kingsFactory = new KingsFactory();
        InvocationHandler handler = new MySellHandler(kingsFactory);
        Usb o = (Usb) Proxy.newProxyInstance(kingsFactory.getClass().getClassLoader(), kingsFactory.getClass().getInterfaces(), handler);
        o.sell(23);
        //o.ifSell();
        o.print("dfsjoi");

    }
}
