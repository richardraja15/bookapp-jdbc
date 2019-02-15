package bookapp_jdbc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestBookObjDAO {

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		BookObjDAO bookDAo= new BookObjDAO();
		Book book=new Book();
		BookValidator bookValidator = new BookValidator();
		LocalDate localDate = null;
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		int choice;
				do {
			System.out.println("enter the operation to perform");
			System.out
					.println("1.insert 2.select 3.delete 4.update 5.dispay all 6.exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the id,name,price,author name,published date(dd-mm-yyyy)");
				scanner.nextLine();
				book.id=scanner.nextInt();
				book.name = scanner.next();
				book.price=scanner.nextInt();
				book.author=scanner.next();
				String date=scanner.next();
				book.publishedDate=localDate.parse(date,formatter);
				bookValidator.validateAdd(book);
				bookDAo.addBook(book);
				bookDAo.FindAll();
				break;
			case 2:
				System.out.println("enter the id");
				book.id=scanner.nextInt();
				bookValidator.validateSelectById(book);
				book=bookDAo.FindById(book);
				if(book==null)
					{
					System.out.println("not found");
				
					}
				else
				{
					System.out.println(book.id+book.name+book.author+book.price);
				}
				break;
			case 3:
				System.out.println("enter the id");
				book.id=scanner.nextInt();
				//bookValidator.validateSelectById(book);
				book=bookDAo.FindById(book);
				if(book==null)
					{
					System.out.println("not found");
				
					}
				else
				{
					bookDAo.delete(book.id);
				}
				break;
				
			case 5:
			ArrayList<Book> list=new ArrayList<Book>();
				list=bookDAo.FindAll();
				if(list.isEmpty())
				{
					System.out.println("Book table is empty");

				}
				else
				{
					System.out.println("id\tname\tprice\tauthor\tpublished date");
					for(Book l:list)
					{
						System.out.println(l.id+"\t"+l.name+"\t"+l.price+"\t"+l.author+"\t"+l.publishedDate);
					}
				}
				break;
			}
				} while (choice != 6);

		scanner.close();
	}

}
