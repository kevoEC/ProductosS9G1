/**
 * Clase que representa un Producto con un nombre y un precio.
 */
public class Producto {

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Precio del producto.
     */
    private double precio;

    /**
     * Constructor de la clase Producto.
     * 
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     */
    public Producto(final String nombre, final double precio) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
        if (precio < 0) { // Usar constante para el valor 0
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return Precio del producto.
     */
    public double getPrecio() {
        return precio;
    }
}
