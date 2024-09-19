import java.util.ArrayList;

public class Semestre {

    protected Integer codigo;
    protected Integer numero;
    protected ArrayList<Curso> cursos;
    // static Integer nextId = 101;

    public Semestre(Integer num) {
        // this.codigo = nextId++;
        setNumero(num);
        this.cursos = new ArrayList<Curso>();
    }

    @Override
    public String toString() {
        return "El Semestre numero: " + this.numero;
    }

    // METODOS DE ACCESO

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer nNumero) {
        if (nNumero <= 0) {
            System.out
                    .println("no se puede poner un numero de semestre menor a 1 o mayor a la duracion de la carrera.");
        } else {
            this.numero = nNumero;
            // System.out.println("Se puso el numero de semestre: " + getNumero());
            setCodigo(nNumero);
        }
    }

    protected void setCodigo(Integer nNumero) {
        String cod = "";
        String nNum = Integer.toString(nNumero);
        cod = "10" + nNum;

        this.codigo = Integer.parseInt(cod);
    }

    public boolean getCursos() {
        String resultado = "\tNo tiene cursos.";
        boolean b = false;

        if (this.cursos.isEmpty()) {
            System.out.println(resultado);
            return b;
        } else {
            // System.out.println("El semestre numero: " + this.numero + ", tiene los
            // siguientes cursos:");
            int[] i = { 1 };
            this.cursos.forEach(curso -> {
                System.out.println("\t" + i[0] + ". curso: " + curso.getNombre() + " con " + curso.getHorario() + " y Profesor: " + curso.getProfesor() + ".");
                i[0]++;
            });
            b = true;
            return b;
        }
    }

    /* 
     public void seleccionarCurso(Curso CursoB) {
        boolean encontrado = false;
        Curso cr;

        for (Curso curso : this.cursos) {
            if (curso.nombre.toUpperCase().equals(CursoB.nombre.toUpperCase())) {
                encontrado = true;
                cr = curso;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encuentra el curso");
        }
    }
    */
    

    public void agregarCurso(Curso c) {
        this.cursos.add(c);
        System.out.println("Se agrego el curso: " + c.getNombre() + " al semestre numero " + this.getNumero() + "\n");
    }

    public void eliminarCurso(Curso c){
        this.cursos.remove(c);
        System.out.println("Se elimino el curso: " + c.getNombre() + " con " + c.getHorario() +"\n");
    }


    public Profesor busquedaProfesor(Integer cod){
        Profesor p = null;

        if (!this.cursos.isEmpty()) 
        {
            for (Curso curso : this.cursos)
            {
                if(curso.getProfesor().codigo.equals(cod))
                {
                    p = curso.getProfesor();
                    return p;
                }
            }
        }
        return p;
    }


}