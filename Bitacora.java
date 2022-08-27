package Ticket_Generator;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bitacora {

    String Soporte;
    LocalDate Fecha;
    LocalTime Hora;
    String Mensaje;
    Tipo_Evento Evento;

    public Bitacora(String nSoporte, String mensaje, Tipo_Evento event) {
        this.Soporte = nSoporte;
        this.Mensaje = mensaje;
        this.Evento = event;
    }

    public Bitacora(Ticket tiket) {
        this.Soporte=tiket.getNitUsuario();
        this.Mensaje= tiket.getProblema();
        this.Fecha= LocalDate.now();
        this.Hora= LocalTime.now();
        this.Evento= Tipo_Evento.Crear;
    }

    public String getNitSoporte() {
        return Soporte;
    }

    public void setNitSoporte(String nitSoporte) {
        this.Soporte = nitSoporte;
    }

    public LocalDate getFechaAc() {
        return Fecha;
    }

    public void setFechaAc(LocalDate fechaAc) {
        Fecha = Fecha;
    }

    public LocalTime getHoraAc() {
        return Hora;
    }

    public void setHoraAc(LocalTime horaAc) {
        Hora = horaAc;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        this.Mensaje = mensaje;
    }

    public Tipo_Evento getEvento() {
        return Evento;
    }

    public void setEvento(Tipo_Evento evento) {
        this.Evento = evento;
    }


    public String String() {
        return "------------------------------------------------------------------------------------------------------------------------------------"+
                "\n *   *   *   *   *   *   *   *   *   *   *   *   * Bitacora *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *" +
                "\n itSoporte:" + Soporte +
                "\n Fecha: " + Fecha +
                "\n Hora: " + Hora +
                "\n mensaje: " + Mensaje +
                "\n evento: " + Evento +
                "\n------------------------------------------------------------------------------------------------------------------------------------";

    }
}
