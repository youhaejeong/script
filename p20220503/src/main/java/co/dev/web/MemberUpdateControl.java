package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");

		if (id.isEmpty() || name.isBlank() || passwd.isBlank() || email.isBlank()) {
			request.setAttribute("error", "모든 항목을 입력하세요");
			request.getRequestDispatcher("memberView/memberUpdate.do").forward(request, response);
			return;
		}

		MemberVO member = new MemberVO();
		member.setId(id);
		member.setName(name);
		member.setEmail(email);
		member.setPasswd(passwd);

		MemberService service = new MemberService();
		service.memberUpdate(member);

		request.setAttribute("id", id);
		//걸과 전송
		request.getRequestDispatcher("memberResult/memberUpdateOutput.jsp").forward(request, response);
		System.out.println("수정처리하는 컨드롤입니다.");

	}

}
