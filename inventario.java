import java.util.ArrayList;

public class inventario {
    private static final inventario INSTANCE = new inventario();
    private ArrayList<producto> productos;

    private inventario() {
        productos = new ArrayList<>();

        productos.add(new producto("Camiseta Deportiva", 25.99, 50, "Ropa",
                "Imagenes/camiseta.jpg"));

        productos.add(new producto("Auriculares Bluetooth", 59.90, 20, "Electrónica",
                "Imagenes/auriculares.jpg"));

        productos.add(new producto("Mouse Gamer", 39.50, 35, "Accesorios",
                "Imagenes/mouse.jpeg")); // ⚠ revisá si tu archivo se llama mouse.jpeg o mouse.jpg

        productos.add(new producto("Botella Térmica", 15.75, 80, "Hogar",
                "Imagenes/botella.jpg"));

        productos.add(new producto("Teclado Mecánico", 79.99, 15, "Electrónica",
                "Imagenes/teclado.jpg"));

        productos.add(new producto("Zapatillas Running", 89.00, 25, "Calzado",
                "Imagenes/zapatillas.jpg"));

        productos.add(new producto("Mochila Escolar", 32.40, 40, "Accesorios",
                "Imagenes/mochila.jpg"));

        productos.add(new producto("Lámpara LED", 18.99, 60, "Hogar",
                "Imagenes/lampara.jpg"));

        productos.add(new producto("Smartwatch", 120.00, 10, "Tecnología",
                "Imagenes/smartwatch.jpg"));

        productos.add(new producto("Cargador USB-C", 12.50, 100, "Electrónica",
                "Imagenes/cargador.jpg"));
    }

    public static inventario getInstance() {
        return INSTANCE;
    }

    public void mostrarProductos() {
        for (producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void buscarProducto(String nombre) {
        for (producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                System.out.println(producto);
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }

    public void agregar_producto(producto producto) {
        productos.add(producto);
    }

    public int mostrar_cantidad() {
        return productos.size();
    }

    public ArrayList<producto> getProductos() {
        return productos;
    }

    public producto getProductoPorId(int id) {
        for (producto p : productos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public boolean borrarProductoPorId(int id) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarProducto(int id, String nombre, double precio, int stock,
                                      String categoria, String urlImagen) {
        producto p = getProductoPorId(id);
        if (p == null) return false;
        if (nombre != null) p.setNombre(nombre);
        p.setPrecio(precio);
        p.setStock(stock);
        if (categoria != null) p.setCategoria(categoria);
        p.setURL_imagen(urlImagen);
        return true;
    }
}
