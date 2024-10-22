package guia06.tp.Session01.Supermercado;

import java.util.ArrayDeque;
import java.util.Queue;

public class Cajero {
    private Queue<Cliente> filaClientes = new ArrayDeque<Cliente>();
    // add y peek
    private double totalVentas;

    public Cajero() {

    }

    public void CobrarClientes() {
        System.out.println("El cajero está atendiendo la cola...");
        int totalCajero = 0;
        for (Cliente c : this.filaClientes) {
            System.out.println(String.format("El cliente %s está siendo atendido", c.getNombreCliente()));
            int totalCliente = 0;
            for (Producto p : c.getProductos()) {
                totalCliente += p.getPrecio();
                System.out.println(
                        String.format("Se registró el producto %s con precio %d.", p.getNombre(), p.getPrecio()));
            }
            totalCajero += totalCliente;
        }
        this.totalVentas = totalCajero;

    }

    public Queue<Cliente> getFilaClientes() {
        return filaClientes;
    }

    public void setFilaClientes(Queue<Cliente> filaClientes) {
        this.filaClientes = filaClientes;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

}
