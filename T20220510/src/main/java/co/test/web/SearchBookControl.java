package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class SearchBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = "result/searchOutput.jsp";

		String bookCode = request.getParameter("bookCode");
		String job = request.getParameter("job");

		// 조회 도서코드가 없을 경우 결과를 보여주는 페이지 지정.
		if (job.equals("search")) {
			path = "view/search.jsp";
		} else if (job.equals("modify")) {
			path = "view/modify.jsp";
		} else if (job.equals("remove")) {
			path = "view/remove.jsp";
		}

		if (bookCode.isBlank()) {
			request.setAttribute("error", "도서코드를 입력하세요.");
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
		BookService service = new BookService();
		BookVO book =service.findBook(bookCode);
		
		if(book==null) {
			request.setAttribute("result","조회된 결과가 없습니다");
		}
		request.setAttribute("book", book);

		// 정상적인 처리가 진행될 경우 페이지 지정.
		if (job.equals("search")) {
			path = "result/searchOutput.jsp";
		}

		request.getRequestDispatcher(path).forward(request, response);

	}

}
