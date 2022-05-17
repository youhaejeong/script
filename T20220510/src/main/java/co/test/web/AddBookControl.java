package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class AddBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("입력처리 컨트롤");
		//addbook.do -> addOutput.jsp
		String title=request.getParameter("title");
//		String author=request.getParameter("author");
//		String press=request.getParameter("press");
//		String price=request.getParameter("price");
//		
		request.setAttribute("Hello", title);
		
//		System.out.println(price);
//		
//		BookVO vo =new BookVO();
//		vo.setBookTitle(title);
//		vo.setBookAuthor(author);
//		vo.setBookPress(press);
//		vo.setBookPrice(Integer.parseInt(price));
//		
//		BookService service=new BookService();
//		service.addBook(vo);
//		
//		request.setAttribute("title", title);
//		request.setAttribute("author", author);
		
		request.getRequestDispatcher("result/addOutput.jsp").forward(request, response);

	}

}
