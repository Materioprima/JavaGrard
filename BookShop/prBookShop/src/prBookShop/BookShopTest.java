package prBookShop;

public class BookShopTest {

	public static void main(String[] args) {
		BookShop shop1 = new BookShop();
		shop1.addBook("pepe", "el principoto", 12);
		shop1.addBook("MANOLO", "tu mae", 15);
		shop1.addBook("pepA", "el principoto", 12);
		shop1.deleteBook("pepe", "el principoto");
		System.out.println(shop1);
	}

}

