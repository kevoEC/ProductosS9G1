import java.util.List;
import java.util.ArrayList;

/**
 * Clase encargada de gestionar los productos.
 */
public class GestorProductos {

  /**
   * Lista de productos gestionados.
   */
  private List<Producto> productos = new ArrayList<>();

  /**
   * Agrega un producto a la lista de productos.
   * 
   * @param producto Producto a agregar.
   */
  public void agregarProducto(final Producto producto) {
    if (producto == null) {
      System.out.println("Producto nulo no puede ser agregado.");
      return; // Violación: Falta comentario explicativo
    }
    productos.add(producto);
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
   */
  public void eliminarProducto(final int codigo) {
    final int TAMANO_LISTA = 0; // Usamos constante para el índice cero
    if (codigo < TAMANO_LISTA || codigo >= productos.size()) {
      System.out.println("Índice fuera de rango.");
      return;
    }
    productos.remove(codigo);
  }
}
