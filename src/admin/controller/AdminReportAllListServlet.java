package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import qna.model.vo.Report;

/**
 * Servlet implementation class AdminReportAllList
 */
@WebServlet("/reportAllList")
public class AdminReportAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportAllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션에 로그인 유저 객체가 없다면
//		if(request.getSession().getAttribute("loginUser") == null) {
//			// 세션에 로그인 유저 객체가 없다면 에러페이지로 이동
//			request.setAttribute("msg", "올바르지 않은 요청입니다.");
//			view = "WEB-INF/views/common/errorpage.jsp";
//		} else {
//			// 비밀번호 변경 창으로 이동
//			view = "WEB-INF/views/qna/qnaReportForm.jsp";
//		}
		int ruser_no = Integer.parseInt(request.getParameter("ruser_no"));
		
		List<Report> r = null;
		
		r = new AdminService().selectReportAllList(ruser_no);
		
		request.setAttribute("reportList", r);
		
		request.getRequestDispatcher("WEB-INF/views/admin/reportAllListForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
