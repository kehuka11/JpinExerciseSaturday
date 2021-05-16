package com.sample;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TaskSign
 */
@WebServlet("/tasksign")
public class TaskSign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskSign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/task_sign.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String regname = request.getParameter("regname");
		String contents = request.getParameter("contents");
		String date = request.getParameter("date");
		String chargename=request.getParameter("chargename");
		String bikou=request.getParameter("bikou");
		
		
		//request.setAttribute("msg", msg);
		HttpSession session = request.getSession();
		Map<Integer,Todo> map = (Map<Integer,Todo>) session.getAttribute("map");
		
		if(map == null) {
			map = new TreeMap<Integer,Todo>();
		}
		
		Integer id = (Integer) session.getAttribute("id");
		if (id==null) {
			id=0;
		}else {
			id+=1;
		}

		/*SimpleDateFormat d = new SimpleDateFormat(date);
		
			try {
				Date deadline = d.parse(date);
				
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}*/
		
		Todo todo = new Todo(id  ,regname,contents,date,chargename,bikou);
		map.put(id, todo);
		
		session.setAttribute("map", map);
		session.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/task_list.jsp");
		rd.forward(request, response);
		return;
	}

}
