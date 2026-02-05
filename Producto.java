public class Producto {
    // Atributos privados [cite: 20, 41, 42]
    private String descripcion;
    private String codigo;
    private String tipo;
    private Double costo;
    private Double impuesto;

    // Métodos Get (Accesores) [cite: 22, 43-47]
    public String getDescripcion() { return descripcion; }
    public String getCodigo() { return codigo; }
    public String getTipo() { return tipo; }
    public Double getCosto() { return costo; }
    public Double getImpuesto() { return impuesto; }

    // Métodos Set (Establecedores) [cite: 22, 48-52]
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCosto(Double costo) { this.costo = costo; }
    public void setImpuesto(Double impuesto) { this.impuesto = impuesto; }

    // Método para mostrar información [cite: 53-60]
    public void muestraProducto() {
        System.out.println("\n--- Datos del Producto ---");
        System.out.println("Código: " + codigo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Tipo: " + tipo);
        System.out.println("Costo base: $" + costo);
        System.out.println("Impuesto: " + impuesto + "%");
    }

    // Método funcional para calcular precio de venta [cite: 23, 61-70]
    public double calcularPrecio(double utilidad) {
        // 1. Sumar utilidad al costo [cite: 24, 65]
        double precioConUtilidad = costo + (costo * (utilidad / 100));
        // 2. Sumar impuesto al resultado anterior [cite: 25, 68]
        double precioFinal = precioConUtilidad + (precioConUtilidad * (impuesto / 100));
        return precioFinal;
    }
}