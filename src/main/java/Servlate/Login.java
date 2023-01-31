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

import SchoolManagement.Priciple;

@WebServlet("/from")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String email=req.getParameter("emailid");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select p from Priciple p where p.emailid=?1 and password=?2");
		
		q.setParameter(1,  email);
		q.setParameter(2, password);
		
		List<Priciple> p=q.getResultList();
		
		
		if(p.size()>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("Secondpage.html");
			rd.forward(req, resp);
		}
		
		else {
			RequestDispatcher rd=req.getRequestDispatcher("loginprinciple.html");
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
