public class Producto {

  private String nombre;
  private double precio;

  public Producto(String nombre, double precio) {
    if (nombre == null || nombre.isEmpty()) {
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
}
