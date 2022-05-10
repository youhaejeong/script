package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class ModifyBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("tnwjdtnwjd");
		String code = request.getParameter("bookCode");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String price = request.getParameter("price");

		if (code.isEmpty() || title.isBlank() || author.isBlank() || press.isBlank() || price.isBlank()) {
			request.setAttribute("error", "입력하세요");
			request.getRequestDispatcher("").forward(request, response);
			return;
		}
		
			BookVO book=new BookVO();
			book.setBookCode(code);
			book.setBookTitle(title);
			book.setBookAuthor(author);
			book.setBookPress(press);
			book.setBookPrice(Integer.parseInt(price));
			
			BookService service = new BookService();
			service.modifyBook(book);
			
			request.setAttribute("book", book);
		
			
			request.getRequestDispatcher("result/modifyOutput.jsp").forward(request, response);
		}
	}


