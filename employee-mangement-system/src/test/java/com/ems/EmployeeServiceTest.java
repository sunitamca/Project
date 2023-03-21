package com.ems;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ems.config.HibernateUtil;
import com.ems.exception.GlobalException;
import com.ems.service.EmployeeService;
import com.ems.servicelmpt.EmployeeServiceImpl;

	
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	class EmployeeServiceTest {
		EmployeeService empService = new EmployeeServiceImpl();
		
		private static SessionFactory sessionFactory;
		private Session session;

		@BeforeAll
		static void setUpBeforeClass() throws Exception {
			sessionFactory = HibernateUtil.getSessionFactory();
		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
			if(sessionFactory!=null) {
				sessionFactory.close();
				System.out.println("Session Factory Closed...");
			}
		}

		@BeforeEach
		void setUp() throws Exception {
			session = sessionFactory.openSession();
		}

		@AfterEach
		void tearDown() throws Exception {
			if(session!=null) {
				session.close();
				System.out.println("Session Closed...");
			}
		}
		@Test
		@DisplayName("Testing Delete Emp By ID")
	//	@Order(4)
		void testDeleteEmpById() {
			empService.deleteEmployeeById(3);
			assertThrows(GlobalException.class, ()-> empService.getEmployeeUsingId(3));
		
		
	}

}
