package DoME;

public class DVD extends Elemento {
    private String director;

    public DVD(String titulo, String director, int duracion, int loTengo)
    {
        super(titulo, duracion, loTengo);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
