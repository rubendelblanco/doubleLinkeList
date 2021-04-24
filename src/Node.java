
public class Node<T> {
    private T dato;
	private Node<T> nextNode;
	private Node<T> previousNode;
	
	public Node() {
	}
	
	public Node(T dato) {
		this.dato = dato;
	}

	public T getDato() {
		return this.dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Node<T> next() {
		return this.nextNode;
	}

	public Node<T> prev() {
		return this.previousNode;
	}

	public void setNextNode(Node<T> n) {
		this.nextNode = n;
	}

	public void setPreviousNode(Node<T> n) {
		this.previousNode = n;
	}
}
