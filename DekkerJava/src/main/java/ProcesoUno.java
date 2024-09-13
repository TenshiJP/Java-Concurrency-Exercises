/**
 *
 * @author angel
 */
public class ProcesoUno extends Thread{
    /*Variables*/
    boolean p1deseaentrar; 
    boolean p2deseaentrar;
    int procesoActivo;

    /*Constructor*/
    public ProcesoUno(boolean p1deseaentrar, boolean p2deseaentrar, int procesoActivo) {
        this.p1deseaentrar = p1deseaentrar;
        this.p2deseaentrar = p2deseaentrar;
        this.procesoActivo = procesoActivo;
    }
    
    /*Metodo del Hilo 1*/
    public void run(){
        p1deseaentrar = true;
        while (p2deseaentrar == true){ //Mientras el proceso dos sea verdadero.
            if (procesoActivo==2){ //Si el turno es 2, se ejecuta proceso dos.
                p1deseaentrar = false;//Para el paso del Proceso Uno.
                while(procesoActivo==2){
                    p1deseaentrar=true;
                }
            }else{}
        }
        System.out.println("Entrar a la Seccion Critica del Proceso Uno");
        procesoActivo = 2;//Activar proceso 2.
        p1deseaentrar = false;//Cambiar estado del proceso 1.
        System.out.println("Otras tareas del Proceso Uno...");
        for(int a = 1; a<=3; a++){//Ciclo para imprimir una primide de * para simular otra tarea.
            for(int i = 1; i<=3-a; i++){//Espacios en blanco
                System.out.print(" ");
            }           
            for(int j=1; j<=(a*2)-1; j++){//Numerales
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("\tFin Proceso 1");
    }
}
