package Interfaz;

import java.util.ArrayList;
import java.util.Scanner;

import Dao.DaoDepartamento;
import Dao.DaoUsuario;
import Pojos.Departamento;
import Pojos.Usuario;
import jdbc.ConexionJdbc;

public class CrearYMoverUsuariosDept {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		Departamento d = null;
		DaoDepartamento daoDepartamento = null;
		DaoUsuario daoUsuario=null;
		String nom_dept = null;
		int iddeptAntg=0;
		int iddeptNew=0;
		Scanner tec = new Scanner(System.in);
		try {
			conJdbc = new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();

			System.out.println("Nombre del nuevo departamento");
			nom_dept = tec.nextLine();

			d = new Departamento(null, nom_dept);
			daoDepartamento = new DaoDepartamento();
			daoDepartamento.grabar(d);
			iddeptNew=d.getIddepartamento();
			System.out.println("Departamento del que mover los usuarios:");
			nom_dept = tec.next();
			d= daoDepartamento.buscarPorNombre(nom_dept);
			daoUsuario = new DaoUsuario();
			iddeptAntg=d.getIddepartamento();
			daoUsuario.actualizarDep(iddeptAntg, iddeptNew);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
