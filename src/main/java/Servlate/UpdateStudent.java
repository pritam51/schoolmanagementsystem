package Servlate;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SchoolManagement.Student;

@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 String id=req.getParameter("id");
		 String name=req.getParameter("name");
		 
		 int id1=Integer.parseInt(id);
		 
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			Student s=em.find(Student.class, id1);
			
			s.setId(id1);
			s.setName(name);
			
			et.begin();
			em.merge(s);
			et.commit();
		 
		 
		 
		 
		 
		 
	}
}

