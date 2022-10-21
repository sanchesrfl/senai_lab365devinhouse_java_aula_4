import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {
                                            //throws parseException serve para sinalizar a exceção.
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        // lógica de verificação
        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation.DisplayReservation());

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            // fazemos a chamada da atualização de datas aqui, essa chamada pode retornar um erro!
            String error = reservation.updateDates(checkIn, checkOut);
            // se o erro for diferente de nulo tem um erro! e entao mostramos na tela o erro
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            }
            // se nao tiver o erro, o programa segue e mostra a reserva com os dados atualizados
            else {
                System.out.println("Reservation: " + reservation);
            }
        }

        sc.close();
    }
}