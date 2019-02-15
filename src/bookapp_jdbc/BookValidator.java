package bookapp_jdbc;

public class BookValidator {

	public void validateAdd(Book book)throws Exception
	{
		if(book.name==null || book.equals(""))
		{
			throw new Exception("invalid name");
		}
		if(book.price<=0){
			throw new Exception("price not in range");
		}
	}
	public void validateSelectById(Book book) throws Exception
	{
		if(book.id<=0)
		{
			throw new Exception("Invalid ID");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
