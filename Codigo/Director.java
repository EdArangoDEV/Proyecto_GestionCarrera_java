public class Director extends Profesor{

    public Director(Integer cod, String nom, String esp){
        super(cod, nom, esp);
    }


    @Override
    public String toString(){
        return  this.nombre;
    }

}