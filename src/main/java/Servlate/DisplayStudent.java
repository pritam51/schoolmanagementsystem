package Servlate;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SchoolManagement.Student;
import SchoolManagement.Techer;

@WebServlet("/displaystudent")
public class DisplayStudent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select a from Student a");
		List<Student>s=q.getResultList();
		
		HttpSession hs=req.getSession();
		hs.setAttribute("students", s);
		
		RequestDispatcher rd=req.getRequestDispatcher("DisplayStudent.jsp");
		rd.forward(req, resp);
	}

}
