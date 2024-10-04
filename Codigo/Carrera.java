import java.util.ArrayList;

public class Carrera {

    protected Integer codigo;
    protected String nombre;
    protected String descripcion;
    protected int duracion;
    protected ArrayList<Semestre> semestres;
    protected Director director;

    public Carrera(Integer cod, String nom, String desc, int dur, Director dir) {
        this.codigo = cod;
        this.nombre = nom;
        this.descripcion = desc;
        this.duracion = dur;
        this.semestres = new ArrayList<>();
        this.director = dir;
    }

    @Override
    public String toString() {
        return "Carrera: " + this.nombre + ", descripcion: " + this.descripcion + ", con duracion de: " + this.duracion
                + " semestres y Director: " + this.director;
    }

    // METODOS DE ACCESO
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nNombre) {
        if (nNombre.length() <= 5) {
            System.out.println("no se puede poner el Nombre del curso vacio o menor a 5 letras");
        } else {
            this.nombre = nNombre;
            // System.out.println("Se puso el nombre al curso: " + getNombre());
        }
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String nDesc) {
        if (nDesc.length() <= 5) {
            System.out.println("no se puede poner una Descripcion del curso vacio o menor a 5 letras");
        } else {
            this.descripcion = nDesc;
            // System.out.println("Se puso el nombre al curso: " + getNombre());
        }
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int nDur) {
        if (nDur < 1 || nDur > 11) {
            System.out.println("no se puede poner una duracion de carrera menor a 0 o amyor a 10 semestres");
        } else {
            this.duracion = nDur;
            // System.out.println("Se puso el nombre al curso: " + getNombre());
        }
    }

    public void getSemestres() {
        String resultado = "No hay semestres en la carrera";
        if (this.semestres == null) {
            System.out.println(resultado);
        } else {
            System.out.println("La carrera: " + this.nombre + ", tiene los siguientes semestres:");
            this.semestres.forEach(semestre -> {
                System.out.println("\nSemestre " + semestre.getNumero());
                semestre.getCursos();
            });
        }
    }

    public void agregarSemestres() {
        for (int i = 1; i < this.duracion + 1; i++) {
            Semestre semestre = new Semestre(i);
            this.semestres.add(semestre);
        }
    }

    public Director getDirectorCarrera() {
        return this.director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    
    public Profesor getProfesores(Integer cod) {

        Profesor p = null;

        for (Semestre semestre : this.semestres) 
        {
            p = semestre.busquedaProfesor(cod);

            if (p != null) {
                // if (semestre.busquedaProfesor(cod).codigo.equals(cod)) {
                //     p = semestre.busquedaProfesor(cod);
                //     //System.out.println(p);
                //     return p;
                // }
                if (p.codigo.equals(cod)) {
                    //System.out.println(p);
                    return p;
                }
            }
        }
        return p;
    }

}