package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestProxy {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TaoBao taoBao = new TaoBao();
        System.out.println(taoBao.sell(32f)+"元");
        Class<? extends TaoBao> aClass = taoBao.getClass();
        Method sell = aClass.getMethod("sell", float.class);
        System.out.println(sell.invoke(taoBao, 322f));

    }
}
