import java.util.List;
import java.util.ArrayList;

/**
 * Clase encargada de gestionar los productos.
 */
public class GestorProductos {

  /**
   * Lista de productos gestionados.
   */
  private List<Producto> productos = new ArrayList<Producto>(); // Posible fallo de concurrencia si se accede desde
                                                                // múltiples
  // hilos

  /**
   * Agrega un producto a la lista de productos.
   * 
   * @param producto Producto a agregar.
   */
  public void agregarProducto(final Producto producto) {
    if (producto == null) {
      System.out.println("Producto nulo no puede ser agregado.");
      return; // Si no se controla la salida de este método, se podría modificar la lista
              // innecesariamente.
    }
    productos.add(producto);

    // Potencial fallo: No comprobar si la lista ha cambiado después de agregar.
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
    final int TAMANO_LISTA = 0; // Número mágico (puede generar advertencia en SpotBugs).
    if (codigo < TAMANO_LISTA || codigo >= productos.size()) {
      System.out.println("Índice fuera de rango.");
      return; // El índice fuera de rango puede generar NullPointerException si no se
              // comprueba correctamente.
    }
    productos.remove(codigo); // Aquí hay un problema si la lista es modificada durante la ejecución de otro
                              // hilo.
  }

  /**
   * Método que no cierra correctamente el recurso (Simulando un problema de
   * recurso no cerrado)
   */
  public void metodoQueDeberiaCerrarRecurso() {
    // Creamos un recurso (simulado)
    List<String> recursos = new ArrayList<>();
    recursos.add("Recurso");

    // SpotBugs puede detectar que el recurso no es cerrado
  }

  /**
   * Método con código redundante que puede confundir
   */
  public void codigoRedundante() {
    List<Producto> listaDeProductos = new ArrayList<>();
    listaDeProductos.add(new Producto("Producto de prueba", 10.0));

    // SpotBugs podría detectar que estamos creando una nueva lista sin necesidad
    listaDeProductos = new ArrayList<>(); // Creación innecesaria de lista.
  }
}
