package demo;

import org.junit.Test;

/**
 * 测试案例
 * @author water
 *
 */
public class TestCase {

	@Test //Junit提供的注解
	public void test1(){
		System.out.println("HelloWorld");
	}
	
	@Test
	public void testShowMethods() throws ClassNotFoundException{
		String className = "java.lang.String";
		Utils.showMethods(className);
	}
	
	@Test
	public void testShowInit() throws ClassNotFoundException{
		String className = "java.lang.String";
		Utils.showInit(className);
	}
	
	@Test
	public void testCreate() throws Exception{
		String className = "demo.Koo";
		//参数类型列表
		Class[] types = new Class[]{int.class,String.class};
		//参数列表
		Object[] params = new Object[]{10,"哈哈"};
		Object obj = Utils.create(className, types, params);
		System.out.println(obj);
	}
	
	@Test
	public void testGet() throws SecurityException, Exception{
		Koo koo = new Koo();
		koo.a = 2;
		//动态访问属性
		Object val = Utils.get(koo, "a");
		System.out.println(val);
	}
	
	@Test
	public void testExecute() throws Exception, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, Exception{
		Koo koo = new Koo();
		Object val = Utils.execute(koo, "sayHello", 
				new Class[]{String.class,String.class}, 
				new Object[]{"老鼠","大米"});
		System.out.println(val);
	}
	
}
