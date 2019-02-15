package bookapp_jdbc;

import java.util.Scanner;

public class TestBookDAO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		BookDAo bookDAo = new BookDAo();
		BookValidator bookValidator = new BookValidator();
		int choice;
		int id, price;
		String name = null;
		do {
			System.out.println("enter the operation to perform");
			System.out
					.println("1.insert 2.select 3.delete 4.update 5.dispay all 6.exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the name,price");
				scanner.nextLine();
				price = scanner.nextInt();
				//bookValidator.bookValidate(name, price);
				bookDAo.addBook(name, price);
				bookDAo.FindAll();
				break;
			case 2:
				System.out.println("enter the id");
				id = scanner.nextInt();
				bookDAo.FindById(id);
				break;
			case 3:
				System.out.println("Delete by id or delete by name");
				System.out.println("1.delete by id 2.delete by name");
				int dchoice = scanner.nextInt();
				switch (dchoice) {
				case 1:
					System.out.println("enter the id");
					id = scanner.nextInt();
					bookDAo.deleteById(id);
					bookDAo.FindAll();
					break;

				case 2:

					System.out.println("enter the name");
					name = scanner.next();
					bookDAo.deleteByName(name);
					bookDAo.FindAll();
					break;
					
				default:
					System.out.println("invalid choice");
				break;
				}
				
			break;
			case 4:
				System.out.println("enter the id");
				id = scanner.nextInt();
				bookDAo.setUpdate(id, name);
				bookDAo.FindAll();
				break;

			case 5:
				bookDAo.FindAll();
				break;
			}
		} while (choice != 6);

		scanner.close();
	}

}
