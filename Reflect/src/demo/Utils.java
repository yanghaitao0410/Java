package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Utils {
	
	/**
	 * ����ĳ�����ĳ������
	 * @param obj ĳ������
	 * @param method ĳ������
	 * @param paramTypes ���������б�
	 * @param params �����б�
	 * @return �������
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
		//�ҵ�������Ϣ
		Class cls = obj.getClass();
		Method m = cls.getDeclaredMethod(method, paramTypes);
		//���÷������ڶ�����ִ�з�����params���ݵĲ���
		//invoke ����
		Object val = m.invoke(obj, params);
		return val;
		
	}
	
	/**
	 * ����ĳ�����ĳ������
	 * @param obj ĳ����
	 * @param fieldName ĳ�����Ե���
	 * @return ���Ե�ֵ
	 * Koo koo = new Koo(2,4);
	 * 
	 * Object val = get(koo,"a");//2
	 * koo.a;
	 * @throws Exception 
	 * @throws SecurityException 
	 */
	public static Object get(Object obj,String fieldName) throws SecurityException, Exception{
		//�ҵ�Class Object.getClass()
		Class cls = obj.getClass();
		//�ҵ�������Ϣ
		Field field = cls.getDeclaredField(fieldName);
		//����������Ϣ��Field��get������ȡ����ֵ
		Object val = field.get(obj);//��ȡ���������
		return val;
		
	}
	
	
	/**
	 * ��̬ ����"ĳ����"��"ĳ��������"����һ������
	 * @param className ĳ������
	 * @param paramTypes ĳ�����������������б�
	 * @param params ���ù�����ʱ���ݵĲ����б�
	 * @return һ������
	 * 
	 * create("java.util.ArrayList",
	 * 		new Class[]{int.class},new Object[]{200});
	 * 
	 * �൱�� new ArrayList(200);
	 * 
	 */
	public static Object create(
			String className,Class[] paramTypes,Object[] params)throws Exception{
		//��̬������
		Class cls = Class.forName(className);
		//�ҵ���������Ϣ
		Constructor constructor = cls.getDeclaredConstructor(paramTypes);
		//constructor�ǹ���������Ϣ���ṩ��ִ�й������÷���
		//newInstance,ִ����������������ṩ�����б�����������������б�ƥ��
		Object obj = constructor.newInstance(params);
		return obj;
		
	}
	
	/**
	 * ��ʾһ�����ȫ����������Ϣ
	 * @throws ClassNotFoundException 
	 */
	public static void showInit(String className) throws ClassNotFoundException{
		//Constructor:������
		Class c = Class.forName(className);
		Constructor[] constructors = c.getDeclaredConstructors();
		for (Constructor con : constructors) {
			System.out.print(con.getName());
			System.out.print(Arrays.toString(con.getParameterTypes()));
			System.out.println();
		}
		
	}
	
	/**
	 * ��ʾһ���۵�ȫ��������Ϣ
	 * ������һ����̬����
	 * @return 
	 * @throws ClassNotFoundException 
	 */
	public static void showMethods(String className) throws ClassNotFoundException{
		Class cls = Class.forName(className);
		//����cls����Ϣ��ȫ��������Ϣ
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getReturnType()+" ");
			System.out.print(method.getName());
			System.out.println(Arrays.toString(method.getParameterTypes()));
		}
	}
	
	/**
	 * ��ʾһ�����ȫ��������Ϣ
	 * @param className ����
	 * @throws ClassNotFoundException 
	 * @throws Exception ��������ʱ���쳣
	 */
	public static void showFileds(String className) throws ClassNotFoundException{
		//��̬������(����Ϣ��������)
		Class cls = Class.forName(className);
		//��̬��ȡȫ��������Ϣ
		Field[] field = cls.getDeclaredFields();
		
		//for�����������飬��ʾȫ��������Ϣ
		for (Field f : field) {
			System.out.print(f.getType()+" ");
			System.out.println(f.getName());
		}
		
	}
	
}
