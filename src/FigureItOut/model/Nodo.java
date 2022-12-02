package FigureItOut.model;


public class Nodo {

 
    int indice; // indice del nodo
    Pregunta pregunta;  // lo que almacena el nodo
    int liga[]; // hijos del nodo


    //constructor de nodo
    public Nodo(int indice, Pregunta pregunta) {

        this.indice = indice;
        this.pregunta = pregunta;
        this.liga = null;
      
    }


    //retorna lista de hijos
    public void Setliga(int liga[]) {
        this.liga = liga;

    }

   


    //retorna indice
    public int getIndice() {
        return this.indice;
    }

   
    //retorna lista de hijos
    public int[] getLiga() {
        return this.liga;
    }

//    //imprime nodo
//    public void imprimir() {
//        System.out.println("indice -->" + this.indice);
//        System.out.println("Jugador -->" + this.pregunta.getNombre()+ " " + pregunta.getApellido());
//        String cadena = " ";
//        try {
//            int size = this.liga.length;
//            for (int i = 0; i < size; i++) {
//                cadena = cadena + liga[i] + " ";
//            }
//            System.out.println("hijos --> " + cadena);
//        } catch (Exception e) {
//            System.out.println("hijos -> " + null);
//        }
//
//        System.out.println("¿tiene hermanos? --> " + this.sw);
//
//    }
}
