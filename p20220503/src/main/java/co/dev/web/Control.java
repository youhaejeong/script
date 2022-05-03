package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//인터페이스에도 똑같이 예외 처리 만들어줘야 오류 안남
public interface Control {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
