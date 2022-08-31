package com.proxy.factory;

import java.lang.reflect.Constructor;  
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.proxy.impl.OperacionesProductosCrudimpl;
import com.proxy.interfaz.OperacionesPoductosCrud;

import java.lang.reflect.InvocationHandler;

class ImpresionInvocationHandler implements InvocationHandler{
	Object target;
	
	public ImpresionInvocationHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("..... Invocando: " +
				method.getName()+ " " +
				Arrays.toString(args));
		
		long inicio = System.nanoTime();
		
		Object ret = method.invoke(target, args);
		long tiempo = System.nanoTime() - inicio;
		
		System.out.println("Tiempo " + tiempo/1000.0f);
		return ret;
	}
	
}

public final class OperacionesFactory {
	
	private static Map<Class<?>, Class<?>> servicios = new HashMap<>();
	
	public static void registrar (Class<?> in, Class<?> impl) {
		servicios.put(in, impl);
	}
	
	public static <T> T crear(Class<T> in) {
		Class<?> impl = servicios.get(in);
		Constructor<?> construc = impl.getDeclaredConstructors()[0];
		Object target = null;
		
		try{
			target = construc.newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Object proxy = crearProxy(target);
		return in.cast(proxy);
	}
	
	public static <T> T crearOperaciones(Class<T> clase ){
		OperacionesPoductosCrud target = new OperacionesProductosCrudimpl();
		Object proxy = crearProxy(target);
		
		return clase.cast(proxy);
	}
	
	private static Object crearProxy(Object target) {
		Object proxy = Proxy.newProxyInstance(OperacionesFactory.class.getClassLoader(), 
				target.getClass().getInterfaces(), new ImpresionInvocationHandler(target));
		return proxy;
	}
}
