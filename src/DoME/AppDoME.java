package DoME;

public class AppDoME {

    private Elemento[] listadoElementos;
    private int validosE;
    private CD[] listadoCDs;
    private int validosCD;
    private DVD[] listadoDVDs;
    private int validosDVDs;

    public AppDoME() {
        listadoElementos = new Elemento[10];
        validosE = 0;
        listadoCDs = new CD[5];
        validosCD = 0;
        listadoDVDs = new DVD[5];
        validosDVDs = 0;
    }

    public void devolverUnElemento(String tipo, String titulo, String autoria)
    {
        if(tipo.equalsIgnoreCase("CD"))
        {
            devolverUnCD(titulo, autoria);
        }
        else if(tipo.equalsIgnoreCase("DVD"))
        {
            devolverUnDVD(titulo, autoria);
        }
    }

    public void prestarUnElemento(String tipo, String titulo, String autoria)
    {
        if(tipo.equalsIgnoreCase("CD"))
        {
            quitarUnCD(titulo, autoria);
        }
        else if(tipo.equalsIgnoreCase("DVD"))
        {
            quitarUnDVD(titulo, autoria);
        }
    }

    public void devolverUnDVD(String titulo, String director) {
        boolean encontrado = buscarDVDPorTitulo_Director(titulo, director);

        if (encontrado == true) {
            int posEncontrado = obtenerPosDVD(titulo, director);
            listadoDVDs[posEncontrado].setLoTengo(1);
        }
    }

    public void devolverUnCD(String titulo, String interprete) {
        boolean encontrado = buscarCDPorTitulo_Interprete(titulo, interprete);

        if (encontrado == true) {
            int posEncontrado = obtenerPosCD(titulo, interprete);
            listadoCDs[posEncontrado].setLoTengo(1);
        }
    }

    public void quitarUnDVD(String titulo, String director) {
        boolean encontrado = buscarDVDPorTitulo_Director(titulo, director);

        if (encontrado == true) {
            int posEncontrado = obtenerPosDVD(titulo, director);
            listadoDVDs[posEncontrado].setLoTengo(0);
        }
    }

    public void quitarUnCD(String titulo, String interprete) {
        boolean encontrado = buscarCDPorTitulo_Interprete(titulo, interprete);

        if (encontrado == true) {
            int posEncontrado = obtenerPosCD(titulo, interprete);
            listadoCDs[posEncontrado].setLoTengo(0);
        }
    }

    public void listarTodosLosDVDs() {
        int i = 0;

        while (i <= validosDVDs) {
            if (listadoDVDs[i] != null) {
                mostrarDVD(listadoDVDs[i]);
            }

            i++;
        }
    }

    public void listarDVDsDirector(String director) {
        int i = 0;

        while (i <= validosDVDs) {
            if (listadoDVDs[i] != null && listadoDVDs[i].getDirector().equals(director)) {
                mostrarDVD(listadoDVDs[i]);
            }
            i++;
        }
    }

    public void mostrarDVD(DVD datos) {
        System.out.println("Título: " + datos.getTitulo());
        System.out.println("Director: " + datos.getDirector());
        System.out.println("Duración: " + datos.getDuracion());
        if (datos.getLoTengo() == 1) {
            System.out.println("Disponible.");
        } else {
            System.out.println("No disponible.");
        }

    }

    public DVD agregarDVDs(String titulo, String director, int duracion, int loTengo) {
        DVD nuevo = null;
        boolean existencia = buscarDVDPorTitulo_Director(titulo, director);

        if (existencia == false) // si no existe
        {
            if (validosDVDs < 6) // si el arreglo no está lleno, lo agrego
            {
                int pos = buscarUltPosDVDs();
                nuevo = new DVD(titulo, director, duracion, loTengo);
                listadoDVDs[pos + 1] = nuevo;
                validosDVDs++;
            }
        }

        return nuevo;
    }

    private int buscarUltPosDVDs() {
        int pos = 0;
        while (pos < validosDVDs) {
            pos++;
        }

        return pos;
    }

    public int obtenerPosDVD(String titulo, String director) {
        int i = 0;
        int pos = -1;
        int flag = 0;

        while (i <= validosDVDs && flag == 0) {
            if (listadoDVDs[i] != null && listadoDVDs[i].getTitulo().equals(titulo) && listadoDVDs[i].getDirector().equals(director)) {
                pos = i;
                flag = 1;
            } else {
                i++;
            }
        }

        return pos; // retorna la posición del DVD buscado o -1 si no lo encontró
    }


    public boolean buscarDVDPorTitulo_Director(String titulo, String director) {
        boolean existencia = false;
        int i = 0;

        while (i <= validosDVDs) {
            if (listadoDVDs[i] != null && listadoDVDs[i].getTitulo().equals(titulo) && listadoDVDs[i].getDirector().equals(director)) {
                existencia = true;
            }
                i++;

        }

        return existencia;
    }

    public void listarTodosLosCDs() {
        int i = 0;

        while (i <= validosCD) {
            if (listadoCDs[i] != null) {
                mostrarCD(listadoCDs[i]);
            }

            i++;
        }
    }

    public void listarCDsInterprete(String interprete) {
        int i = 0;

        while (i <= validosCD) {
            if (listadoCDs[i] != null && listadoCDs[i].getInterprete().equals(interprete)) {
                mostrarCD(listadoCDs[i]);
            }
            i++;
        }
    }

    public void mostrarCD(CD datos) {
        System.out.println("Título: " + datos.getTitulo());
        System.out.println("Intérprete: " + datos.getInterprete());
        System.out.println("Cdad. Temas: " + datos.getCdadTemas());
        System.out.println("Duración: " + datos.getDuracion() + "min");
        if (datos.getLoTengo() == 1) {
            System.out.println("Disponible.");
        } else {
            System.out.println("No disponible.");
        }

    }

    public CD agregarCD(String titulo, String interprete, int cdadTemas, int duracion, int loTengo) {
        CD nuevo = null;
        boolean existencia = buscarCDPorTitulo_Interprete(titulo, interprete);

        if (existencia == false) // si no existe
        {
            if (validosCD < 6) // si el arreglo no está lleno, lo agrego
            {
                int pos = buscarUltPosCDs();
                nuevo = new CD(titulo, interprete, cdadTemas, duracion, loTengo);
                listadoCDs[pos + 1] = nuevo;
                validosCD++;
            }
        }

        return nuevo;
    }

    private int buscarUltPosCDs() {
        int pos = 0;
        while (pos < validosCD) {
            pos++;
        }
        return pos;
    }

    public int obtenerPosCD(String titulo, String interprete) {
        int i = 0;
        int pos = -1;
        int flag = 0;

        while (i <= validosCD && flag == 0) {
            if (listadoCDs[i] != null && listadoCDs[i].getTitulo().equals(titulo) && listadoCDs[i].getInterprete().equals(interprete)) {
                pos = i;
                flag = 1;
            }
            i++;

        }

        return pos; // retorna la posición del CD buscado o -1 si no lo encontró
    }

    public boolean buscarCDPorTitulo_Interprete(String titulo, String interprete) {
        boolean existencia = false;
        int i = 0;

        while (i <= validosCD) {
            if (listadoCDs[i] != null && listadoCDs[i].getTitulo().equals(titulo) && listadoCDs[i].getInterprete().equals(interprete)) {
                existencia = true;
            }
            i++;
        }

        return existencia;
    }

}