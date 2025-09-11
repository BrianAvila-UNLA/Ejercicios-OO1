package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private List<Carrito> lstCarrito;
    private List<Cliente> lstCliente;
    private List<Producto> lstProducto;

    public Supermercado() {
        lstCarrito = new ArrayList<>();
        lstCliente = new ArrayList<>();
        lstProducto = new ArrayList<>();
    }

    public List<Carrito> getLstCarrito() {
        return lstCarrito;
    }

    public List<Cliente> getLstCliente() {
        return lstCliente;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public Producto traerProducto(int idProducto) {
        Producto retornoProducto = null;
        int i = 0;
        while (i < lstProducto.size() && retornoProducto == null) {
            if (lstProducto.get(i).getIdProducto() == idProducto) {
                retornoProducto = lstProducto.get(i);
            }
            i++;
        }
        return retornoProducto;
    }

    public boolean agregarProducto(String producto, float precio) {
        int id = 1;
        if (!lstProducto.isEmpty()) {
            id = lstProducto.get(lstProducto.size() - 1).getIdProducto() + 1;
        }
        return lstProducto.add(new Producto(id, producto, precio));
    }

    public boolean eliminarProducto(int idProducto) {
        return lstProducto.remove(traerProducto(idProducto));
    }

    public Cliente traerCliente(int idCliente) {
        Cliente retornoCliente = null;
        int i = 0;
        while (i < lstCliente.size() && retornoCliente == null) {
            if (lstCliente.get(i).getIdCliente() == idCliente) {
                retornoCliente = lstCliente.get(i);
            }
            i++;
        }
        return retornoCliente;
    }

    private Cliente traerCliente(long dni) {
        Cliente retornoCliente = null;
        int i = 0;
        while (i < lstCliente.size() && retornoCliente == null) {
            if (lstCliente.get(i).getDni() == dni) {
                retornoCliente = lstCliente.get(i);
            }
            i++;
        }
        return retornoCliente;
    }

    public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception {
        if (traerCliente(dni) != null) {
            throw new Exception("Ya existe un cliente con dni " + dni);
        }
        int id = 1;
        if (!lstCliente.isEmpty()) {
            id = lstCliente.get(lstCliente.size() - 1).getIdCliente() + 1;
        }
        return lstCliente.add(new Cliente(id, cliente, direccion, dni));
    }

    public boolean eliminarCliente(int idCliente) throws Exception {
        if (traerCliente(idCliente) == null) {
            throw new Exception("No existe un cliente con id " + idCliente);
        }
        return lstCliente.remove(traerCliente(idCliente));
    }

    public Carrito traerCarrito(int idCarrito) {
        Carrito retornoCarrito = null;
        int i = 0;
        while (i < lstCarrito.size() && retornoCarrito == null) {
            if (lstCarrito.get(i).getIdCarrito() == idCarrito) {
                retornoCarrito = lstCarrito.get(i);
            }
            i++;
        }
        return retornoCarrito;
    }

    private Carrito traerCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) {
        Carrito retornoCarrito = null;
        List<Carrito> carritosDeCliente = traerCarritos(cliente);
        int i = 0;
        while (i < carritosDeCliente.size() && retornoCarrito == null) {
            if (carritosDeCliente.get(i).getHora().equals(hora) && carritosDeCliente.get(i).getFecha().equals(fecha)) {
                retornoCarrito = carritosDeCliente.get(i);
            }
            i++;
        }
        return retornoCarrito;
    }

    private List<Carrito> traerCarritos(Cliente cliente) {
        List<Carrito> retornoCarritos = new ArrayList<>();
        for (Carrito carrito : lstCarrito) {
            if (carrito.getCliente().equals(cliente)) {
                retornoCarritos.add(carrito);
            }
        }
        return retornoCarritos;
    }

    public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
        if (traerCarrito(fecha, hora, cliente) != null) {
            throw new Exception("Ya existe un carrito con fecha %s, hora %s y cliente %s"
                    .formatted(fecha, hora, cliente));
        }
        int id = 1;
        if (!lstCarrito.isEmpty()) {
            id = lstCarrito.get(lstCarrito.size() - 1).getIdCarrito() + 1;
        }
        return lstCarrito.add(new Carrito(id, fecha, hora, cliente));
    }

    public boolean eliminarCarrito(int idCarrito) throws Exception {
        if (traerCarrito(idCarrito) == null) {
            throw new Exception("No existe un carrito con id " + idCarrito);
        }
        return lstCarrito.remove(traerCarrito(idCarrito));
    }

    public float calcularTotal(Cliente cliente) throws Exception {
        if (traerCliente(cliente.getIdCliente()) == null) {
            throw new Exception("No existe un cliente con id " + cliente.getIdCliente());
        }
        float total = 0f;
        List<Carrito> carritosDeCliente = traerCarritos(cliente);
        for (Carrito carrito : carritosDeCliente) {
            total += carrito.calcularTotal();
        }
        return total;
    }

    public float calcularTotal(int dniCliente) throws Exception {
        Cliente cliente = traerCliente(dniCliente);
        return calcularTotal(cliente);
    }

    public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        float total = 0f;
        for (Carrito carrito : lstCarrito) {
            if (carrito.getFecha().isBefore(fechaFin) && carrito.getFecha().isAfter(fechaInicio)) {
                total += carrito.calcularTotal();
            }
        }
        return total;
    }

    public float calcularTotal(LocalDate fechaInicio) {
        float total = 0f;
        for (Carrito carrito : lstCarrito) {
            if (carrito.getFecha().isAfter(fechaInicio)) {
                total += carrito.calcularTotal();
            }
        }
        return total;
    }

    public float calcularTotal(int mes, int anio) throws Exception {
        if (mes > Month.values().length) {
            throw new Exception("Mes inválido. No existe el mes " + mes);
        }
        float total = 0f;
        for (Carrito carrito : lstCarrito) {
            if (carrito.getFecha().getMonthValue() == mes && carrito.getFecha().getYear() == anio) {
                total += carrito.calcularTotal();
            }
        }
        return total;
    }

    public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {
        if (traerCliente(cliente.getIdCliente()) == null) {
            throw new Exception("No existe el cliente con id " + cliente.getIdCliente());
        }
        float total = 0f;
        for (Carrito carrito : traerCarritos(cliente)) {
            if (carrito.getFecha().isBefore(fechaFin) && carrito.getFecha().isAfter(fechaInicio)) {
                total += carrito.calcularTotal();
            }
        }
        return total;
    }

    public float calcularTotal(LocalDate fecha, Cliente cliente) throws Exception {
        if (traerCliente(cliente.getIdCliente()) == null) {
            throw new Exception("No existe el cliente con id " + cliente.getIdCliente());
        }
        float total = 0f;
        for (Carrito carrito : traerCarritos(cliente)) {
            if (carrito.getFecha().equals(fecha)) {
                total += carrito.calcularTotal();
            }
        }
        return total;
    }

    public float calcularTotal(int mes, int anio, Cliente cliente) throws Exception {
        if (traerCliente(cliente.getIdCliente()) == null) {
            throw new Exception("No existe el cliente con id " + cliente.getIdCliente());
        }
        if (mes > Month.values().length) {
            throw new Exception("Mes inválido. No existe el mes " + mes);
        }
        float total = 0f;
        for (Carrito carrito : traerCarritos(cliente)) {
            if (carrito.getFecha().getMonthValue() == mes && carrito.getFecha().getYear() == anio) {
                total += carrito.calcularTotal();
            }
        }
        return total;
    }

    public float calcularTotal(int mes, int anio, int dniCliente) throws Exception {
        Cliente cliente = traerCliente(dniCliente);
        if (traerCliente(cliente.getIdCliente()) == null) {
            throw new Exception("No existe el cliente con id " + cliente.getIdCliente());
        }
        return calcularTotal(mes, anio, cliente);
    }
}
