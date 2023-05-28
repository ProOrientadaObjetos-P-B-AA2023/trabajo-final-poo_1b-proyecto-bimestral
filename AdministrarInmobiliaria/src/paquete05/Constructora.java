package paquete05;

public class Constructora {
    //Atributos
    private String nombreConstructora;
    private String idEmpresaConstructora;
    //Constructores
    public Constructora() {
    }

    public Constructora(String nombreConstructora, String idEmpresaConstructora) {
        this.nombreConstructora = nombreConstructora;
        this.idEmpresaConstructora = idEmpresaConstructora;
    }
    //Metodos SET y GET
    public void setNombreConstructora(String nombreConstructora) {
        this.nombreConstructora = nombreConstructora;
    }

    public void setIdEmpresaConstructora(String idEmpresaConstructora) {
        this.idEmpresaConstructora = idEmpresaConstructora;
    }

    public String getNombreConstructora() {
        return nombreConstructora;
    }

    public String getIdEmpresaConstructora() {
        return idEmpresaConstructora;
    }
}
