public class Curso {

    protected Integer codigo;
    protected String nombre;
    protected int creditos;
    protected Horario horario;
    protected Profesor prof_asignado;
    static Integer nextId = 101;

    public Curso(String nom, int cred, Horario hor, Profesor prof) {
        this.codigo = nextId++;
        setNombre(nom);
        setCreditos(cred);
        this.horario = hor;
        this.prof_asignado = prof;
    }

    @Override
    public String toString() {
        return this.nombre;
        //return getNombre();
    }

    // METODOS DE ACCESO
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nNombre) {
        if (nNombre.length() <= 4) {
            System.out.println("no se puede poner el Nombre del curso vacio o menor a 5 letras");
        } else {
            this.nombre = nNombre;
            // System.out.println("Se puso el nombre al curso: "
        }
    }

    public int getCreditos() {
        return this.creditos;
    }

    public void setCreditos(int nCred) {
        if (nCred <= 0) {
            System.out.println("se debe poner un valor a los creditos.");
        } else {
            this.creditos = nCred;
            // System.out.println("Se asignaron " + getCreditos() + " al curso.");
        }
    }

    public Horario getHorario(){
        return this.horario;
    }

    public String getHora(){
        return ("de " + this.horario.hora_inicio + " a " + this.horario.hora_fin);
    }

    public void setHorario(Horario hor) {
        if (hor.hora_inicio <= 0 && hor.hora_fin <= 0) {
            System.out.println("se debe poner un valor a los horarios.");
        } else {
            this.horario.hora_fin = hor.hora_fin;
            this.horario.hora_inicio = hor.hora_inicio;
            // System.out.println("Se asignaron " + getCreditos() + " al curso.");
        }
    }

    public Profesor getProfesor() {
        return this.prof_asignado;
    }


    

}