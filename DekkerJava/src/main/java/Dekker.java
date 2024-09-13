/**
 *
 * @author angel
 */
public class Dekker {
    public static void main (String [] args){  
        /*Variables*/
        boolean p1deseaentrar = false; 
        boolean p2deseaentrar = false;
        int procesoActivo = 1;
        /*Instancias*/
        ProcesoUno p1 = new ProcesoUno(p1deseaentrar, p2deseaentrar, procesoActivo);
        ProcesoDos p2 = new ProcesoDos(p1deseaentrar, p2deseaentrar, procesoActivo);
        /*Puesta en Marcha*/
        System.out.println("\t***** DEKKER EN JAVA *****\n");
        p1.start(); //Hilo1
        p2.start(); //Hilo2
    }
}
