package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {

	public String createEmpleado(String apellido, String nombre, int edad, String sexo, double salario) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			Empleado emp = new Empleado(apellido, nombre, edad, sexo, salario);

			session.beginTransaction();
			session.persist(emp);
			session.getTransaction().commit();
			sessionFactory.close();
			return "El empleado ha sido creado correctamente";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Error al crear empleado";
	}

	public String getEmpleado(int idEmpleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Empleado emp = session.get(Empleado.class, idEmpleado);
			session.getTransaction().commit();
			sessionFactory.close();

			return "El empleado ha sido encontrado: " + emp.getApellido() + " " + emp.getNombre();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Error al buscar empleado";
	}

	public String deleteEmpleado(int idEmpleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Empleado emp = session.get(Empleado.class, idEmpleado);
			session.remove(emp);
			session.getTransaction().commit();
			sessionFactory.close();
			return "El empleado ha sido eliminado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al eliminar empleado";
	}

	public String updateEmpleado(int idEmpleado, String apellido, String nombre, int edad, String sexo,
			double salario) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Empleado emp = session.get(Empleado.class, idEmpleado);
			emp.setApellido(apellido);
			emp.setNombre(nombre);
			emp.setEdad(edad);
			emp.setSexo(sexo);
			emp.setSalario(salario);
			session.merge(emp);
			session.getTransaction().commit();
			sessionFactory.close();
			return "El empleado ha sido actualizado satisfactoriamente";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Error al actualizar empleado";
	}
}
