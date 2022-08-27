package Ticket_Generator;

import java.util.LinkedList;
import java.util.Queue;

public class Cola_Mesa extends Cola_Servicio{
    public Cola_Mesa() {
    }

    public static Queue<Ticket> ColaMe = new LinkedList<>();


    public void AgregarTiket(Ticket tickets) {
        System.out.println("Agregando Ticket a cola Mesa");
        ColaMe.add(tickets);
        System.out.println("Agregado a Mesa");
        System.out.println("Tickes en Cola: "+ColaMe.size());
        /*for (Tiket t:ColaMe){
           t.getId();
            System.out.println(t.toString()+"\n tiket "+ (t.getId()-1)+" Agregado a Mesa");
        }

         */

    }


    public void QuitarTiket() {

        ColaMe.poll();
    }


    public void QuitarTiket(int index) {

    }


}
