package paquete03;

public class Barrio {
    //Atributos
    private String nombreBarrio;
    private String referenciaBarrio;
    //Constructores
    public Barrio() {
    }

    public Barrio(String nombreBarrio, String referenciaBarrio) {
        this.nombreBarrio = nombreBarrio;
        this.referenciaBarrio = referenciaBarrio;
    }
    //Metodos SET y GET
    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public void setReferenciaBarrio(String referenciaBarrio) {
        this.referenciaBarrio = referenciaBarrio;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public String getReferenciaBarrio() {
        return referenciaBarrio;
    }
}
