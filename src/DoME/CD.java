package DoME;

public class CD extends Elemento{
    private String interprete;
    private int cdadTemas;

    public CD(String titulo, String interprete, int cdadTemas, int duracion, int loTengo)
    {
        super(titulo, duracion, loTengo);
        this.interprete = interprete;
        this.cdadTemas = cdadTemas;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public int getCdadTemas() {
        return cdadTemas;
    }

    public void setCdadTemas(int cdadTemas) {
        this.cdadTemas = cdadTemas;
    }
}
