package Model.factory.proxy.dynamic;

/**
 * 动态代理代理的是一类接口
 */
public class Test {

    public static void main(String[] args) {
        proxyInvoke proxyInvoke = new proxyInvoke();
        proxyInvoke.setProxyInterface(new NormalHome());
        ProxyInterface proxy = (ProxyInterface) proxyInvoke.getProxy();
        proxy.marry();

    }
}
