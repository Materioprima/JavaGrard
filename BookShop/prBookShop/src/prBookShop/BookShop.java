package prBookShop;

public class BookShop {
	
	private int numBooks;
	private Book bookArr [];
	private final int arrDefaultSize = 16;

	public BookShop () {
		 this.bookArr = new Book [this.arrDefaultSize];
		 numBooks=0;
	}
	
	public BookShop (int cap) {
		this.bookArr=new Book [cap];
		numBooks=0;
	}
	
	public void addBook(String author, String title, double price) {
		Book newBook = new Book(author, title, price);
		addBook(newBook);
	}
	
	
	public void deleteBook(String author, String title) {
		deleteBook(seekBook(author, title));
	}
	public double getBasePrice(String author, String title) {
		int book = seekBook(author, title);
		return	this.bookArr[book].getBasePrice();
	}
	
	
	private int seekBook (String author, String title) {
		int i = 0;
		int res=-1;
		while ((res==-1) && (i < numBooks)) {
			if((author==this.bookArr[i].getAuthor())&&(title==this.bookArr[i].getTitle())) {
				res=i;
			}
			i++;
		}
		return res;
	}
	
	private void deleteBook(int book) {
		if(book!=-1){
			if(bookArr[book]!=null){
				bookArr[book]=null;
			}
		}
	}
	
	public double amountDue(String author, String title) {
		double res;
		int book = seekBook(author, title);
		if (book != -1) res = this.bookArr[book].amountDue();
		else res = 0;
		return res;
	}
	
	public String toString() {
		String res ="";
		for(int e=0;e<bookArr.length;e++) {
			if(bookArr[e]!=null){
				res+=this.bookArr[e]+" \n";
			}
		}
		return res;
	}
	
	private void addBook (Book book){
		int res=seekBook(book.getAuthor(),book.getTitle());
		if (res!=-1){
			this.bookArr[res]=book;
		}else {
			if(numBooks==bookArr.length){
				Book copia[]=new Book[(bookArr.length*2)];
				copia=bookArr.clone();
				bookArr=copia;
			}
			int i=0;
			while((res==-1)&&(i<bookArr.length)){
				if(bookArr[i]==null){
					bookArr[i]=book;
					res=0;
					numBooks++;
				}
				i++;
			}
		}
	}
	
	/*
	 * 
int i = 0;
		while (i < numBooks && book.getAuthor() != bookArr[i].getAuthor() && book.getTitle() != bookArr[i].getTitle()) {++i;}	
			if (numBooks == bookArr.length) { System.arraycopy(bookArr, 0, bookArr, 0, bookArr.length*2);
			bookArr[numBooks+1] = book;
			this.numBooks++;
		}
		else {
			bookArr[i] = book; 
		
		}
	 */
}
