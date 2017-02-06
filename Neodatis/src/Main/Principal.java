package Main;


import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import neodatis.Articulos;
import neodatis.Clientes;
import neodatis.Ventas;

public class Principal {

	public static void main(String[] args) {
		createBD();
                selectBD();
                updateBD();
                deleteBD();
	}

	/////////////////////////////////////////
	public static void createBD() {
		// creación de registros en la BD
		File fichero = new File("BD/ARTICVENTAS.BD");
		if (fichero.delete())
			System.out.println("BD Borrada");
		ODB odb = ODBFactory.open("BD/ARTICVENTAS.BD");
		// creo los artículos
		Articulos ar1 = new Articulos(1, "Mesas", 30, (float) 100.5);
		Articulos ar2 = new Articulos(2, "Pupitres", 10, (float) 150.7);
		Articulos ar3 = new Articulos(3, "Cuadernos", 100, (float) 4.5);
		Articulos ar4 = new Articulos(4, "Tabletas", 10, (float) 175.4);
		Articulos ar5 = new Articulos(5, "Boligrafos", 100, (float) 3.5);
		Articulos ar6 = new Articulos(6, "Lapiceros", 300, (float) 2.5);
		Articulos ar7 = new Articulos(7, "Sillas", 30, (float) 120.5);
		Articulos ar8 = new Articulos(8, "Portatil", 25, (float) 400.5);

		Articulos ar9 = new Articulos(9, "Espejo ba?o", 20, (float) 100.5);
		Articulos ar10 = new Articulos(10, "Reloj cocina", 10, (float) 20.7);
		Articulos ar11 = new Articulos(11, "Tarjetero", 50, (float) 14.5);
		Articulos ar12 = new Articulos(12, "Estuches", 110, (float) 20.4);
		Articulos ar13 = new Articulos(13, "Libro BD", 10, (float) 23.5);
		Articulos ar14 = new Articulos(14, "Tijeras", 30, (float) 5.0);
		Articulos ar15 = new Articulos(15, "Cubiertos", 130, (float) 10.5);
		Articulos ar16 = new Articulos(16, "Teclado", 25, (float) 40.5);

		// Almacenamos articulos: 16 articulos
		odb.store(ar1);
		odb.store(ar2);
		odb.store(ar3);
		odb.store(ar4);
		odb.store(ar5);
		odb.store(ar6);
		odb.store(ar7);
		odb.store(ar8);
		odb.store(ar9);
		odb.store(ar10);
		odb.store(ar11);
		odb.store(ar12);
		odb.store(ar13);
		odb.store(ar14);
		odb.store(ar15);
		odb.store(ar16);

		// Creo los Clientes 12 clientes, num, nom, pob

		Clientes cli1 = new Clientes(1, "Antonio Ruiz", "Talavera");
		Clientes cli2 = new Clientes(2, "La Alameda S.L.", "Talavera");
		Clientes cli3 = new Clientes(3, "Los molinos CB", "Madrid");
		Clientes cli4 = new Clientes(4, "Pedro Moron S.L.", "Talavera");
		Clientes cli5 = new Clientes(5, "Azulejos Mart?n S.L.", "Talavera");
		Clientes cli6 = new Clientes(6, "Bar Girasol", "Oropesa");
                
		Clientes cli7 = new Clientes(7, "Escuela Mayores", "Talavera");
		Clientes cli8 = new Clientes(8, "Galeria Madrid S.L.", "Madrid");
		Clientes cli9 = new Clientes(9, "El corte Chino", "Talavera");
		Clientes cli10 = new Clientes(10, "UNICAS S.A.", "Oropesa");
		Clientes cli11 = new Clientes(11, "Deportivo SAS", "Talavera");
		Clientes cli12 = new Clientes(12, "Academia Padel", "Madrid");

		odb.store(cli1);
		odb.store(cli2);
		odb.store(cli3);
		odb.store(cli4);
		odb.store(cli5);
		odb.store(cli6);
		odb.store(cli7);
		odb.store(cli8);
		odb.store(cli9);
		odb.store(cli10);
		odb.store(cli11);
		odb.store(cli12);

		// crear unas ventas

		// ventas para el artículo 1
		Ventas v1 = new Ventas(1, cli1, 5, "05/06/2014");
		Ventas v2 = new Ventas(2, cli2, 4, "15/06/2014");
		Ventas v3 = new Ventas(3, cli6, 3, "25/06/2014");

		Set<Ventas> vvvv = new HashSet<>();
		vvvv.add(v1);
		vvvv.add(v2);
		vvvv.add(v3);
		ar1.setCompras(vvvv);

		// ventas para el artículo 2
		Ventas v4 = new Ventas(4, cli6, 5, "03/07/2014");
		Ventas v5 = new Ventas(5, cli7, 4, "11/08/2014");

		Set<Ventas> vv2 = new HashSet<>();
		vv2.add(v4);
		vv2.add(v5);
		ar2.setCompras(vv2);
		// ventas para el artículo 3
		Ventas v6 = new Ventas(6, cli1, 3, "25/04/2014");
		Set<Ventas> vv3 = new HashSet<>();
		vv3.add(v6);
		ar3.setCompras(vv3);

		// ventas para el artículo 4
		Ventas v7 = new Ventas(7, cli10, 3, "15/03/2014");
		Ventas v8 = new Ventas(8, cli10, 4, "01/05/2014");
		Ventas v9 = new Ventas(9, cli11, 6, "25/04/2014");
		Ventas v10 = new Ventas(10, cli12, 2, "20/05/2014");
		Set<Ventas> vv4 = new HashSet<>();
		vv4.add(v7);
		vv4.add(v8);
		vv4.add(v9);
		vv4.add(v10);
		ar4.setCompras(vv4);

		// ventas para el artículo 5
		Ventas v11 = new Ventas(11, cli1, 1, "10/05/2014");
		Ventas v12 = new Ventas(12, cli7, 3, "01/06/2014");
		Ventas v13 = new Ventas(13, cli8, 6, "25/06/2014");
		Ventas v14 = new Ventas(14, cli9, 5, "10/07/2014");
		Ventas v15 = new Ventas(15, cli9, 4, "15/09/2014");
		Set<Ventas> vv5 = new HashSet<>();
		vv5.add(v11);
		vv5.add(v12);
		vv5.add(v13);
		vv5.add(v14);
		vv5.add(v15);
		ar5.setCompras(vv5);

		odb.store(v1);
		odb.store(v2);
		odb.store(v3);
		odb.store(v4);
		odb.store(v5);
		odb.store(v6);
		odb.store(v7);
		odb.store(v8);
		odb.store(v9);
		odb.store(v10);
		odb.store(v11);
		odb.store(v12);
		odb.store(v13);
		odb.store(v14);
		odb.store(v15);

		odb.store(ar1);
		odb.store(ar2);
		odb.store(ar3);
		odb.store(ar4);
		odb.store(ar5);

		odb.commit();

		odb.close();
		System.out.println("BASE DE DATOS CREADA");

	}

