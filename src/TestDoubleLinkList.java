import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestDoubleLinkList {
	
	private DoubleLinkList<String> list;
	
	@BeforeEach
    void setUp() throws Exception {
        this.list = new DoubleLinkList<String>();
    }
	
	@DisplayName("Insertar nodo funciona")
	@Test
	public void testIfNewNodeIsAdded() {
		this.list.add("Ajos");
		assertEquals(this.list.getData(1),"Ajos");
	}
	
	@DisplayName("Insertar en posicion 4 debe reposicionar en posicion 1")
	@Test
	public void testIfAddNewNodeInPositionOneInsteadFourIsCorrect() {
		this.list.add(4, "Ajos"); //debe almacenarlo en la posicion 1
		assertEquals(this.list.getData(1),"Ajos");
	}
	
	@DisplayName("Tamanho de la lista es correcto")
	@Test
	public void testIfSizeIsCorrect() {
		this.list.add("Ajos");// 1
		this.list.add("Tomates"); //2
		this.list.add("Zumo"); //3
		assertEquals(this.list.getSize(),3);
	}
	
	@DisplayName("Recoger dato en la posicion 1,2,3 y 4 (null)")
	@Test
	public void testIfGetDataIsCorrect() {
		this.list.add("Ajos");// 1
		this.list.add("Tomates"); //2
		this.list.add("Zumo"); //3
		assertEquals(this.list.getData(1),"Ajos");
		assertEquals(this.list.getData(2),"Tomates");
		assertEquals(this.list.getData(3),"Zumo");
		assertEquals(this.list.getData(4),null);
	}
	
	@DisplayName("Borrar dato 2 de una lista de 3")
	@Test
	public void testIfDeleteFromPositionIsCorrect() {
		this.list.add("Ajos");// 1
		this.list.add("Tomates"); //2
		this.list.add("Zumo"); //3
		this.list.delete(2);
		assertEquals(this.list.getSize(),2);
		assertEquals(this.list.getData(1),"Ajos");
		assertEquals(this.list.getData(2),"Zumo");
		assertEquals(this.list.getData(3),null);
	}
	
	@DisplayName("Borrar dato inicial de una lista de 3")
	@Test
	public void testIfDeleteFromFirstPositionIsCorrect() {
		this.list.add("Ajos");// 1
		this.list.add("Tomates"); //2
		this.list.add("Zumo"); //3
		this.list.delete(1);
		assertEquals(this.list.getSize(),2);
		assertEquals(this.list.getData(1),"Tomates");
		assertEquals(this.list.getData(2),"Zumo");
		assertEquals(this.list.getData(3),null);
	}
	
	@DisplayName("Borrar dato final de una lista de 3")
	@Test
	public void testIfDeleteFromLasttPositionIsCorrect() {
		this.list.add("Ajos");// 1
		this.list.add("Tomates"); //2
		this.list.add("Zumo"); //3
		this.list.delete(3);
		assertEquals(this.list.getSize(),2);
		assertEquals(this.list.getData(1),"Ajos");
		assertEquals(this.list.getData(2),"Tomates");
		assertEquals(this.list.getData(3),null);
	}
	
	@DisplayName("Borrar nodos que contengan el dato 'Ajos'")
	@Test
	public void testIfDeleteNodeByStringIsCorrect() {
		this.list.add("Ajos");// 1
		this.list.add("Tomates"); //2
		this.list.add("Ajos"); //3
		int delete = this.list.delete("Ajos");
		assertEquals(delete,2);
		assertEquals(this.list.getSize(),1);
		assertEquals(this.list.getData(1),"Tomates");
		assertEquals(this.list.getData(2),null);
		assertEquals(this.list.getData(3),null);
	}
	
	@DisplayName("Borrar nodos por posicion 2 y 4")
	@Test
	public void testIfDeleteNodeByPositionIsCorrect() {
		this.list.add("Ajos");// 1
		this.list.add("Tomates"); //2
		this.list.add("Cebolla"); //3
		this.list.add("Patatas"); //4
		this.list.delete(2);
		this.list.delete(3); //el nodo en posicion 4 (Patatas) pasa a ser 3
		assertEquals(this.list.getSize(),2);
		assertEquals(this.list.getData(1),"Ajos");
		assertEquals(this.list.getData(2),"Cebolla");
		assertEquals(this.list.getData(3),null);
	}
	
	@DisplayName("Concatenar dos listas")
	@Test
	public void testIfConcatListIsCorrect() {
		DoubleLinkList<String> list2 = new DoubleLinkList<String>();
		
		//lista inicial
		this.list.add("Ajos");// 1
		this.list.add("Tomates"); //2
		this.list.add("Lechuga"); //3
		//lista 2
		list2.add("Lejia");
		list2.add("Vino");
		this.list.concat(list2);
		assertEquals(this.list.getSize(),5);
		assertEquals(this.list.getData(4),"Lejia");
		assertEquals(this.list.getData(5),"Vino");
	}
	
	@DisplayName("Borrar una lista entera y comprobar que tamanho es 0")
	@Test
	public void testDeleteAllList() {
		this.list.add("Ajos");// 1
		this.list.add("Tomates"); //2
		this.list.add("Lechuga"); //3
		//borramos tres veces el primer elemento
		this.list.delete(1);
		this.list.delete(1);
		this.list.delete(1);
		assertEquals(this.list.getSize(),0);
		assertEquals(this.list.getData(1),null);
	}

}
