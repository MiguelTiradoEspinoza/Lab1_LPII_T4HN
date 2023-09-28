package Views;

import controllers.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {

		EmpleadoController empleadoController = new EmpleadoController();

		// CREAMOS UN EMPLEADO
		String empleadoCreado = empleadoController.createEmpleado("Tirado Espinoza", "Miguel Antonio", 31, "Masculino",
				5000);
		System.out.println(empleadoCreado);

		// BUSCAMOS EL EMPLEADO

		String getEmpleado = empleadoController.getEmpleado(1);
		System.out.println(getEmpleado);

		// ACTUALIZAMOS EL EMPLEADO
		String empleadoActualizado = empleadoController.updateEmpleado(1, "Tirado", "Miguel", 32, "Masculino", 8999);
		System.out.println(empleadoActualizado);

		// ELIMINAMOS UN EMPLEADO

		String empleadoEliminado = empleadoController.deleteEmpleado(1);
		System.out.println(empleadoEliminado);

	}
}