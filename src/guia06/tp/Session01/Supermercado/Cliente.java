package guia06.tp.Session01.Supermercado;

import java.util.ArrayList;

public class Cliente {
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private String nombreCliente = "";
    private double valorCarrito;

    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void calcularValorCarrito() {
        int total = 0;
        for (Producto i : this.productos) {
            total += i.getPrecio();
        }
        this.valorCarrito = total;
    }

    public void agregarProducto(Producto nuevoProducto) {
        this.productos.add(nuevoProducto);
        System.out.println(String.format("Se ha añadido el producto %s al carrito", nuevoProducto.getNombre()));
        this.calcularValorCarrito();
        System.out.println(String.format("El valor actual del carrito es: %d", this.valorCarrito));
    }

    public double getValorCarrito() {
        return valorCarrito;
    }

    public void setValorCarrito(double valorCarrito) {
        this.valorCarrito = valorCarrito;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

}
