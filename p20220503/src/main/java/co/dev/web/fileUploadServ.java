package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUploadServlet")
public class fileUploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public fileUploadServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title: " + title + ", content: " + content);
		// getRealPath 실제 위치를 가져오겠습니다
		// multipart 요청
		// 5가지 넣어야함
		// request , 저장 위치 , maxsize파일의 최대크기. 인코딩방식 , 리네임정책
		// 리네임정책 ->file.jpg, file1.jpg 똑같은 이름이 있으면 다르게 바꿔줌(ex 1을 붙여서 저장

		String saveDir = "upload";
		saveDir = getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10;// 최대 크기를 10메가로하겠습니다.
		String encoding = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
				new DefaultFileRenamePolicy());
		title = multi.getParameter("title");
		content = multi.getParameter("content");
		String profile = multi.getOriginalFileName("profile"); // 최초 업로드시 정해지는 이름
		String fileName = multi.getFilesystemName("profile"); // 리네임정책에 의해 정해진 이름
		System.out
				.println("title: " + title + ", content: " + content + ", profile: " + profile + ", file: " + fileName);
	}

}
