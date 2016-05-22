package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Utils {
	
	/**
	 * 调用某对象的某个方法
	 * @param obj 某个对象
	 * @param method 某方法名
	 * @param paramTypes 参数类型列表
	 * @param params 参数列表
	 * @return 方法结果
	 * 
	 * Koo koo = new Koo();
	 * execute(koo,"sayHello",new Class[]{String.class,String.class},
	 * 			new Object[]{"Tom","Jerry"});
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * 
	 */
	public static Object execute(
			Object obj,String method,Class[] paramTypes,Object[]params) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, Exception{
		//找到方法信息
		Class cls = obj.getClass();
		Method m = cls.getDeclaredMethod(method, paramTypes);
		//调用方法，在对象上执行方法，params传递的参数
		//invoke 调用
		Object val = m.invoke(obj, params);
		return val;
		
	}
	
	/**
	 * 返回某对象的某个属性
	 * @param obj 某对象
	 * @param fieldName 某个属性的名
	 * @return 属性的值
	 * Koo koo = new Koo(2,4);
	 * 
	 * Object val = get(koo,"a");//2
	 * koo.a;
	 * @throws Exception 
	 * @throws SecurityException 
	 */
	public static Object get(Object obj,String fieldName) throws SecurityException, Exception{
		//找到Class Object.getClass()
		Class cls = obj.getClass();
		//找到属性信息
		Field field = cls.getDeclaredField(fieldName);
		//利用属性信息类Field的get方法获取属性值
		Object val = field.get(obj);//获取对象的属性
		return val;
		
	}
	
	
	/**
	 * 动态 调用"某个类"的"某个构造器"创建一个对象
	 * @param className 某个类名
	 * @param paramTypes 某个构造器参数类型列表
	 * @param params 调用构造器时传递的参数列表
	 * @return 一个对象
	 * 
	 * create("java.util.ArrayList",
	 * 		new Class[]{int.class},new Object[]{200});
	 * 
	 * 相当于 new ArrayList(200);
	 * 
	 */
	public static Object create(
			String className,Class[] paramTypes,Object[] params)throws Exception{
		//动态加载类
		Class cls = Class.forName(className);
		//找到构造器信息
		Constructor constructor = cls.getDeclaredConstructor(paramTypes);
		//constructor是构造器的信息，提供了执行构造器得方法
		//newInstance,执行这个方法，必须提供参数列表，其类型与参数类型列表匹配
		Object obj = constructor.newInstance(params);
		return obj;
		
	}
	
	/**
	 * 显示一个类的全部构造器信息
	 * @throws ClassNotFoundException 
	 */
	public static void showInit(String className) throws ClassNotFoundException{
		//Constructor:构造器
		Class c = Class.forName(className);
		Constructor[] constructors = c.getDeclaredConstructors();
		for (Constructor con : constructors) {
			System.out.print(con.getName());
			System.out.print(Arrays.toString(con.getParameterTypes()));
			System.out.println();
		}
		
	}
	
	/**
	 * 显示一个累的全部方法信息
	 * 参数是一个动态类名
	 * @return 
	 * @throws ClassNotFoundException 
	 */
	public static void showMethods(String className) throws ClassNotFoundException{
		Class cls = Class.forName(className);
		//返回cls类信息中全部方法信息
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getReturnType()+" ");
			System.out.print(method.getName());
			System.out.println(Arrays.toString(method.getParameterTypes()));
		}
	}
	
	/**
	 * 显示一个类的全部属性信息
	 * @param className 类名
	 * @throws ClassNotFoundException 
	 * @throws Exception 类名错误时抛异常
	 */
	public static void showFileds(String className) throws ClassNotFoundException{
		//动态加载类(类信息到方法区)
		Class cls = Class.forName(className);
		//动态获取全部属性信息
		Field[] field = cls.getDeclaredFields();
		
		//for遍历属性数组，显示全部属性信息
		for (Field f : field) {
			System.out.print(f.getType()+" ");
			System.out.println(f.getName());
		}
		
	}
	
}
