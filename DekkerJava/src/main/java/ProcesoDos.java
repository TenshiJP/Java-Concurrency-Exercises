/**
 *
 * @author angel
 */
public class ProcesoDos extends Thread{
    /*Variables*/
    boolean p1deseaentrar; 
    boolean p2deseaentrar;
    int procesoActivo;

    /*Constructor*/
    public ProcesoDos(boolean p1deseaentrar, boolean p2deseaentrar, int procesoActivo) {
        this.p1deseaentrar = p1deseaentrar;
        this.p2deseaentrar = p2deseaentrar;
        this.procesoActivo = procesoActivo;
    }
    
    /*Metodo del Hilo 2*/
    public void run(){
        p2deseaentrar = true;
        while (p1deseaentrar == true){ //Mientras proceso uno sea verdadero.
            if (procesoActivo==1){ //Si el turno es 1, se ejecuta proceso 1.
                p2deseaentrar = false;//Para el paso del proceso 2.
                while(procesoActivo==1){
                    p2deseaentrar=true;
                }
            }else{}
        }
        System.out.println("Entrar a la Seccion Critica del Proceso Dos");
        procesoActivo = 1;//Activar proceso 1.
        p2deseaentrar = false;//Cambiar estado del proceso 2.
        System.out.println("Otras tareas del Proceso Dos...");
        for(int a = 1; a<=3; a++){//Ciclo para imprimir una primide de # para simular otra tarea.
            for(int i = 1; i<=3-a; i++){//Espacios en blanco
                System.out.print(" ");
            }           
            for(int j=1; j<=(a*2)-1; j++){//Asteriscos
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println("\tFin Proceso 2");
    }
}
