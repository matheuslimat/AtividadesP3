import br.com.p3.arraylist.ArraiList;
import br.com.p3.exceptions.ValorNuloException;

public class App {

	public static void main(String[] args) {
		ArraiList arrai = new ArraiList(2);
		try {
			arrai.add("aline");
		} catch (ValorNuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			arrai.add("matheus");
		} catch (ValorNuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
