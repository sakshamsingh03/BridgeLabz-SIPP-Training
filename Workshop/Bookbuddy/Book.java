import java.util.ArrayList;

public class Book {
	private ArrayList<String> book;

	public Book() {
		book = new ArrayList<>();
	}

	public void addBook(String title, String author) {
		book.add(title + "-" + author);
	}

	public void sortBookAlphabetically() {
		for (int i = 0; i < book.size() - 1; i++) {
			for (int j = i + 1; j < book.size(); j++) {
				if (book.get(i).compareTo(book.get(j)) > 0) {
					String temp = book.get(i);
					book.set(i, book.get(j));
					book.set(j, temp);
				}
			}
		}
	}

	public void searchByAuthor(String author) {
		boolean flag = true;
		for (int i = 0; i < book.size(); i++) {
			String[] arr = book.get(i).split("-");
			if (arr[1].equals(author)) {
				System.out.println(arr[0]);
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Book does not contain");
		}
	}

	public void display() {
		if(book.size()==0) {
			System.out.println("No book available");
			return;
		}
		for (int i = 0; i < book.size(); i++) {
			String[] arr = book.get(i).split("-");
			System.out.println(arr[0] + " by " + arr[1]);
		}
	}
}