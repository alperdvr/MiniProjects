package TicketReservationApp;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    // --- Bu sınıf, otobüsün özelliklerini tanımlar.
    // --- Otobüsün plaka numarası, koltuk sayısı ve koltuk numaralarının listesini tutar.

    private String numberPlate;  // --- Otobüsün plaka numarası.
    private int numberOfSeat;    // --- Otobüsün toplam koltuk sayısı (örneğin, 42).
    private List<String> seats = new ArrayList<>();  // --- Otobüsün koltuk numaralarını tutan liste (örneğin, "1", "2", ..., "42").

    // --- Bu yapıcı (constructor) metot, otobüs oluşturulurken plaka ve koltuk sayısını belirler.
    public Bus(String plaka, int koltukSayisi) {
        this.numberPlate = plaka;  // --- Plaka numarasını belirler.
        this.numberOfSeat = koltukSayisi;  // --- Koltuk sayısını belirler.

        // --- Belirtilen koltuk sayısına kadar koltuk numaralarını listeye ekler.
        for (int i = 1; i <= this.numberOfSeat; i++) {
            this.seats.add(String.valueOf(i));  // --- Koltuk numarasını listeye ekler (örneğin, "1", "2", ...).
        }
    }

    // --- Getter metotlar: Özelliklerin değerlerini okumak için kullanılır.
    public String getNumberPlate() {
        return numberPlate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public List<String> getSeats() {
        return seats;
    }

    // --- Setter metotlar: Özelliklerin değerlerini değiştirmek için kullanılır.
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
}