        public static void selectBD(){
            ODB odb = ODBFactory.open("BD/ARTICVENTAS.BD");
            System.out.println("CONSULTA SELECT TODO:");
            Objects<Clientes> clientes = odb.getObjects(Clientes.class);
            Objects<Articulos> articulos = odb.getObjects(Articulos.class);
            Objects<Ventas> ventas = odb.getObjects(Ventas.class);
            
            Clientes cliente = null;
            Articulos articulo = null;
            Ventas venta = null;
            
            while(clientes.hasNext()){
                cliente = clientes.next();
                System.out.println("CLIENTE: Nombre -> " + cliente.getNombre() + 
                        ", Población -> " + cliente.getPobla());
            }
            
            while(articulos.hasNext()){
                articulo = articulos.next();
                System.out.println("ARTÍCULO: Denominacion -> " + articulo.getDenom() + 
                        ", Precio -> " + articulo.getPvp() + ", Stock -> " + articulo.getStock());
            }
            
            while(ventas.hasNext()){
                venta = ventas.next();
                System.out.println("VENTA: Fecha -> " + venta.getFecha() + ", Univen -> " + venta.getUniven());
            }
            
            System.out.println("CONSULTA SELECT CON WHERE:");
            
            IQuery query = new CriteriaQuery(Clientes.class, Where.equal("pobla","Talavera"));
            Objects<Clientes> clientesWhere = odb.getObjects(query);
            int i = 1;
            while (clientesWhere.hasNext()) {
                System.out.println("Cliente " +  + (i++) + " Where poblacion sea Talavera: " + clientesWhere.next().getNombre());
            }
            
            odb.close();
        }

        public static void updateBD(){
            ODB odb = ODBFactory.open("BD/ARTICVENTAS.BD");
            System.out.println("CONSULTA UPDATE:");
            Objects<Clientes> clientes = odb.getObjects(Clientes.class);
            Objects<Articulos> articulos = odb.getObjects(Articulos.class);
            Objects<Ventas> ventas = odb.getObjects(Ventas.class);
            
            Clientes clienteCambiado = clientes.getFirst();
            clienteCambiado.setNombre("Antonio Ruiz CAMBIADO");
            System.out.println(clienteCambiado.getNombre());
            
            odb.store(clienteCambiado);
            odb.close();
            
            
        }

        public static void deleteBD(){
            ODB odb = ODBFactory.open("BD/ARTICVENTAS.BD");
            System.out.println("CONSULTA DELETE:");
            Objects<Clientes> clientes = odb.getObjects(Clientes.class);
            Objects<Articulos> articulos = odb.getObjects(Articulos.class);
            Objects<Ventas> ventas = odb.getObjects(Ventas.class);
            
            Clientes cliente = clientes.getFirst();
            System.out.println("Primer cliente antes de borrar: " + clientes.getFirst().getNombre());
            clientes.remove(cliente);
            System.out.println("Primer cliente después de borrar: " + clientes.getFirst().getNombre());
            odb.commit();
            odb.close();
        }
}
