import java.util.List;
import java.util.ArrayList;

public class gestorProductos { // Violación: El nombre de la clase debería ser GestorProductos

  private List<Producto> productos = new ArrayList<Producto>(); // Violación: Línea demasiado larga

  public void agregarproducto(Producto producto) { // Violación: El método debería ser agregarProducto
    if (producto == null) { // Violación: Indentación incorrecta (debería estar con 4 espacios)
      System.out.println("Producto nulo no puede ser agregado.");
      return; // Violación: Falta un comentario explicativo
    }
    productos.add(producto);
  }

  public int obtenerTotalProductos() {
    return productos.size();
  }

  public void eliminarProducto (int codigo) { // Violación: Espacio innecesario antes del paréntesis
    if (codigo < 0 || codigo >= productos.size()) { // Violación: Número mágico, 0 debería ser una constante
      System.out.println("Índice fuera de rango.");
      return;
    }
    productos.remove(codigo);
  }
}
