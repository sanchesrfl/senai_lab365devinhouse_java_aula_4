import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {                         // apagamos o o thrhows porque a exceção agora vai ser TRATADA
                                            //throws parseException serve para sinalizar a exceção.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //inserimos o bloco de código em um Try Blcok
        try {
            // input dos dados
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            // lógica de verificação anterior DELETADO ***

            //mostramos na tela a reserva
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            // agora tiramos o String error e fazemos a atualização direto e também a checagem
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
            //inserimos aqui um Catch Block para tratar as exceções da parse exception por exemplo - abordagem Try-with-catch
        catch (ParseException e) {

            System.out.println("Invalid Date Format");

        }
        // inserimos aqui um bloco catch para tratar os illegal argument exception

        catch (IllegalArgumentException e) {
            // inserimos um print ( e.getMessage() ) que vai puxar a mensagem de erro inserida na exceção da classe Reservation

            System.out.println("Error in reservation: " + e.getMessage());
        }

        sc.close();
    }
}