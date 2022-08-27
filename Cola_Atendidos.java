package Ticket_Generator;

import java.util.ArrayList;

public class Cola_Atendidos {

    ArrayList<Ticket> Tiketes = new ArrayList<>();

    public void AgregarTiket(Ticket tickets) {
        System.out.println("tickets atendidos");
        Tiketes.add(tickets);
        System.out.println(Tiketes.size());
        for (Ticket t:Tiketes){
            System.out.println(t.String());
        }
    }

    public void QuitarTiket(int index) {

    }
}
