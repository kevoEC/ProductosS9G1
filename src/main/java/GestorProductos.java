import java.util.List;
import java.util.ArrayList;

public class GestorProductos {

  private List<Producto> productos = new ArrayList<Producto>();

  public void agregarProducto(Producto producto) {
    if (producto == null) {
      System.out.println("Producto nulo no puede ser agregado.");
      return; // Manejo de null
    }
    productos.add(producto);
  }

  public int obtenerTotalProductos() {
    return productos.size();
  }

  public void eliminarProducto(int codigo) {
    if (codigo < 0 || codigo >= productos.size()) {
      System.out.println("Índice fuera de rango.");
      return;
    }
    productos.remove(codigo);
  }
}
