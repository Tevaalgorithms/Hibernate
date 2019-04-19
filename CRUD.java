// Creating a student in database.
//********************************

// Step 1: create session factory
SessionFactory factory = new Configuration()
	                      .configure("hibernate.cfg.xml")
	                      .addAnnotatedClass(Student.class)
	                      .buildSessionFactory();
                        
// Step 2: create session
Session session = factory.getCurrentSession();

// Step 3: create Student Object
Student tempStudent = new Student("Tevaganthan", "Velu", "veluteva@gmail.com");
			
// Step 4: start a transaction
session.beginTransaction();
			
// Step 5:  save the student object
session.save(tempStudent);
			
// Step 6: commit transaction
session.getTransaction().commit();

// Step 7: close factory
factory.close();

// Reading a student in database.
//********************************
// Step 1: create session factory
SessionFactory factory = new Configuration()
	                      .configure("hibernate.cfg.xml")
	                      .addAnnotatedClass(Student.class)
	                      .buildSessionFactory();
                        
// Step 2: create session
Session session = factory.getCurrentSession();

// Step 3: start a transaction
session.beginTransaction();

// Step 4: read student
Student myStudent = session.get(Student.class, 1);

// Step 5: commit transaction
session.getTransaction().commit();	

// Step 6: close factory
factory.close()

// Query students in database.
//****************************
// Step 1: create session factory
SessionFactory factory = new Configuration()
	                      .configure("hibernate.cfg.xml")
	                      .addAnnotatedClass(Student.class)
	                      .buildSessionFactory();
                        
// Step 2: create session
Session session = factory.getCurrentSession();

// Step 3: start a transaction
session.beginTransaction();

// Step 4:  query students
List<Student> theStudents = session.createQuery("from Student").list();
for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);

// Step 5: commit transaction
session.getTransaction().commit();	

// Step 6: close factory
factory.close()

// The following are some types of queries 
// List<Student> theStud = session.createQuery("from Student s where s.lastName='Wood'").list();
// List<Student> theStu = session.createQuery("from Student s where s.lastName='Wood' OR s.firstName='Tevaganthan'").list();
// List<Student> theSt = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();

// Updating the records in database
//**********************************

// Step 1: create session factory
SessionFactory factory = new Configuration()
	                      .configure("hibernate.cfg.xml")
	                      .addAnnotatedClass(Student.class)
	                      .buildSessionFactory();
                        
// Step 2: create session
Session session = factory.getCurrentSession();

// Step 3: start a transaction
session.beginTransaction();

// Step 4: retrieve student based on the id (2):
Student myStudent = session.get(Student.class, 2);

// Step 5: update the Student First Name
myStudent.setFirstName("TevaAwesome");
      
// Step 6: commit transaction
session.getTransaction().commit();	

// Step 6: close factory
factory.close()

//Second way of updating 
session.createQuery("update Student set email='foo@gmail.com'");
// In the above method all students get updated to the above email

// deleting the records in database
//**********************************

// Step 1: create session factory
SessionFactory factory = new Configuration()
	                      .configure("hibernate.cfg.xml")
	                      .addAnnotatedClass(Student.class)
	                      .buildSessionFactory();
                        
// Step 2: create session
Session session = factory.getCurrentSession();

// Step 3: start a transaction
session.beginTransaction();

// Step 4: retrieve student based on the id (2):
Student myStudent = session.get(Student.class, 2);

// Step 5: deleting the Student 
session.delete(myStudent);
      
// Step 6: commit transaction
session.getTransaction().commit();	

// Step 7: close factory
factory.close()

//Second way of deleting
session.createQuery("delete from Student where id=2").executeUpdate();
