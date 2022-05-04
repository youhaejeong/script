package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberSearchControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String job = request.getParameter("job"); // 용도 구분 용 

		String path = "";
		if (job.equals("search")) {
			path = "memberView/memberSearch.jsp";
		} else if (job.equals("update")) {
			path = "memberView/memberUpdate.jsp";
		} else if (job.equals("delete")) {
			path = "memberView/memberDelete.jsp";
		}

		if (id.isEmpty()) { // isEmpty() ~가 없으면
			request.setAttribute("error", "아이디를 입력하세요");
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
		MemberService service = new MemberService();
		MemberVO member = service.memberSearch(id);

		if (member == null) {
			request.setAttribute("result", "조회된 결과가 없습니다.");
		}
		request.setAttribute("member", member);

		if (job.equals("search")) {
			path = "memberResult/memberSearchOutput.jsp";
		}

		request.getRequestDispatcher(path).forward(request, response);

	}// end of execute

}
