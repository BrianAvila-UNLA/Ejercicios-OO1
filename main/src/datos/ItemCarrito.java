package datos;

public class ItemCarrito {
    private int idItem;
    private Producto producto;
    private int cantidad;

    public ItemCarrito(int idItem, Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.idItem = idItem;
    }

    public int getIdItem() {
        return idItem;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        } else {
            this.cantidad = 0;
        }
    }

    @Override
    public String toString() {
        return "ItemCarrito{" +
                "idItem=" + idItem +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }

    public boolean equals(ItemCarrito i) {
        return i.idItem == idItem &&
                i.producto.equals(producto) &&
                i.cantidad == cantidad;
    }

    public void sumarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void restarCantidad(int cantidad) {
        setCantidad(this.cantidad - cantidad);
    }

    public float calcularSubTotal() {
        return producto.getPrecio() * cantidad;
    }
}
