package demo;

import java.lang.reflect.Field;

public class Demo02 {

	public static void main(String[] args) throws ClassNotFoundException {
		String className = "demo.Koo";
		//��̬������
		Class cls = Class.forName(className);
		//��̬��ȡ������Ϣ
		Field[] fields = cls.getDeclaredFields();
		//Field ��װ��һ��������ص���Ϣ
		System.out.println(fields.length);
		//getName()��ȡ���Ե�
		System.out.println(fields[0].getName());
		System.out.println(fields[1].getName());
		
	}
	
}
