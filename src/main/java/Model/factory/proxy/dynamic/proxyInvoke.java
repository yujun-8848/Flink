package Model.factory.proxy.dynamic;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyInvoke implements InvocationHandler {

    private ProxyInterface proxyInterface;

    public void setProxyInterface(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), proxyInterface.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(proxyInterface, args);
        return invoke;
    }
}
