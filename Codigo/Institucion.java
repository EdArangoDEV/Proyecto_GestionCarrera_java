import java.util.Scanner;
import java.io.IOException;

public class Institucion {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {

        // Creacion de objetos principales
        Director dir1 = new Director(2401, "Ing. Luis Marroquin", "Logistica");

        Carrera cr1 = new Carrera(2401, "Tecnico de Desarollo de Software",
                "Programa de estudios en Ingeniería de Software", 5, dir1);

        cr1.agregarSemestres();

        Horario h1 = new Horario("Lunes", 18, 19);
        Horario h2 = new Horario("Miercoles", 19, 20);
        Horario h3 = new Horario("Viernes", 20, 21);

        Profesor p1 = new Profesor(2402, "Marvin Castillo", "Matematicas");
        Profesor p2 = new Profesor(2403, "Alejandra Torres", "Idioma Ingles");

        Curso c1 = new Curso("Mate1", 5, h1, p1);
        Curso c2 = new Curso("Logica", 7, h2, dir1);
        Curso c3 = new Curso("Ingles", 6, h3, p2);

        cr1.semestres.get(0).agregarCurso(c1);
        cr1.semestres.get(0).agregarCurso(c2);
        cr1.semestres.get(0).agregarCurso(c3);

        limpiarConsola();
        while (true) {
            informacionCarrera(cr1);
            mostrarMenuPrincipal();
            int opcionPrincipal = leerOpcion();

            switch (opcionPrincipal) {
                case 1:
                    editarDatosCarrera(cr1);
                    break;
                case 2:
                    ;
                    editarDirector(cr1, cr1.director);
                    break;
                case 3:
                    editarSemestres(cr1);
                    break;
                case 4:
                    System.out.println("\nSaliendo del programa...");
                    return;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
                    break;
            }

        }

    }

    private static void informacionCarrera(Carrera cr) {
        System.out.println("Sistema de Gestion de carrera!\n");
        System.out.println(cr);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nMenú principal:");
        System.out.println("1. Editar datos carrera");
        System.out.println("2. Director carrera");
        System.out.println("3. Ver semestres carrera");
        System.out.println("4. Salir");
    }

    private static void menuDatosCarrera() {

        System.out.println("Opciones datos Carrera:\n");
        System.out.println("1. Editar Nombre");
        System.out.println("2. Editar Descripcion");
        System.out.println("3. regresar");
    }

    private static void menuDirectorCarrera() {

        System.out.println("Opciones Director Carrera:\n");
        System.out.println("1. Cambiar de director");
        System.out.println("2. regresar");
    }

    private static void menuDatosDirectorCarrera() {

        System.out.println("Opciones Director actual:\n");
        System.out.println("1. Editar Nombre");
        System.out.println("2. Editar Especialidad");
        System.out.println("3. regresar");
    }

    private static void menuSemestres() {

        System.out.println("\nOpciones datos Semestres:\n");
        System.out.println("1. Editar cursos semestre");
        System.out.println("2. regresar");
    }

    private static void menuCursos() {

        System.out.println("\nOpciones datos Cursos:\n");
        System.out.println("1. Editar Nombre de curso");
        System.out.println("2. Editar Horario de curso");
        System.out.println("3. Editar Profesor de curso");
        System.out.println("4. Agregar curso");
        System.out.println("5. Eliminar curso");
        System.out.println("6. regresar");
    }

    private static void editarDatosCarrera(Carrera carrera) throws IOException, InterruptedException {

        do {
            System.out.println("Datos actuales de la carrera: " + carrera.getNombre() + ", descripcion: " + carrera.getDescripcion() + ".\n");
            menuDatosCarrera();
            int opcionPrincipal = leerOpcion();

            switch (opcionPrincipal) {
                case 1:
                    System.out.print("Ingrese nuevo nombre de carrera: ");
                    String Nnombre = scanner.nextLine();
                    carrera.setNombre(Nnombre);
                    break;
                case 2:
                    System.out.print("Ingrese nueva descripcion de la carrera: ");
                    String nDescripcion = scanner.nextLine();
                    carrera.setDescripcion(nDescripcion);
                    break;
                case 3:
                    System.out.println("\nRegresando a Menu principal...");
                    return;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.\n");
                    break;
            }

        } while (true);

    }

