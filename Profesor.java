public class Profesor extends Empleado{

    public Profesor(Integer cod, String nom, String esp){
        super(cod, nom, esp);
    }

    @Override
    public String toString(){
        return  this.nombre;
    }
    

}