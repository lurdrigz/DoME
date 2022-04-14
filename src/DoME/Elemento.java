package DoME;

public class Elemento {
    private String titulo;
    private int duracion; // min
    private int loTengo; // 1: lo tengo 0: no lo tengo
    //private String comentario;


    public Elemento(String titulo, int duracion, int loTengo) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.loTengo = loTengo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getLoTengo() {
        return loTengo;
    }

    public void setLoTengo(int loTengo) {
        this.loTengo = loTengo;
    }

    /*
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

     */
}


