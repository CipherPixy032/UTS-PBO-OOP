import java.util.ArrayList;
import java.util.HashMap;

public class Pemain {
    private String nama;
    private int uang;
    private int energi;
    private ArrayList<Tanaman> inventori;
    private HashMap<String, Integer> storage; // Storage system

    public Pemain(String nama) {
        this.nama = nama;
        this.uang = 100000000;
        this.energi = 100;
        this.inventori = new ArrayList<>();
        this.storage = new HashMap<>();
        storage.put("Tomat", 0);
        storage.put("Cabai", 0);
        storage.put("Jagung", 0);
        storage.put("Padi", 0);
    }

    public void tanam(Tanaman tanaman) {
        if (energi >= 10) {
            inventori.add(tanaman);
            energi -= 10;
            System.out.println(nama + " menanam " + tanaman.getNama());
        } else {
            System.out.println("Energi tidak cukup untuk menanam.");
        }
    }

    public void tampilkanInventori() {
        System.out.println("Inventori Tanaman:");
        for (Tanaman tanaman : inventori) {
            System.out.println(tanaman.getNama());
        }
    }

    // Method to store harvested plants
    public void simpanTanaman(String namaTanaman) {
        storage.put(namaTanaman, storage.get(namaTanaman) + 1);
        System.out.println(namaTanaman + " dimasukkan ke dalam penyimpanan.");
    }

    // Method to sell plants for money
    public void jualTanaman(String namaTanaman) {
        int jumlah = storage.get(namaTanaman);
        if (jumlah > 0) {
            int harga = 0;
            switch (namaTanaman) {
                case "Tomat": harga = 1000; break;
                case "Cabai": harga = 2000; break;
                case "Jagung": harga = 3000; break;
                case "Padi": harga = 4000; break;
            }
            uang += harga;
            storage.put(namaTanaman, jumlah - 1);
            System.out.println(namaTanaman + " dijual seharga " + harga + ". Uang sekarang: " + uang);
        } else {
            System.out.println("Tidak ada " + namaTanaman + " di penyimpanan.");
        }
    }

    public int getUang() {
        return uang;
    }
}
