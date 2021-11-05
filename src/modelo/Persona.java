package modelo;

/**
 *
 * @author juan Moncada 
 */

public class Persona 
{
    private String nombre;
    private int cedula;
    private int edad;
    private int numero;
    
    public Persona()
    {
        this.nombre = "";
        this.cedula = 0;
        this.edad = 0;
        this.numero = 0;
    }

    public Persona(String nombre, int cedula, int edad, int numero) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.numero = numero;
    }
    
    /*Método que devuelve prioridad de la persona dentro de la cola de acuerdo a su edad. 
      Se considera una persona con mayor prioridad si es mayor o igual a 60 años*/
    public int calcularPrioridad ()
    {
        if(this.edad >= 60)
        {
            return 2;
        }
            return 1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", cedula=" + cedula + ", edad=" + edad;
    }
}
