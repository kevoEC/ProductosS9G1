import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Clase encargada de gestionar los productos.
 */
public class GestorProductos {

  /**
   * Lista de productos gestionados.
   * Usamos CopyOnWriteArrayList para evitar problemas de concurrencia en entornos
   * multihilo.
   */
  private final List<Producto> productos = new CopyOnWriteArrayList<Producto>();

  /**
   * Agrega un producto a la lista de productos.
   *
   * @param producto Producto a agregar.
   * @throws IllegalArgumentException Si el producto es nulo.
   */
  public synchronized void agregarProducto(final Producto producto) {
    if (producto == null) {
      throw new IllegalArgumentException("El producto no puede ser nulo.");
    }
    productos.add(producto);
    System.out.println("Producto agregado exitosamente: " + producto.getNombre());
  }

  /**
   * Obtiene el total de productos en la lista.
   *
   * @return El número total de productos.
   */
  public int obtenerTotalProductos() {
    return productos.size();
  }

  /**
   * Elimina un producto de la lista por su índice.
   *
   * @param codigo Índice del producto a eliminar.
   * @throws IndexOutOfBoundsException Si el índice está fuera de rango.
   */
  public synchronized void eliminarProducto(final int codigo) {
    if (codigo < 0 || codigo >= productos.size()) {
      throw new IndexOutOfBoundsException("Índice fuera de rango: " + codigo);
    }
    Producto productoEliminado = productos.remove(codigo);
    System.out.println("Producto eliminado: " + productoEliminado.getNombre());
  }

  /**
   * Obtiene una representación en cadena de los productos en la lista.
   *
   * @return Representación en cadena de los productos.
   */
  public String listarProductos() {
    if (productos.isEmpty()) {
      return "No hay productos en la lista.";
    }
    StringBuilder sb = new StringBuilder("Productos:\n");
    for (int i = 0; i < productos.size(); i++) {
      Producto producto = productos.get(i);
      sb.append(i).append(". ").append(producto.getNombre()).append(" - $").append(producto.getPrecio()).append("\n");
    }
    return sb.toString();
  }
}
