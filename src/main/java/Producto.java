/**
 * Clase Producto para representar un producto.
 */
class Producto {
  private final String nombre;
  private final double precio;

  /**
   * Constructor del producto.
   *
   * @param nombre Nombre del producto.
   * @param precio Precio del producto.
   * @throws IllegalArgumentException Si el nombre es nulo o vacío, o si el precio
   *                                  es negativo.
   */
  public Producto(String nombre, double precio) {
    if (nombre == null || nombre.trim().isEmpty()) {
      throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
    }
    if (precio < 0) {
      throw new IllegalArgumentException("El precio no puede ser negativo.");
    }
    this.nombre = nombre;
    this.precio = precio;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPrecio() {
    return precio;
  }

  @Override
  public String toString() {
    return nombre + " ($" + precio + ")";
  }
}