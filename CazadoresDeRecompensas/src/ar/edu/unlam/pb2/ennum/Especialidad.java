package ar.edu.unlam.pb2.ennum;

public enum Especialidad {
    ENTORNO_CIVIL("Entornos civiles"),
    ENTORNO_AGRESTRE("Zonas agrestes"),
    ENTORNO_DISCRETO("Capturas discretas");

    private String descripcion;

    private Especialidad(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
