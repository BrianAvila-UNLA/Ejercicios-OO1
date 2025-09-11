package tests;

import datos.Supermercado;

import java.time.LocalDate;
import java.time.LocalTime;

public class SupermercadoTest {

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();

        supermercado.agregarProducto("Aceite de girasol", 15.5f);
        supermercado.agregarProducto("Puré de tomate", 10f);
        supermercado.agregarProducto("Papel higiénico", 19.1f);
        System.out.println("\nTras agregar productos:");
        System.out.println(supermercado.getLstProducto());

        try {
            supermercado.agregarCliente("Oscar Ruina", 1111111, "Calle falsa 123");
            supermercado.agregarCliente("Gustavo Siciliano", 2222222, "Corrientes 111");
            supermercado.agregarCliente("Oscar Ruina", 1111111, "Calle falsa 123");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nTras agregar clientes");
            System.out.println(supermercado.getLstCliente());
        }

        try {
            supermercado.agregarCarrito(LocalDate.now(), LocalTime.now(), supermercado.traerCliente(1));
            supermercado.agregarCarrito(LocalDate.of(2018, 12, 9), LocalTime.of(16, 30, 1), supermercado.traerCliente(1));
            supermercado.agregarCarrito(LocalDate.of(2018, 12, 9), LocalTime.of(16, 30, 1), supermercado.traerCliente(2));
            supermercado.agregarCarrito(LocalDate.of(2018, 12, 9), LocalTime.of(16, 30, 1), supermercado.traerCliente(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nTras agregar carritos:");
            System.out.println(supermercado.getLstCarrito());
        }

        try {
            supermercado.eliminarCarrito(3);
            supermercado.eliminarCarrito(9999999);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nTras eliminar carritos:");
            System.out.println(supermercado.getLstCarrito());
        }

        try {
            supermercado.eliminarCliente(2);
            supermercado.eliminarCliente(9999999);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nTras eliminar clientes:");
            System.out.println(supermercado.getLstCliente());
        }

        supermercado.traerCarrito(1).agregarItem(supermercado.traerProducto(1), 10);
        supermercado.traerCarrito(1).agregarItem(supermercado.traerProducto(2), 2);
        supermercado.traerCarrito(2).agregarItem(supermercado.traerProducto(1), 1);

        try {
            System.out.println("\nTotal Cliente 1: " + supermercado.calcularTotal(supermercado.traerCliente(1)));
            System.out.println("Total Cliente 2: " + supermercado.calcularTotal(supermercado.traerCliente(2)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("\nTotal Cliente con dni 111111111: " + supermercado.calcularTotal(1111111));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
