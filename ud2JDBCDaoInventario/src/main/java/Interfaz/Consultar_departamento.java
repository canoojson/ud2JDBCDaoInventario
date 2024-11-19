package Interfaz;

import java.util.Scanner;

import Dao.DaoDepartamento;
import Pojos.Departamento;
import jdbc.ConexionJdbc;

public class Consultar_departamento {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoDepartamento daoDepartamento=null;
		Departamento d = new Departamento();
		int iddept =0;
		Scanner tec= new Scanner(System.in);
		
		try {
			conJdbc=new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			
			System.out.println("Id del departamento a consultar: ");
			iddept=tec.nextInt();
			tec.nextLine();
			daoDepartamento= new DaoDepartamento();
			d=daoDepartamento.buscarPorId(iddept);
			System.out.println(d.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
