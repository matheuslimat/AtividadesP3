package br.com.p3.arraylist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListTest {

	ArrayList<String> arrai;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {}

	@BeforeEach
	void init() {
		arrai = new ArrayList<>();
	}

	@AfterEach
	void tearDown() {
		arrai.clear();
	}

	@SuppressWarnings("unused")
	@Test
	void testArraiList() {
		int cont = 0;
		ArrayList<String> arrai;
		for (int i = 0; i < 5; i++) {
			arrai = new ArrayList<>();
			cont = i;
		}
		Assertions.assertTrue(cont == 4);
	}

	@Test
	void testIniciaArraiPassandoTamanho() {
		ArrayList<String> arrai = new ArrayList<String>(42);
		Assertions.assertTrue(arrai.size() == 0);
	}

	@Test
	void testAdicionandoValorNulo() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			arrai.add(null);
		});
	}

	@Test
	void testAdicionaElementos() {
		arrai.add("Iphone");
		arrai.add("Xiaomi");
		arrai.add("Nokia");

		Assertions.assertEquals("Iphone", arrai.get(0));
		Assertions.assertEquals("Xiaomi", arrai.get(1));
		Assertions.assertEquals("Nokia", arrai.get(2));

		Assertions.assertTrue(arrai.size() == 3);
	}
	
	@Test
	void testAddTrue() {
		Assertions.assertTrue(arrai.add("hello") == true);
	}
	
	@Test
	void testAddAll() {
		arrai.add("dinheiro");
		ArrayList<String> aux = new ArrayList<>();
		aux.add("Jetta");
		aux.add("Jeep");
		
		arrai.addAll(aux);
		Assertions.assertTrue(arrai.size() == 3);
	}
	
	@Test
	void testAddAllObjetoNulo() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			arrai.addAll(null);
		});
	}

	@Test
	void testRemovendoNulo() {
		arrai.add("Iphone");

		Assertions.assertThrows(NullPointerException.class, () -> {
			arrai.remove(null);
		});
	}

	@Test
	void testRemovendoValorInexistente() {
		arrai.add("Iphone");

		Assertions.assertThrows(NullPointerException.class, () -> {
			arrai.remove("oi");
		});

	}

	@Test
	void removendoIndiceInexistente() {
		arrai.add("Iphone");
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			arrai.remove(2);
		});
	}

	@Test
	void pegaIndice() {
		arrai.add("ola");
		Assertions.assertTrue(arrai.get(0).equals("ola"));
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			arrai.get(1);
		});
	}

	@Test
	void testGetValorNegativo() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			arrai.get(-1);
		});
	}

	@Test
	void testGetComArraiVazio() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			arrai.get(0);
		});
	}

	@Test
	void verificaArraiVazioIniciadoComTamanhoPadrao() {
		Assertions.assertTrue(arrai.isEmpty());
	}

	@Test
	void verificaArraiVazioIniciadoComTamanhoPassado() {
		Assertions.assertTrue(arrai.isEmpty());
	}

	@Test
	void testClear() {
		arrai.clear();
		Assertions.assertTrue(arrai.isEmpty());
	}
	
	@Test
	void testClearComElementos() {
		arrai.add("Hello World");
		arrai.clear();
		Assertions.assertTrue(arrai.isEmpty());
	}

	@Test
	void testSizeComArraiVazio() {
		Assertions.assertTrue(arrai.size() == 0);

	}

	@Test
	void testSizeComElementos() {
		arrai.add("jetta");
		Assertions.assertTrue(arrai.size() == 1);
	}

	@Test
	void testIndexOfObjetoNaoEncontrado() {
		Assertions.assertTrue(arrai.indexOf("Asus") == -1);

	}

	@Test
	void testIndexOfValorNulo() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			arrai.indexOf(null);
		});
	}

	@Test
	void lastIndexOf() {
		Assertions.assertTrue(arrai.lastIndexOf("asus") == -1);
	}

	@Test
	void isEmpty() {
		Assertions.assertTrue(arrai.isEmpty());
	}

	@Test
	void isContain() {
		Assertions.assertFalse(arrai.isContain("A"));
		arrai.add("b");
		arrai.remove("b");
		Assertions.assertFalse(arrai.isContain("b"));
	}

	@Test
	void contain() {
		arrai.add("A");
		Assertions.assertTrue(arrai.isContain("A"));
	}
	
	@Test
	void setIndiceInvalido() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			arrai.set(-30, "teste set");
		});
	}
	
	@Test
	void testSet() {
		arrai.add("PHP");
		arrai.set(0, "java");
		Assertions.assertTrue(arrai.get(0).equals("java"));
	}
	
	@Test
	void testClone() {
		arrai.add("hp");
		arrai.add("asus");
		ArrayList<String> aux = arrai.clone();
		Assertions.assertTrue(aux.toString().equals(arrai.toString()));
	}


}
