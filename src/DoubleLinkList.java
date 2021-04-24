public class DoubleLinkList<T> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int listSize;
	
	/**
	 * Constructor
	 */
	public DoubleLinkList() {
		this.firstNode = null;
		this.lastNode = null;
		listSize = 0;
	}
	

	/**
	 * Anade un nodo al final de la lista (push)
	 * 
	 * @param String element
	 */
	public void add(T element) {
		Node<T> node = new Node<T>(element);

		if (this.listSize == 0) {
			this.firstNode = node;
			this.lastNode = node;
		} else {
			node.setPreviousNode(this.lastNode);
			this.lastNode.setNextNode(node);
			this.lastNode = node;
		}

		this.listSize++;
	}

	/**
	 * Anade un elemento en la posicion pos dada como parametro. Si ya existe esa
	 * posicion sustituye el elemento. Si no, se hara un push en la lista Por
	 * ejemplo, supongamos que la lista es de tamano 3, si se invoca add(6, 'foo')
	 * el elemento se anadira en la posicion 4, que es la ultima.
	 * 
	 * @param pos
	 * @param element
	 */
	public void add(int pos, T element) {
		Node<T> nodo = this.findNode(pos);

		/**
		 * Si el nodo es null algo no cuadra. O bien pos <1 o bien pos > listSize En el
		 * último caso, haremos un push sin mas, Es decir añadiremos el elemento al
		 * final de la lista
		 */
		if (nodo == null) {
			if (pos < 1) {
				System.err.println("La posicion ha de ser mayor que 0");
			} else {
				this.add(element);
			}
			return;
		}

		nodo.setDato(element);
	}

	/**
	 * Devuelve el tamano de la lista (numero de elementos)
	 * 
	 * @return numero de elementos de la lista
	 */
	public int getSize() {
		return this.listSize;
	}

	/**
	 * Recoge el dato T de la posicion dada, null si no existe
	 * 
	 * @param pos posicion del nodo
	 * @return T la cadena de texto del nodo
	 */
	public T getData(int pos) {
		if (this.findNode(pos) == null) {
			return null;
		}

		return this.findNode(pos).getDato();
	}

	/**
	 * Borra el nodo de la posicion pos
	 * 
	 * @param pos La posicion del nodo en la lista
	 * @return boolean true si se ha borrado satisfactoriamente, false si no
	 */
	public boolean delete(int pos) {
		Node<T> node = this.findNode(pos);
		return this.delete(node);
	}

	/**
	 * Borra el nodo node
	 * 
	 * @param pos La posicion del nodo en la lista
	 * @return boolean true si se ha borrado satisfactoriamente, false si no
	 */
	public boolean delete(Node<T> node) {
		if (node == null) {
			return false;
		}

		Node<T> previous = node.prev();
		Node<T> next = node.next();

		if (previous == null) //primer nodo
			this.firstNode = next;
		else
			previous.setNextNode(next);

		if (next == null) //ultimo nodo
			this.lastNode = previous;
		else
			next.setPreviousNode(previous);
		
		this.listSize--; // importante esto!
		return true;
	}

	/**
	 * Borra el nodo o nodos que contiene el T element dado.
	 * 
	 * @param element la cadena de texto a buscar
	 * @return int devuelve el numero de elementos borrados
	 */
	public int delete(T element) {
		int borrados = 0;
		Node<T> node = this.firstNode;

		while (node != null) {
			if (node.getDato() == element) {
				this.delete(node);
				borrados++;
			}

			node = node.next();
		}

		return borrados;
		
	}

	/**
	 * Añade todos los elementos de una lista a esta lista.
	 * 
	 * @param lista
	 */
	public void concat(DoubleLinkList<T> lista) {
		for (int i = 1; i <= lista.listSize; i++) {
			this.add(lista.findNode(i).getDato());
		}
	}

	/**
	 * Imprime todos los Ts de la lista
	 */
	public void printList() {
		Node<T> node = this.firstNode;

		while (node != null) {
			System.out.println(node.getDato());
			node = node.next();
		}
	}

	/**
	 * Devuelve el nodo de la posicion pos. Si la posicion no cuadra con ningun
	 * elemento de la lista (es menor que 1 o mayor que el tamaño de la lista),
	 * devuelve un nodo null
	 * 
	 * @return Node reference
	 */
	public Node<T> findNode(int pos) {
		Node<T> reference = null; // el nodo de referencia con el que vamos a iterar hasta encontrar el nodo en la
										// posicion pos

		if (pos > this.listSize || pos < 1) {
			return reference;
		}

		// si la posicion es mayor que listSize/2, mejor empezar a iterar por el final
		if (pos > (this.listSize) / 2) {
			int contador = this.listSize;
			reference = this.lastNode;

			while (contador != pos) {
				reference = reference.prev();
				contador--;
			}

			return reference;
		} else {
			int contador = 1;
			reference = this.firstNode;

			while (contador != pos) {
				reference = reference.next();
				contador++;
			}

			return reference;
		}
	}

}
