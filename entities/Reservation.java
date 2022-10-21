package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    //agora o metodo de update volta a ser void pq não retorn mais conteúdo para variável
    // caso aconteça algum erro vamos lançar exceção, nao retornar algo!
    public void updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();

        // lógica de validação que permite sinalizar o erro
        //entao se nenhuma dsa duas forem verdadeiras o programa passa
        if (checkIn.before(now) || checkOut.before(now)) {
            //mudamos de return para throw
            // a exceção IllegalArgumentException serve para quando argumentos são inválidos
            throw new IllegalArgumentException("Reservation dates for update must be future dates");
        }
        // lógica de validação que permite sinalizar o erro
        // ! not
        if (!checkOut.after(checkIn)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }

        // se passar os ifs ele atualizar a data
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        // não precisamos mais do return null

    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}