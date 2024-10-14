package TicketReservationApp;

public class Ticket {

    // --- Bu sınıf, bir biletin özelliklerini tanımlar.
    // --- Biletin mesafesi, yolculuk tipi, koltuk numarası, fiyatı ve ait olduğu otobüs bilgilerini içerir.

    private double distance;  // --- Yolculuk mesafesi (KM cinsinden).
    private int typeNo;       // --- Yolculuk tipi: 1 (Tek Yön) veya 2 (Gidiş-Dönüş).
    private String seatNo;    // --- Yolcunun seçtiği koltuk numarası.
    private double price;     // --- Biletin fiyatı.
    private Bus bus;          // --- Bu biletin ait olduğu otobüs.

    // --- Bu yapıcı metot, bilet oluşturulurken mesafe, yolculuk tipi, koltuk numarası ve otobüsü belirler.
    public Ticket(double distance, int typeNo, String seatNo, Bus bus) {
        this.distance = distance;
        this.typeNo = typeNo;
        this.seatNo = seatNo;
        this.bus = bus;
    }

    // --- Getter ve setter metotlar: Biletin özelliklerini okumak ve değiştirmek için kullanılır.
    public double getDistance() {
        return distance;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public double getPrice() {
        return price;
    }

    public Bus getBus() {
        return bus;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // --- Biletin fiyatını yolcunun yaşına ve kurallara göre hesaplar.
    public void setPrice(int age) {
        double unitPrice = (this.typeNo == 1) ? 1.0 : 2.0;  // --- Tek yönse 1 TL/km, gidiş-dönüşse 2 TL/km.
        if (Integer.parseInt(seatNo) % 3 == 0) {
            unitPrice *= 1.2;  // --- Koltuk numarası 3 veya 3'ün katıysa, %20 daha fazla ücret.
        }
        this.price = unitPrice * this.distance;

        // --- Gidiş-dönüş indirimi.
        if (this.typeNo == 2) {
            this.price *= 0.8;
        }

        // --- Yaş indirimleri.
        if (age < 12) {
            this.price *= 0.5;  // --- 12 yaş altı için %50 indirim.
        } else if (age > 65) {
            this.price *= 0.7;  // --- 65 yaş üstü için %30 indirim.
        }
    }

    // --- Bilet bilgisini ekrana yazdırır.
    public void printTicket(String name) {
        System.out.println("Ad-Soyad: " + name);
        System.out.println("Mesafe: " + this.distance + " KM");
        System.out.println("Yolculuk Tipi: " + (this.typeNo == 1 ? "Tek Yön" : "Gidiş-Dönüş"));
        System.out.println("Koltuk No: " + this.seatNo);
        System.out.println("Fiyat: " + this.price + " TL");
        System.out.println("İyi Yolculuklar...");
    }
}
