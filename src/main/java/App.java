import java.util.ArrayList;

import br.com.p3.arraylist.ArraiList;

public class App {

	public static void main(String[] args)	 {
		ArraiList arrai = new ArraiList();
		arrai.add("testee");
		arrai.add("testee");
		arrai.add("testee");
		arrai.add("testee");
		
		System.out.println(arrai.get(50));
		
		ArrayList<String> ola = new ArrayList<String>();
		ola.add(null);
		ola.get(1);

	} 

}
