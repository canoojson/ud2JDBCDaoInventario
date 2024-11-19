package Interfaz;

import java.util.Scanner;

import Dao.DaoDepartamento;
import jdbc.ConexionJdbc;

public class Borrar_departamento {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoDepartamento daoDepartamento=null;
		int iddept =0;
		Scanner tec= new Scanner(System.in);
		
		try {
			conJdbc=new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			
			System.out.println("Id del departamento a borrar: ");
			iddept=tec.nextInt();
			daoDepartamento= new DaoDepartamento();
			daoDepartamento.borrar(iddept);
			System.out.println("Se ha borrado correctamente");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