    private static void editarDirector(Carrera carrera, Director director) throws IOException, InterruptedException {

        do {
            System.out.println("Director actual de la carrera: " + director.getNombre() + "\n");
            menuDirectorCarrera();
            int opcionPrincipal = leerOpcion();

            switch (opcionPrincipal) {
                case 1:
                    Empleado emp = agregarDirector(carrera);
                    // conversion de clase padre a clase hija
                    Director dir = (Director) emp;
                    carrera.setDirector(dir);
                    director = dir;
                    break;
                case 2:
                    System.out.println("\nRegresando a Menu principal...");
                    return;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
                    break;
            }

        } while (true);

    }

    private static void editarDatosDirector(Director director) throws IOException, InterruptedException {
        do {
            System.out.println("Datos actuales del director:");
            System.out.println("\tNombre: " + director.getNombre());
            System.out.println("\tEspecialidad: " + director.getEspecialidad() + "\n");
            menuDatosDirectorCarrera();
            int opcionPrincipal = leerOpcion();

            switch (opcionPrincipal) {
                case 1:
                    System.out.print("Ingrese nuevo nombre del director: ");
                    String nDirector = scanner.nextLine();
                    director.setNombre(nDirector);
                    break;
                case 2:
                    System.out.print("Ingrese nueva especialidad del director: ");
                    String nEspecialidad = scanner.nextLine();
                    director.setEspecialidad(nEspecialidad);
                    break;
                case 3:
                    System.out.println("\nRegresando a Menu principal...");
                    return;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
                    break;
            }

        } while (true);
    }

    private static void editarSemestres(Carrera carrera) throws IOException, InterruptedException {

        do {
            carrera.getSemestres();
            menuSemestres();
            int opcionPrincipal = leerOpcion();

            switch (opcionPrincipal) {
                case 1:
                    System.out.print("Ingrese numero de semestre: ");
                    // int nSemestre = scanner.nextInt();
                    int nSemestre = Integer.parseInt(scanner.nextLine());
                    Semestre semestre = carrera.semestres.get(nSemestre - 1);
                    limpiarConsola();
                    editarCursos(semestre, carrera);
                    break;
                case 2:
                    System.out.println("\nRegresando a Menu principal...\n");
                    return;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.\n");
                    break;
            }

        } while (true);

    }

    private static int numeroCurso() {
        System.out.print("Ingrese numero de curso: ");
        int nCurso = Integer.parseInt(scanner.nextLine());
        return nCurso;
    }

    private static int ingresarHora(String m) throws IOException, InterruptedException {
        int hora = 0;
        int op = 0;
        String formatoH = "La hora debe estar en 0 a 24, ingresela de nuevo\n";

        do {
            System.out.print("Ingrese hora de " + m + " de curso de 0 a 24 horas: ");
            hora = Integer.parseInt(scanner.nextLine());
            limpiarConsola();
            if (hora > 0 && hora < 25) {
                op = 1;
            } else {
                System.out.print(formatoH);
            }

        } while (op != 1);
        op = 0;
        return hora;
    }

    private static int validarHoraF(int horaI) throws IOException, InterruptedException {
        int nHoraF = 0;
        int op = 0;

        do {
            nHoraF = ingresarHora("Fin");

            if (nHoraF <= horaI) {
                System.out.println("La hora de Fin tiene que ser mayor a la hora de Inicio vuelva a ingresarla");
            } else {
                op = 1;
            }
            // limpiarConsola();
        } while (op != 1);
        op = 0;
        return nHoraF;
    }

