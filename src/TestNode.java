import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class TestNode {
	private Node<String> node;
	
	@BeforeEach
    void setUp() throws Exception {
        this.node = new Node<String>();
    }
	
	@DisplayName("Getter y setter del dato String funciona")
	@Test
	public void testSetterandGetter() {
		this.node.setDato("Cebolla");
		assertEquals(node.getDato(),"Cebolla");
	}
	
	@DisplayName("Crear un nodo previo y comprobar que existe")
	@Test
	public void setPreviousNodeAndCheckIt() {
		String s = "Patatas";
		Node<String> previousNode = new Node<String>(s);
		this.node.setPreviousNode(previousNode);
		assertNotNull(this.node.prev());
		assertEquals(this.node.prev().getDato(),s);
	}
	
	@DisplayName("Crear un nodo siguiente y comprobar que existe")
	@Test
	public void setNextNodeAndCheckIt() {
		String s = "Naranjas";
		Node<String> nextNode = new Node<String>(s);
		this.node.setNextNode(nextNode);
		assertNotNull(this.node.next());
		assertEquals(this.node.next().getDato(),s);
	}

}
