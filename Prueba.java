package Ticket_Generator;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        ArrayList<Bitacora> bitacora = new ArrayList<>();
        ArrayList<Ticket> tiketes = new ArrayList<>();
        Cola_Mesa AMesa;
        AMesa = new Cola_Mesa();
        Cola_Soporte Asoport;
        Asoport = new Cola_Soporte();
        Cola_Desarollo Adesa;
        Adesa = new Cola_Desarollo();
        Cola_Atendidos Atendidos;
        Atendidos = new Cola_Atendidos();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            menu();
            try {
                opcion = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("Ingrese Numeros");
                scanner = new Scanner(System.in);
                opcion = 10000000;
            }

            switch (opcion) {
                case 1: {
                    int nitus = 0;
                    String Nusuario;
                    scanner.nextLine();
                    do {

                        System.out.println("creando su Ticket");
                        System.out.println("Ingrese el numero de nit de usario");
                        Nusuario = scanner.nextLine();
                        nitus = Nusuario.length();

                        for (int i = 0; i < Nusuario.length(); i++) {
                            char c = Nusuario.charAt(i);

                            if (!(c >= '0' && c <= '9')) {

                                nitus = 10;
                            }
                        }
                        if (nitus != 6) {
                            System.out.println("El numero de nit que usted ingreso tiene mas numeros, debe ser de 7 digitos.");

                        }
                    } while (nitus != 6);
                    System.out.println("Ingrese  su problema");
                    String suproblema = scanner.nextLine();
                    Ticket tiket = new Ticket(Nusuario, suproblema);

                    tiketes.add(tiket);
                    System.out.println("Su tiket ha sido creado:");
                    System.out.println(tiket);

                    Bitacora bit = new Bitacora(tiket);
                    bitacora.add(bit);
                    System.out.println("Asignando Ticket: ");
                    tiket.setEstado("Asignado ");
                    System.out.println(tiket);
                    Bitacora bit2 = new Bitacora(tiket);
                    bitacora.add(bit2);
                    bit2.setEvento(Tipo_Evento.Asignar);
                    AMesa.AgregarTiket(tiket);

                }
                break;
                case 2:

                    int opcionm = 0;
                    do {
                        menum();
                        try {
                            opcionm = scanner.nextInt();

                        } catch (Exception e) {
                            System.out.println("Opcion Invalida");
                            scanner = new Scanner(System.in);
                            opcionm = 10000000;
                        }
                        switch (opcionm) {
                            case 1:
                                if (!Cola_Mesa.ColaMe.isEmpty()) {
                                    int go = 0;
                                    int TAMA = Cola_Mesa.ColaMe.size();
                                    System.out.println("Tickets en espera: " + TAMA);
                                    Ticket nuvoT = Cola_Mesa.ColaMe.peek();
                                    System.out.println("Ticket a trabajar: " + nuvoT.String());

                                    do {
                                        System.out.println("Ingrese Opcion: ");
                                        System.out.println("1.Solucionar ");
                                        System.out.println("2.Tranferir a Soporte Tecnico");
                                        try {
                                            go = scanner.nextInt();

                                        } catch (Exception e) {
                                            System.out.println("Opcion Invalida");
                                            scanner = new Scanner(System.in);

                                        }
                                    } while (go != 2 & go != 1);
                                    if (go == 1) {

                                        System.out.println("el tiket a sido solucionado.");
                                        nuvoT.setEstado("solucionado");
                                        Atendidos.AgregarTiket(nuvoT);
                                        Ticket nuevoT = null;
                                        Bitacora bit3 = new Bitacora(nuevoT);
                                        bitacora.add(bit3);
                                        bit3.setEvento(Tipo_Evento.solucion);
                                        AMesa.QuitarTiket();

                                    } else {
                                        System.out.println("Su tiket a sido reasignado Soporte tecnico");
                                        Asoport.AgregarTiket(nuvoT);
                                        Bitacora bit4 = new Bitacora(nuvoT);
                                        bitacora.add(bit4);
                                        bit4.setEvento(Tipo_Evento.mover);
                                        AMesa.QuitarTiket();


                                    }
                                } else {
                                    System.out.println("la mesa no tiene tickes a solucionar");
                                }
                                break;
                            case 2:
                                if (!Cola_Soporte.PilaSo.isEmpty()) {
                                    int go = 0;
                                    int TAMA = Cola_Soporte.PilaSo.size();
                                    System.out.println("Tickets en espera: " + TAMA);
                                    Ticket nuvoT = Cola_Soporte.PilaSo.peek();
                                    System.out.println("Ticket a trabajar: " + nuvoT.String());

                                    do {
                                        System.out.println("Ingrese Opcion: ");
                                        System.out.println("1.Solucionar ");
                                        System.out.println("2.Tranferir a Desarrollador");
                                        try {
                                            go = scanner.nextInt();

                                        } catch (Exception e) {
                                            System.out.println("Opcion Invalida");
                                            scanner = new Scanner(System.in);

                                        }
                                    } while (go != 2 & go != 1);
                                    if (go == 1) {
                                        System.out.println("El tiket a sido solucionado.");
                                        nuvoT.setEstado("Solucionado");
                                        Atendidos.AgregarTiket(nuvoT);
                                        Bitacora bit5 = new Bitacora(nuvoT);
                                        bitacora.add(bit5);
                                        bit5.setEvento(Tipo_Evento.solucion);
                                        Asoport.QuitarTiket();

                                    } else {
                                        System.out.println("Su tiket a sido reasignado Desarrolador");
                                        Adesa.AgregarTiket(nuvoT);
                                        Bitacora bit6 = new Bitacora(nuvoT);
                                        bitacora.add(bit6);
                                        bit6.setEvento(Tipo_Evento.mover);
                                        Asoport.QuitarTiket();

                                    }
                                } else {
                                    System.out.println("Soporte no tiene tickes a solucionar");
                                }


                                break;
                            case 3:
                                if (!Cola_Desarollo.my_list.isEmpty()) {
                                    int go = 0;
                                    int TAMA = Cola_Desarollo.my_list.size();
                                    System.out.println("Tickets en Espera: " + TAMA);
                                    int index = (int)(Math.random() * Cola_Desarollo.my_list.size());
                                    Ticket nuvoT = Cola_Desarollo.my_list.get(index);
                                    System.out.println("Ticket a Trabajar: " + nuvoT.String());

                                    do {
                                        System.out.println("1.Solucionar ");

                                        try {
                                            go = scanner.nextInt();

                                        } catch (Exception e) {
                                            System.out.println("Opcion Invalida");
                                            System.out.println("El Progamador debe de dar una Solucion:");
                                            scanner = new Scanner(System.in);

                                        }
                                    } while (go != 1);

                                    System.out.println("El tiket a sido solucionado.");
                                    nuvoT.setEstado("solucionado");
                                    Atendidos.AgregarTiket(nuvoT);
                                    Bitacora bit7 = new Bitacora(nuvoT);
                                    bitacora.add(bit7);
                                    bit7.setEvento(Tipo_Evento.solucion);
                                    Adesa.QuitarTicket();


                                } else {
                                    System.out.println("Desarrollo no tiene tickes a solucionar");
                                }


                                break;
                            case 4:
                                opcionm = 0;
                                break;
                            case 5:
                                JsonParser doc;
                                doc = new JsonParser();
                                try  {
                                    Object obj  =doc.dc(new FileReader("informacion.json")) ;
                                    JsonObject jsonObject;
                                    jsonObject = (JsonObject) obj;
                                    System.out.println("json leido"+jsonObject);
                                }catch (FileNotFoundException e){ }
                                catch (IOException e){ }




                                break;
                            default:
                                System.out.println("Opcion invalida");

                        }

                    } while (opcionm != 0);

                    break;
                case 3:
                    System.out.println("Tickets:");
                    for (Ticket R : tiketes) {
                        System.out.println(R.String());
                    }

                    break;
                case 4:

                    System.out.println("Bitacora:");
                    for (Bitacora e : bitacora) {
                        System.out.println(e.toString());
                    }
                    break;
                case 5:
                    opcion = 0;
                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);


    }

    private static void menu() {
        System.out.println("Sistema de manejo de ticket");
        System.out.println("1. Crear un ticket");
        System.out.println("2. Solucionar su Tiket");
        System.out.println("3. imprimir los Tickets");
        System.out.println("4. imprimir la Bitacora");
        System.out.println("5. salir ");
        System.out.println(" Seleccione el numero que desea realizar: ");
    }


    private static void menum() {
        System.out.println("Atender tickets");
        System.out.println("1. cola mesa");
        System.out.println("2. Cola Soporte");
        System.out.println("3. cola Desarrollador");
        System.out.println("4. Regresar a menu principal");
    }


    private static class JsonParser {
        public Object dc(FileReader fileReader) {
            return null;
        }
    }
}
