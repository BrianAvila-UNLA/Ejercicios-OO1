package datos;

public class Cliente {
    private int idCliente;
    private String cliente;
    private long dni;
    private String direccion;

    public Cliente(int idCliente, String cliente, String direccion, long dni) {
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.direccion = direccion;
        this.dni = dni;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", cliente='" + cliente + '\'' +
                ", dni=" + dni +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public boolean equals(Cliente c) {
        return c.idCliente == idCliente &&
                c.cliente.equals(cliente) &&
                c.dni == dni &&
                c.direccion.equals(direccion);
    }
}