    private static Empleado agregarDirector(Carrera carrera) throws IOException, InterruptedException {
        String nNombreP = "";
        String nEspecialidadP = "";

        System.out.print("Ingrese el codigo de empleado: ");
        Integer codP = Integer.parseInt(scanner.nextLine());
        limpiarConsola();
        Profesor profEncontrado = carrera.getProfesores(codP);
        Empleado emp;
        limpiarConsola();
        if (profEncontrado != null) {
            int codEmp = profEncontrado.getCodigo();
            String nomEmp = profEncontrado.getNombre();
            String espEmp = profEncontrado.getEspecialidad();
            System.out.print("Se encontro empleado con codigo: " + codEmp + " y nombre: "
                    + espEmp + "\n");
            emp = new Director(codEmp, nomEmp, espEmp);
            return emp;
        } else {
            System.out.println("No se encontro Empleado con codigo: " + codP);
            System.out.print("Ingrese el nombre: ");
            nNombreP = scanner.nextLine();
            limpiarConsola();
            System.out.println("Empleado ingresado con codigo: " + codP + ", nombre: " + nNombreP);
            System.out.print("Ingrese la especialidad: ");
            nEspecialidadP = scanner.nextLine();
            limpiarConsola();
            System.out.println("Empleado ingresado con codigo: " + codP + ", nombre: " + nNombreP
                    + " y especialidad: " + nEspecialidadP + "\n");
            emp = new Director(codP, nNombreP, nEspecialidadP);
            return emp;
        }
    }

    private static Profesor agregarProfesor(Carrera carrera) throws IOException, InterruptedException {
        String nNombreP = "";
        String nEspecialidadP = "";

        System.out.print("Ingrese el codigo del profesor: ");
        Integer codP = Integer.parseInt(scanner.nextLine());
        limpiarConsola();
        Profesor profEncontrado = carrera.getProfesores(codP);
        Profesor p;
        limpiarConsola();
        if (profEncontrado != null) {
            System.out.print("Se encontro profesor con codigo: " + profEncontrado.codigo + " y nombre: "
                    + profEncontrado.nombre + "\n");
            p = profEncontrado;
            return p;
        } else {
            System.out.println("No se encontro profesor con codigo: " + codP);
            System.out.print("Ingrese el nombre: ");
            nNombreP = scanner.nextLine();
            limpiarConsola();
            System.out.println("Profesor ingresado con codigo: " + codP + ", nombre: " + nNombreP);
            System.out.print("Ingrese la especialidad: ");
            nEspecialidadP = scanner.nextLine();
            limpiarConsola();
            System.out.println("Profesor ingresado con codigo: " + codP + ", nombre: " + nNombreP
                    + " y especialidad: " + nEspecialidadP);
            p = new Profesor(codP, nNombreP, nEspecialidadP);
            return p;
        }
    }

    private static void agregarCurso(Semestre semestre, Carrera carrera) throws IOException, InterruptedException {
        int nHoraF = 0;
        int nHoraI = 0;

        limpiarConsola();
        System.out.print("Ingrese el nombre del curso: ");
        String nNombreC = scanner.nextLine();
        limpiarConsola();
        System.out.println("Nombre ingresado: " + nNombreC + "\n");
        System.out.print("Ingrese creditos del curso: ");
        int nCreditos = Integer.parseInt(scanner.nextLine());
        limpiarConsola();
        System.out.println("Nombre de curso ingresado: " + nNombreC + ", Creditos del curso ingresado: "
                + nCreditos + "\n");
        System.out.print("Ingrese dia: ");
        String nDia = scanner.nextLine();
        limpiarConsola();
        System.out.println("Nombre de curso ingresado: " + nNombreC + ", Creditos del curso ingresado: "
                + nCreditos + ", dia ingresado: " + nDia + "\n");

        nHoraI = ingresarHora("Inicio");

        nHoraF = validarHoraF(nHoraI);

        System.out.println(
                "Nombre de curso ingresado: " + nNombreC + ", Creditos del curso ingresado: " + nCreditos
                        + ", dia ingresado: " + nDia + " con horario de " + nHoraI + " a " + nHoraF + "\n");
        Profesor resP = agregarProfesor(carrera);
        Horario h = new Horario(nDia, nHoraI, nHoraF);
        Curso c = new Curso(nNombreC, nCreditos, h, resP);
        semestre.agregarCurso(c);
    }

