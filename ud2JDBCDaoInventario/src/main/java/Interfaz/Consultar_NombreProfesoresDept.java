package Interfaz;

import java.util.ArrayList;
import java.util.Scanner;

import Dao.DaoDepartamento;
import Dao.DaoUsuario;
import Pojos.Departamento;
import Pojos.Usuario;
import jdbc.ConexionJdbc;

public class Consultar_NombreProfesoresDept {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		Scanner tec = new Scanner(System.in);
		DaoDepartamento daoDepartamento = null;
		DaoUsuario daoUsuario = null;

		try {
			conJdbc = new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			daoDepartamento = new DaoDepartamento();
			daoUsuario = new DaoUsuario();

			System.out.println("Nombre del departamento: ");
			String n = tec.nextLine();

			Departamento d = daoDepartamento.buscarPorNombre(n);
			
			ArrayList<Usuario> profesores= new ArrayList<Usuario>();
			
			profesores = daoUsuario.buscarPorDepartamento(d.getIddepartamento());
			
			for (int i = 0; i < profesores.size(); i++) {
				System.out.println(profesores.size());
				Usuario p = profesores.get(i);
				System.out.println("Nombre: " + p.getNombre());
				System.out.println("Apellido 1: " + p.getApellido1());
				System.out.println("Apellido 2: " + p.getApellido2());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
