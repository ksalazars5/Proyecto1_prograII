package Ticket_Generator;

import java.util.ArrayList;

public class Cola_Desarollo extends Cola_Servicio{
    public int index;

    public Cola_Desarollo() {
    }
    public  static ArrayList<Ticket> my_list = new ArrayList<>();
    public void AgregarTiket(Ticket tickets) {
        System.out.println("Agregando ticket a cola Desarrollo");
        my_list.add(tickets);
        System.out.println("Agregado a Desarrolo");
        System.out.println("tickes en Cola: "+my_list.size());
       /* for (Tiket t:my_list){
            System.out.println(t.toString()+"\n Agregado a Desarrollo");
        }
        */
    }

    public void QuitarTicket() {


        my_list.remove(index);

    }

}
