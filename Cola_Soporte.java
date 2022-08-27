package Ticket_Generator;
import java.util.Stack;

public class Cola_Soporte extends Cola_Servicio{
    public Cola_Soporte() {
    }
    public static Stack<Ticket> PilaSo = new Stack<>();

    public void AgregarTiket(Ticket tickets) {
        System.out.println("Agregando ticket a cola Soporte");
        PilaSo.push(tickets);
        System.out.println("Agregado a Soporte");
        System.out.println("tickes en Cola: "+PilaSo.size());

       /* for (Tiket t:PilaSo){
            System.out.println(t.toString()+"\n Agregado a Soporte");
        }

        */

    }


    public void QuitarTiket() {

        PilaSo.pop();
    }

    public void QuitarTiket(int index) {

    }

}
