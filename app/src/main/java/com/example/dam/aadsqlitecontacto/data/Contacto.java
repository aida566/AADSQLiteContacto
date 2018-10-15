package com.example.dam.aadsqlitecontacto.data;


public class Contacto implements Comparable<Contacto>{

    private String nombre;
    private String telefono;

    public Contacto() {

    }

    public Contacto(String nombre, String telefono) {

        this.nombre = nombre;
        this.telefono = telefono;

    }


    public String getNombre() {
        return nombre;
    }

    public String setNombre(String nombre) {

        this.nombre = nombre;

        return this.nombre;
    }

    public String getTelefono() {

        return telefono;
    }

    public String setTelefono(String telefono) {

        this.telefono = telefono;

        return this.nombre;
    }


    @Override
    public String toString() {

        return "Contacto: " + "Nombre: " + this.nombre + "Telefono: " + this.telefono;


    }

    @Override
    public boolean equals(Object o) {

        //Me dice si dos contactos contienen la misma información, no si son el mismo objeto.
        //Nos obliga a implementar el hashCode cuando ponemos el equals porque siempre se debe cumplir: que
        //si declaro que dos objetos son iguales su hashCode tiene que ser el mismo

        //Por ejemplo: decimos que si dos contactos tienen el mismo nombre entonces son el mismo... luego su hashCode debe ser el mismo

        if (this == o) return true;

        if (!(o instanceof Contacto)) return false;

        Contacto contacto = (Contacto) o;

        if (getNombre() != null ? !getNombre().equals(contacto.getNombre()) : contacto.getNombre() != null)

            return false;

        return getTelefono() != null ? getTelefono().equals(contacto.getTelefono()) : contacto.getTelefono() == null;
    }

    @Override
    public int hashCode() {

        //Me devuelve para un objeto un numero para saber en qué posicion de la tabla hash debo meter ese objeto
        //Tabla asociativa en la que existen las posiciones que nosotros elijamos que existan, no todas
        //Las posiciones se crean dinamicamente
        //Este metodo nos da un numero casi unico para un objeto, pero puede haber empates en las tablas hash, que dos distintos tengan el mismo hastCode...
        //Esto se soluciona gracias a la politica de hash: vas a la posicion posterior/siguiente


        int result = getNombre() != null ? getNombre().hashCode() : 0;

        result = 31 * result + (getTelefono() != null ? getTelefono().hashCode() : 0);

        return result;
    }

    /* Devuelve negativo, 0 o positivo.
     * Orden
     *  + this > o
     *  - this < o
     *  = this == o
     *  Tener esto en cuenta para implementar el compareTo correctamente
     *  Para comparar de acuerdo a distintos criterios se usa un comparator
     * */

    @Override
    public int compareTo(Contacto o) {

        int i = this.nombre.compareTo(o.nombre);

        if(i==0){

            i = this.telefono.compareTo(o.telefono);

        }

        return i;
    }
}