package Interfaz;

import java.util.Scanner;

import Dao.DaoDepartamento;
import Pojos.Departamento;
import jdbc.ConexionJdbc;

public class Consultar_departamento_nombre {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoDepartamento daoDepartamento=null;
		Departamento d = new Departamento();
		String nomdept="";
		Scanner tec= new Scanner(System.in);
		
		try {
			conJdbc=new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			
			System.out.println("Nombre del departamento a consultar: ");
			nomdept=tec.next();
			tec.nextLine();
			daoDepartamento= new DaoDepartamento();
			d=daoDepartamento.buscarPorNombre(nomdept);
			System.out.println(d.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
