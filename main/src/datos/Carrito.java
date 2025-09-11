package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int idCarrito;
    private LocalDate fecha;
    private LocalTime hora;
    private List<ItemCarrito> lstItem;
    private Cliente cliente;

    public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
        this.idCarrito = idCarrito;
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        lstItem = new ArrayList<>();
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public List<ItemCarrito> getLstItem() {
        return lstItem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "idCarrito=" + idCarrito +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", lstItems=" + lstItem +
                ", cliente=" + cliente +
                '}';
    }

    public boolean equals(Carrito c) {
        return c.idCarrito == idCarrito &&
                c.hora.equals(hora) &&
                c.fecha.equals(fecha) &&
                c.cliente.equals(cliente) &&
                c.lstItem.equals(lstItem);
    }

    private ItemCarrito traerItem(Producto producto) {
        ItemCarrito retornoItem = null;
        int i = 0;
        while (i < lstItem.size() && retornoItem == null) {
            if (lstItem.get(i).getProducto().equals(producto)) {
                retornoItem = lstItem.get(i);
            }
            i++;
        }
        return retornoItem;
    }

    public boolean agregarItem(Producto producto, int cantidad) {
        boolean bandera = false;
        if (traerItem(producto) != null) {
            traerItem(producto).sumarCantidad(cantidad);
            bandera = true;
        } else {
            int id = 1;
            if (!lstItem.isEmpty()) {
                id = lstItem.get(lstItem.size() - 1).getIdItem() + 1;
            }
            bandera = lstItem.add(new ItemCarrito(id, producto, cantidad));
        }
        return bandera;
    }

    public boolean eliminarItem(Producto producto, int cantidad) {
        boolean bandera = false;
        if (traerItem(producto) != null) {
            ItemCarrito item = traerItem(producto);
            item.restarCantidad(cantidad);
            if (item.getCantidad() < 1) {
                lstItem.remove(item);
            }
            bandera = true;
        }
        return bandera;
    }

    public float calcularTotal() {
        float total = 0f;
        for(ItemCarrito item : lstItem) {
            total += item.calcularSubTotal();
        }
        return total;
    }
}
