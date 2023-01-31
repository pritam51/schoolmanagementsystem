package Servlate;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SchoolManagement.Techer;

@WebServlet("/delete")
public class DeletTecher extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		
		int id1=Integer.parseInt(id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Techer t=em.find(Techer.class, id1);
		
		et.begin();
		em.remove(t);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
		
	}

}
