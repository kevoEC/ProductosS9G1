import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GestorProductosTest {

  @Test
  public void testAgregarProducto() {
    GestorProductos gestor = new GestorProductos();
    Producto producto1 = new Producto("Producto 1", 100.0);
    Producto producto2 = new Producto("Producto 2", 150.0);

    gestor.agregarProducto(producto1);
    gestor.agregarProducto(producto2);

    assertEquals(2, gestor.obtenerTotalProductos(), "Debería haber 2 productos");
  }

  @Test
  public void testEliminarProducto() {
    GestorProductos gestor = new GestorProductos();
    Producto producto1 = new Producto("Producto 1", 100.0);

    gestor.agregarProducto(producto1);
    assertEquals(1, gestor.obtenerTotalProductos(), "Debería haber 1 producto");

    gestor.eliminarProducto(0);
    assertEquals(0, gestor.obtenerTotalProductos(), "Debería haber 0 productos después de eliminar");
  }

  @Test
  public void testAgregarProductoNulo() {
    GestorProductos gestor = new GestorProductos();
    gestor.agregarProducto(null);
    assertEquals(0, gestor.obtenerTotalProductos(), "No debería agregar un producto nulo");
  }
}
