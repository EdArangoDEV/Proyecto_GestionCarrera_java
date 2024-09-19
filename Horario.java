
public class Horario{

    protected Integer codigo;
    protected String dia;
    protected Integer hora_inicio;
    protected Integer hora_fin;
    static Integer nextId = 101;


    public Horario(String nDia, Integer horaI, Integer horaF){
        this.codigo = nextId++;
        setDia(nDia);
        this.hora_inicio = horaI;
        this.hora_fin = horaF;
    }
    
    public class DiaSemana{
        static String[] dias = {
            "Lunes",
            "Martes",
            "Miercoles",
            "Jueves",
            "Viernes",
            "Sabado",
            "Domingo"
        };
    }

    public String toString(){
        return "Horario: " + this.dia + " de " + hora_inicio + " a " + hora_fin;
    }

   // METODOS DE ACCESO
    public String getDia(){
        return this.dia;
    }

    public void setDia(String nuevoDia){
        if(nuevoDia.length() <= 0)
        {
            System.out.println("no puede cambiar el dia por uno vacio");
        }
        else
        {
            boolean encontrado = false;
            String d = "";

            for (String dia : DiaSemana.dias)
            {
                if(dia.toUpperCase().equals(nuevoDia.toUpperCase()))
                {
                    encontrado = true;
                    d = dia;
                    break;
                }
            }

            if(!encontrado)
            {
                System.out.println("No se puede cambiar el dia por uno incorrecto: " + nuevoDia);
            }
            else
            {
                this.dia = d;
                //System.out.println("Se cambio el dia por: " + getDia());
            }
        }
    }



    
}