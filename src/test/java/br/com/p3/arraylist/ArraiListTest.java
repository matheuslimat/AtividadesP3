package br.com.p3.arraylist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArraiListTest {

	ArraiList arrai;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {}

	@BeforeEach
	void init() {
		arrai = new ArraiList();
	}

	@AfterEach
	void tearDown() {
		arrai.clear();
	}

	@SuppressWarnings("unused")
	@Test
	void testArraiList() {
		//Iniciando arrailist n vezes
		int cont = 0;
		for (int i = 0; i < 5; i++) {
			ArraiList arrai = new ArraiList();
			cont = i;
		}
		Assertions.assertTrue(cont == 4);
	}

	@Test
	void testIniciaArraiPassandoTamanho() {
		ArraiList arrai = new ArraiList(42);
		Assertions.assertTrue(arrai.size() == 0);
	}

	@Test
	void testAdicionandoValorNulo() {
		ArraiList arrai = new ArraiList();
		Assertions.assertThrows(NullPointerException.class, () -> {
			arrai.add(null);
		});
	}

	@Test
	void testAdicionaElementos() {
		ArraiList arrai = new ArraiList();

		arrai.add("Iphone");
		arrai.add("Xiaomi");
		arrai.add("Nokia");

		Assertions.assertEquals("Iphone", arrai.get(0));
		Assertions.assertEquals("Xiaomi", arrai.get(1));
		Assertions.assertEquals("Nokia", arrai.get(2));

		Assertions.assertTrue(arrai.size() == 3);
	}

	@Test
	void testRemovendoNulo() {
		ArraiList arrai = new ArraiList();
		arrai.add("Iphone");

		Assertions.assertThrows(NullPointerException.class, () -> {
			arrai.remove(null);
		});

	}

	@Test
	void testRemovendoValorInexistente() {
		ArraiList arrai = new ArraiList();
		arrai.add("Iphone");

		Assertions.assertThrows(NullPointerException.class, () -> {
			arrai.remove("oi");
		});

	}

	@Test
	void removendoIndiceInexistente() {
		ArraiList arrai = new ArraiList();
		arrai.add("Iphone");
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			arrai.remove(2);
		});
	}

	@Test
	void pegaIndice() {
		ArraiList arrai = new ArraiList();
		arrai.add("ola");
		Assertions.assertTrue(arrai.get(0).equals("ola"));
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			arrai.get(1);
		});
	}

	//	@Test
	//	void adicionaElementoComIndice() {
	//		ArraiList arrai = new ArraiList();
	//		
	//		arrai.add("Iphone");
	//		arrai.add("Xiaomi");
	//		arrai.add("Nokia");
	//		
	//		arrai.add(1, "teste");
	//	}

	@Test
	void testGetValorNegativo() {
		ArraiList arrai = new ArraiList();
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			arrai.get(-1);
		});
	}

	@Test
	void testGetComArraiVazio() {
		ArraiList arrai = new ArraiList();
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			arrai.get(0);
		});
	}

	@Test
	void verificaArraiVazioIniciadoComTamanhoPadrao() {
		ArraiList arrai = new ArraiList();
		Assertions.assertTrue(arrai.isEmpty());
	}

	@Test
	void verificaArraiVazioIniciadoComTamanhoPassado() {
		ArraiList arrai = new ArraiList(42);
		Assertions.assertTrue(arrai.isEmpty());
	}

	@Test
	void testCloneTamanho() {
		//consertar fazer com q o metodo clone retorne o tipo ArraiList
		ArraiList arrai = new ArraiList(42);
		Object[] aux = arrai.clone();
		Assertions.assertTrue(aux.length != arrai.size());
	}

	@Test
	void testClear() {
		ArraiList arrai = new ArraiList(42);
		arrai.clear();
		Assertions.assertTrue(arrai.isEmpty());
	}

	@Test
	void testSizeComArraiVazio() {
		ArraiList arrai = new ArraiList(5);
		Assertions.assertTrue(arrai.size() == 0);

	}

	@Test
	void testSizeComElementos() {
		ArraiList arrai = new ArraiList(5);
		arrai.add("jetta");
		Assertions.assertTrue(arrai.size() == 1);
	}

	@Test
	void testIndexOfObjetoNaoEncontrado() {
		ArraiList arrai = new ArraiList(5);
		Assertions.assertTrue(arrai.indexOf("Asus") == -1);

	}

	@Test
	void testIndexOfValorNulo() {
		ArraiList arrai = new ArraiList(5);
		Assertions.assertThrows(NullPointerException.class, () -> {
			arrai.indexOf(null);
		});
	}

	@Test
	void lastIndexOf() {
		ArraiList arrai = new ArraiList(5);
		Assertions.assertTrue(arrai.lastIndexOf("asus") == -1);
	}

	@Test
	void isEmpty() {
		ArraiList arrai = new ArraiList(5);
		Assertions.assertTrue(arrai.isEmpty());
	}

	@Test
	void isContain() {
		ArraiList arrai = new ArraiList(5);
		Assertions.assertFalse(arrai.isContain("A"));
	}

	@Test
	void contain() {
		arrai.add("A");
		Assertions.assertTrue(arrai.isContain("A"));
	}


}
