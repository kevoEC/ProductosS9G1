import java.util.List;
import java.util.ArrayList;
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
  private List<Producto> productos = new CopyOnWriteArrayList<Producto>();

  /**
   * Agrega un producto a la lista de productos.
   * 
   * @param producto Producto a agregar.
   */
  public synchronized void agregarProducto(final Producto producto) {
    if (producto == null) {
      System.out.println("Producto nulo no puede ser agregado.");
      return;
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
    if (codigo < 0 || codigo >= productos.size()) {
      System.out.println("Índice fuera de rango.");
      return;
    }
    productos.remove(codigo);
  }

  /**
   * Método con un error de tipo introducido en el uso de genéricos.
   */
  public void errorDeTipo() {
    // Introducimos un error de tipo:
    List<String> listaDeStrings = new ArrayList<String>();
    listaDeStrings.add("Cadena válida");

    // Intentamos asignar la lista de strings a una lista de productos (error de
    // compilación)
    List<Producto> listaErronea = (List<Producto>) listaDeStrings; // Error de tipo


    listaErronea.add(new Producto("Producto erróneo", 20.0)); // Esto no tiene sentido
  }
}

/**
 * Clase Producto para representar un producto.
 */
class Producto {
  private String nombre;
  private double precio;

  public Producto(String nombre, double precio) {
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
