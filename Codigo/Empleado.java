public class Empleado {

    protected Integer codigo;
    protected String nombre;
    protected String especialidad;
    // static Integer nextId = 24001;

    public Empleado(Integer cod, String nom, String esp) {
        // this.codigo = nextId++;
        this.codigo = cod;
        setNombre(nom);
        setEspecialidad(esp);
    }

    public String toString() {
        return  this.nombre;
    }


    // METODOS DE ACCESO
    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer cod){
        this.codigo = cod;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nNombre) {
        if (nNombre.length() <= 2) {
            System.out.println("no se puede poner el Nombre vacio o menor a 2 letras\n");
        } else {
            this.nombre = nNombre;
            // System.out.println("Se puso el nombre al Profesor: " + getNombre());
        }
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String nEspecialidad) {
        if (nEspecialidad.length() <= 2) {
            System.out.println("no se puede poner especialidad vacio o menor a 2 letras");
        } else {
            this.especialidad = nEspecialidad;
            // System.out.println("Se puso la especialidad: " + getEspecialidad());
        }
    }

}