    private static void editarCursos(Semestre semestre, Carrera carrera) throws IOException, InterruptedException {

        do {
            System.out.println("Cursos actuales del Semestre " + semestre.getNumero());
            boolean res = semestre.getCursos();

            if (!res) {
                System.out.println("\nOpciones datos Cursos:\n");
                System.out.println("1. Agregar curso");
                System.out.println("2. regresar");
                int opcionPrincipal = leerOpcion();

                switch (opcionPrincipal) {
                    case 1:
                        agregarCurso(semestre, carrera);
                        break;
                    case 2:
                        System.out.println("\nRegresando a opciones semestre...");
                        return;
                    default:
                        System.out.println("\nOpción inválida. Intente de nuevo.\n");
                        break;
                }
            } else {
                menuCursos();
                int opcionPrincipal = leerOpcion();
                int nCurso;
                Curso curso;

                switch (opcionPrincipal) {
                    case 1:
                        nCurso = numeroCurso();
                        curso = semestre.cursos.get(nCurso - 1);
                        limpiarConsola();
                        System.out.println("Nombre actual de curso " + nCurso + ": "
                                + curso.getNombre() + "\n");
                        System.out.print("Ingrese nuevo nombre del curso: ");
                        String nNombre = scanner.nextLine();
                        limpiarConsola();
                        curso.setNombre(nNombre);
                        break;
                    case 2:
                        int nHoraF = 0;
                        int nHoraI = 0;
                        nCurso = numeroCurso();
                        curso = semestre.cursos.get(nCurso - 1);
                        limpiarConsola();
                        Horario horario = curso.getHorario();
                        System.out.println("Horario actual de curso " + curso.getNombre() + ": "
                                + curso.getHora() + "\n");
                        nHoraI = ingresarHora("Inicio");
                        limpiarConsola();
                        nHoraF = validarHoraF(nHoraI);
                        limpiarConsola();
                        horario.hora_inicio = nHoraI;
                        horario.hora_fin = nHoraF;
                        curso.setHorario(horario);
                        break;
                    case 3:
                        nCurso = numeroCurso();
                        curso = semestre.cursos.get(nCurso - 1);
                        limpiarConsola();
                        System.out.println(
                                "Profesor actual del curso " + curso.getNombre() + ": "
                                        + curso.getProfesor() + "\n");
                        Profesor p = agregarProfesor(carrera);
                        limpiarConsola();
                        curso.prof_asignado.setCodigo(p.codigo);
                        curso.prof_asignado.setNombre(p.nombre);
                        curso.prof_asignado.setEspecialidad(p.especialidad);
                        break;
                    case 4:
                        agregarCurso(semestre, carrera);
                        break;
                    case 5:
                        nCurso = numeroCurso();
                        curso = semestre.cursos.get(nCurso - 1);
                        limpiarConsola();
                        // System.out.println(curso);
                        semestre.eliminarCurso(curso);
                        break;
                    case 6:
                        System.out.println("\nRegresando a Opciones semestre...\n");
                        return;
                    default:
                        System.out.println("\nOpción inválida. Intente de nuevo.\n");
                        break;
                }
            }

        } while (true);
    }

    private static int leerOpcion() throws IOException, InterruptedException {
        while (true) {
            try {
                Integer op;
                System.out.print("Ingrese una opción: ");
                op = Integer.parseInt(scanner.nextLine());
                limpiarConsola();
                // System.out.println(op);
                return op;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void limpiarConsola() throws IOException, InterruptedException {
        String operatingSystem = System.getProperty("os.name");

        if (operatingSystem.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }

}

// "C:\InsJava\jdk-22.0.2\bin\java.exe" Institucion
// "C:\InsJava\jdk-22.0.2\bin\javac.exe" *.java