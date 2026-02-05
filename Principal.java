import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Registro de productos [cite: 77, 78]
        Producto p1 = capturarDatos(sc, "Producto 1");
        Producto p2 = capturarDatos(sc, "Producto 2");

        // Mostrar datos [cite: 82-85]
        System.out.println("\nRESUMEN DE PRODUCTOS: ");
        p1.muestraProducto();
        p2.muestraProducto();

        // Comparación [cite: 86-88]
        String masCaro = compararProductos(p1, p2);
        System.out.println("\nRESULTADO DE COMPARACIÓN: ");
        System.out.println("El producto con mayor precio de venta es: " + masCaro);
        
        sc.close();
    }

    // Método para capturar datos con manejo de errores try-catch [cite: 89-113]
    public static Producto capturarDatos(Scanner sc, String nombre) {
        Producto p = new Producto();
        boolean datosValidos = false;

        while (!datosValidos) {
            try {
                System.out.println("\nIngresando datos para " + nombre);
                System.out.print("Descripción: ");
                p.setDescripcion(sc.nextLine());
                System.out.print("Código: ");
                p.setCodigo(sc.nextLine());
                System.out.print("Tipo: ");
                p.setTipo(sc.nextLine());
                System.out.print("Costo (ej. 100.0): ");
                p.setCosto(Double.parseDouble(sc.nextLine()));
                System.out.print("Impuesto (ej. 16.0): ");
                p.setImpuesto(Double.parseDouble(sc.nextLine()));
                
                datosValidos = true; // Si llega aquí, los datos son correctos [cite: 105]
            } catch (NumberFormatException e) {
                System.out.println("ERROR: El costo y el impuesto deben ser valores numéricos. Intente de nuevo."); [cite: 108, 109]
            }
        }
        return p;
    }

    // Método estático para comparar precios [cite: 32, 115-125]
    public static String compararProductos(Producto a, Producto b) {
        double utilidadPrueba = 20.0; // Valor definido para la comparación [cite: 116]
        double precioA = a.calcularPrecio(utilidadPrueba);
        double precioB = b.calcularPrecio(utilidadPrueba);

        if (precioA > precioB) {
            return a.getDescripcion() + " ($" + String.format("%.2f", precioA) + ")"; [cite: 120]
        } else if (precioB > precioA) {
            return b.getDescripcion() + " ($" + String.format("%.2f", precioB) + ")"; [cite: 121]
        } else {
            return "Ambos tienen el mismo precio."; [cite: 123]
        }
    }
}