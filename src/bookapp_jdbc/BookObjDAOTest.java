package bookapp_jdbc;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BookObjDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after");
	}

	@Test
	public void testAddBook() throws Exception {
		BookObjDAO bookObjDAO = new BookObjDAO();
		Book book = new Book();
		book.id = 5;
		book.name = "foe";
		book.price = 123;
		book.author = "ric";
		book.publishedDate = LocalDate.parse("2019-02-02");
		bookObjDAO.addBook(book);

		Book book2 = new Book();
		book2.id = 5;

		book2 = bookObjDAO.FindById(book2);

		assertEquals(book.id, book2.id);
	}

	@Test
	public void testFindAll() throws Exception {
		ArrayList<Book> bList = new ArrayList<Book>();
		BookObjDAO bookObjDAO=new BookObjDAO();
		bList=bookObjDAO.FindAll();
	assertNotEquals(true, bList.isEmpty());
	}

	@Test
	public void testFindById() throws Exception {
		BookObjDAO bookObjDAO=new BookObjDAO();
		Book book=new Book();
		book.id=15;
		
		Book book2=new Book();
		book2=bookObjDAO.FindById(book);
		assertEquals(book.id, book2.id);
	}

	@Ignore
	public void testdelete() throws Exception {
		BookObjDAO bookObjDAO = new BookObjDAO();
		Book book = new Book();
		book.id = 2;
		bookObjDAO.delete(book.id);

		Book book2 = new Book();
		book2.id = 2;
		book2 = bookObjDAO.FindById(book2);
		assertEquals(null, book2);
	}
}
