package TicketReservationApp;

import java.util.Scanner;

public class TicketReservationApp {

    public static void main(String[] args) {
        start();
    }

    private static void start() {

        // --- Otobüs objesi oluşturulur (plaka: "34 TPE 789", koltuk sayısı: 33).
        Bus bus = new Bus("34 TPE 789", 33);

        Ticket ticket;
        Scanner scanner = new Scanner(System.in);
        int select;

        do {
            // --- Kullanıcıdan bilet bilgileri alınır.
            System.out.println("Bilet Rezervasyon Sistemine Hoşgeldiniz;)");
            System.out.println("Lütfen ad-soyad giriniz: ");
            String name = scanner.nextLine();

            System.out.println("Lütfen yaşınızı giriniz: ");
            int age = scanner.nextInt();

            System.out.println("Lütfen gidilecek mesafeyi(KM) giriniz: ");
            double km = scanner.nextDouble();

            System.out.println("Yolculuk tipini giriniz: ");
            System.out.println("1-Tek Yön");
            System.out.println("2-Gidiş-Dönüş");
            int type = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Lütfen koltuk no giriniz: ");
            System.out.println("Tekli koltuk ücreti %20 daha fazladır!");
            System.out.println(bus.getSeats());
            String seatNo = scanner.next();

            // --- Koltuğun rezerve edilip edilmediği kontrol edilir.
            boolean isReserved = !bus.getSeats().contains(seatNo);

            // --- Kullanıcının girdiği bilgiler geçerli mi kontrol edilir.
            if (km > 0 && age > 0 && (type == 1 || type == 2) && !isReserved) {
                // --- Bilet oluşturulur ve fiyat hesaplanır.
                ticket = new Ticket(km, type, seatNo, bus);
                ticket.setPrice(age);

                // --- Rezerve edilen koltuk listeden kaldırılır.
                ticket.getBus().getSeats().remove(seatNo);

                // --- Bilet bilgileri ekrana yazdırılır.
                ticket.printTicket(name);
            } else {
                // --- Hatalı veri girilmişse uyarı verilir.
                if (isReserved) {
                    System.out.println("Seçilen koltuk rezerve edilmiş veya mevcut değil!");
                } else {
                    System.out.println("Sayın " + name + " hatalı veri girdiniz!!!");
                }
            }

            System.out.println("Yeni işlem için bir sayı giriniz veya ÇIKIŞ için 0 giriniz: ");
            select = scanner.nextInt();
            scanner.nextLine();

        } while (select != 0);
        System.out.println("İyi günler dileriz, yine bekleriz...");
    }
}
