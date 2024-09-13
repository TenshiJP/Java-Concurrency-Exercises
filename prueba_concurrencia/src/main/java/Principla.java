/**
 *
 * @author angel
 */

class Buffer {
    private int espacio = 0;//Variable para el espacio en el almacén.
    private String[] buffer = null;
    private int entrada = 0, salida = 0;
    private int cont = 0;
    public Buffer(int espacio) {
        this.espacio = espacio;
        buffer = new String[espacio];
    }
	
    public synchronized void insertar(String pizza) {	
        while (cont == espacio) //condición de buffer lleno
            try {
		System.out.println("Buffer lleno");
                wait();
            } catch (InterruptedException e) {
                System.err.println("wait interrumpido");
            }	
        buffer[entrada] = pizza;
        entrada = (entrada + 1) % espacio;
        cont++;
        notifyAll(); //inserción en e.m.
    }
	
    public synchronized String extraer() {
        String pizza;
        while (cont == 0) //condición de buffer vacío
            try {
		System.out.println("Buffer vacio");
                wait();
            } catch (InterruptedException e) {
                System.err.println("wait interrumpido");
            }		
        pizza = buffer[salida];
        salida = (salida + 1) % espacio;
        cont--;
        notifyAll();
        return pizza; //extracción en e.m.
    }
	
} //Buffer



class Productor implements Runnable {
    
    private Buffer bb = null;
    private String[] pizzas = {"Pepperoni", "Margarita", "Jamon y Queso", "Jamon y Hongos", "Suprema"};//Posibles pizzas para producir.
    public Productor(Buffer bb) {
        this.bb = bb;
    }
    public void run() {   
        int i = (int)(Math.random()*pizzas.length);
        String item = pizzas[i];
        System.out.println("numero: " + i);
        while (true) {
            i = (int)(Math.random()*pizzas.length);
            item = pizzas[i];
            System.out.println("numero de pizza: " + i);
            System.out.println("Valor producido: " + item);
            bb.insertar(item);
        }
    } //run
} //Productor




class Consumidor implements Runnable {
    
    private Buffer bb = null;
    private int i = 0;
    
    public Consumidor(Buffer bb, int i) {
        this.bb = bb;
        this.i = i;
    }
    
    public void run() {
        
        String item; 
        
        while (true) {
            item = bb.extraer();
            System.out.println("Consumiendo " + item);
        }
    } //run
} //Consumidor

public class Principla {
    public static void main(String[] args) {
        int espacios = 10;
        Buffer buffer = new Buffer(espacios);
        new Thread(new Productor(buffer)).start();
        new Thread(new Consumidor(buffer, 1)).start();
        new Thread(new Consumidor(buffer, 2)).start();
    } //main
}
