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

import SchoolManagement.Priciple;

@WebServlet("/register")
public class PrincipleRigester extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String mobileno=req.getParameter("mobileno");
		String email=req.getParameter("emailid");
		String password=req.getParameter("password");
		
		long mobilenumber=Long.parseLong(mobileno);
		int age1=Integer.parseInt(age);	
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Priciple p= new Priciple();
		
		p.setName(name);
	    p.setAge(age1);
	    p.setMobileno(mobilenumber);
	    p.setEmailid(email);
	    p.setPassword(password);
	    
	    et.begin();
	    em.persist(p);
	    et.commit();
	    
	 
	    
	    RequestDispatcher rd= req.getRequestDispatcher("Login.html");
	    rd.forward(req, resp);
		
	}
}
