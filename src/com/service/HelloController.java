package com.service;

import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pojo.Employee;

@SuppressWarnings("deprecation")
@Controller
public class HelloController {

	@RequestMapping("/")
	public String display() {
		System.out.println("inside index");
		return "index";
	}

	@RequestMapping("/home")
	public String redirect(@RequestParam("usrName") String name, Model m) {
		System.out.println("inside home controller " + name);

		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		Employee employee = (Employee) factory.getBean("userName");

		employee.printData();

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Employee e = (Employee) context.getBean("userName2");

		e.printData();

		ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");

		Employee emp = (Employee) a.getBean("emp");

		emp.showData();

		m.addAttribute("name", name);
		return "home";
	}

	@RequestMapping("/addEmployee")
	public String insertEmpData(@RequestParam("empID") int empId, @RequestParam("empName") String eName, Model m)
			throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException,
			SystemException {

		System.out.println(empId + " & " + eName);
		Integer a = null;

		try {
			// Configuration cfg = new Configuration();
			//
			// cfg.configure("hibernate.cfg.xml");
			//
			// SessionFactory factory = cfg.buildSessionFactory();
			// Session session = factory.openSession();

			SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

			Session session = factory.openSession();

			org.hibernate.Transaction t = session.beginTransaction();

			Employee e = new Employee();

			e.setUserName(eName);
			// e.setId(empId);

			a = (int) session.save(e);
			System.out.println("valuee in a is " + a);
			try {
				t.commit();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// StandardServiceRegistry ssr = new
		// StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		// Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		//
		// SessionFactory sf = meta.getSessionFactoryBuilder().build();
		//
		// Session s = sf.openSession();
		//
		// Transaction t = (Transaction) s.beginTransaction();
		//
		// Employee e = new Employee();
		//
		// e.setUserName(eName);
		// e.setId(empId);
		//
		// s.save(e);
		// try {
		// t.commit();
		// } catch (SecurityException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (RollbackException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (HeuristicMixedException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (HeuristicRollbackException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (SystemException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// finally {
		// sf.close();
		// s.close();
		// }

		m.addAttribute("id", a);

		return "home";
	}

}
