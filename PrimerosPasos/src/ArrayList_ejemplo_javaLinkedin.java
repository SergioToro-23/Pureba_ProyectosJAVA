import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class ArrayList_ejemplo_javaLinkedin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List list= new ArrayList();
		Iterator it = list.iterator();
		list.add("hello");
		list.add(2);
		
		
		
		
		/*
		//recorre la lista
		list.forEach(System.out::println);//method reference, print with an unkown parameter name
		//recorre la lista
		for(Object object : list) {
			System.out.println(object);
		}
		//tama�o lista
		System.out.println(list.size());
		System.out.println(list.get(0) instanceof Object);
		System.out.println(list.get(1) instanceof Integer);
		*/
		
		/*
		String messages = "hello world!";
		String newMessage = messages.substring(6,12) +  messages.substring(6,7);
		System.out.println(newMessage);
		*/
		
		/*
		try {
			System.out.println("A");
			badMethod();
			System.out.println("B");
		} catch (Exception ex) {
			System.out.println("C");
		} finally {
			System.out.println("D");
		}
		*/
		
		/*
		String message = "Hello";
		for(int i=0; i<message.length();i++) {
			System.out.print(message.charAt(i+1));
		}
		*/
		/*
		List<Boolean> list = new ArrayList<>();
		list.add(true);
		list.add(Boolean.parseBoolean("FalSe"));
		list.add(Boolean.TRUE);
		System.out.print(list.size());
		System.out.print(list.get(1) instanceof Boolean);
		*/
		
		
		
	}
	
/*
	public static void badMethod() {
		throw new Error();
	}
*/	
	
}
