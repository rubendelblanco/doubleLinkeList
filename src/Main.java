public class Main {
	
	public static void main(String[] args) {
		DoubleLinkList list = new DoubleLinkList();
		System.out.println("Creamos una lista vacia");
		list.add("Cebolla");
		list.add("Ajos");
		list.add("Pollo");
		System.out.println("Anadimos elementos");
		list.printList();
	}

}
