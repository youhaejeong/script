package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertJson implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");
		MemberVO vo = null;

		boolean isMulti = ServletFileUpload.isMultipartContent(request);

		if (isMulti) { // 멀티파트 요청
			String saveDir = "upload";
			saveDir = request.getServletContext().getRealPath(saveDir);
			int maxSize = 1024 * 1024 * 10;// 최대 크기를 10메가로하겠습니다.
			String encoding = "UTF-8";
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());
			System.out.println("입력처리하는 컨트롤입니다.");

			String id = multi.getParameter("id");
			String ps = multi.getParameter("passwd");
			String nm = multi.getParameter("name");
			String em = multi.getParameter("email");
			String pf = multi.getFilesystemName("profile");

			vo = new MemberVO();
			vo.setId(id);
			vo.setName(nm);
			vo.setEmail(em);
			vo.setPasswd(ps);
			vo.setProfile(pf);

			MemberService service = new MemberService();
			service.memberInsert(vo);

		} else { // key=value&key1=value1...

			String id = request.getParameter("id");
			String ps = request.getParameter("passwd");
			String nm = request.getParameter("name");
			String em = request.getParameter("email");
			
			vo = new MemberVO();
			vo.setId(id);
			vo.setName(nm);
			vo.setEmail(em);
			vo.setPasswd(ps);

			MemberService service = new MemberService();
			service.memberInsert(vo);

		}

		// json형태의 결과 반환
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(vo));

	}

}
