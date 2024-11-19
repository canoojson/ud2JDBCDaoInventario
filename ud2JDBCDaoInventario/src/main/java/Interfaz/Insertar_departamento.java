package Interfaz;

import java.util.Scanner;

import Dao.DaoDepartamento;
import Pojos.Departamento;
import jdbc.ConexionJdbc;

public class Insertar_departamento {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		Departamento d = null;
		DaoDepartamento daoDepartamento=null;
		String nom_dept=null;
		Scanner tec= new Scanner(System.in);
		
		try {
			conJdbc=new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			
			System.out.println("Nombre del nuevo departamento");
			nom_dept=tec.nextLine();
			
			d=new Departamento(null,nom_dept);
			daoDepartamento= new DaoDepartamento();
			daoDepartamento.grabar(d);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
