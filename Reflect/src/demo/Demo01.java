package demo;

import java.util.Scanner;

public class Demo01 {

	public static void main(String[]args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Scanner in = new Scanner(System.in);
		//�����ڼ䶯̬�������
		String className = in.nextLine();
		//ʹ�÷���API��̬������
		Class cls = Class.forName(className);
		System.out.println(cls);
		//��̬��������:��������޲�����������������
		Object obj = cls.newInstance();
		System.out.println(obj);
	}
	
}
