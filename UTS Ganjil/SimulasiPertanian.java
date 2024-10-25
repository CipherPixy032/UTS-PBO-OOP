import java.util.*;

public class SimulasiPertanian {
    private static Map<String, Integer> benihDimiliki = new HashMap<>();
    private static List<Tanaman> tanamanDitanam = new ArrayList<>();
    private static String namaPetani;
    private static int totalLv = 0;
    private static int uang = 1000000;
    private static boolean tanamanDirawat = false;
    private static int hariSekarang = 0;
    private static Cuaca cuaca = new Cuaca();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Toko toko = new Toko();
        Waktu waktu = new Waktu();

        // Login User
        System.out.print("Masukkan nama petani: ");
        namaPetani = scanner.nextLine();

        // Inisialisasi benih yang dimiliki pemain
        benihDimiliki.put("Padi", 0);
        benihDimiliki.put("Jagung", 0);
        benihDimiliki.put("Tomat", 0);
        benihDimiliki.put("Cabai", 0);

        // Menu Utama
        while (true) {
            System.out.println("\n" + namaPetani + " Lv. " + totalLv + " Uang: " + uang);
            System.out.println("=== Menu Simulasi Pertanian ===");
            System.out.println("1. Tampilkan stok di toko");
            System.out.println("2. Beli benih");
            System.out.println("3. Tanam tanaman");
            System.out.println("4. Rawat tanaman");
            System.out.println("5. Ubah hari");
            System.out.println("6. Panen tanaman");
            System.out.println("7. Keluar");

            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    toko.tampilkanStok();
                    break;

                case 2:
                    beliBenih(scanner, toko);
                    break;

                case 3:
                    tanamTanaman(scanner);
                    break;

                case 4:
                    rawatTanaman();
                    break;

                case 5:
                    System.out.print("Masukkan jumlah hari untuk dilewati: ");
                    int daysToSkip = scanner.nextInt();
                    ubahHari(daysToSkip);
                    break;

                case 6:
                    panenTanaman();
                    break;

                case 7:
                    System.out.println("Keluar dari permainan...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    private static void beliBenih(Scanner scanner, Toko toko) {
        System.out.print("Masukkan nama benih yang ingin dibeli (Padi, Jagung, Tomat, Cabai): ");
        scanner.nextLine(); // Clear the buffer
        String benih = scanner.nextLine();
        System.out.print("Masukkan jumlah benih yang ingin dibeli: ");
        int jumlah = scanner.nextInt();

        int harga = toko.getHargaBenih(benih); // Mendapatkan harga benih dari toko

        if (uang >= harga * jumlah) {
            toko.beliBarang("Benih " + benih, jumlah);
            benihDimiliki.put(benih, benihDimiliki.get(benih) + jumlah);
            uang -= harga * jumlah; // Kurangi uang pemain
        } else {
            System.out.println("Uang tidak cukup.");
        }
    }

    private static void tanamTanaman(Scanner scanner) {
        System.out.print("Masukkan jenis tanaman yang ingin ditanam (Padi, Jagung, Tomat, Cabai): ");
        scanner.nextLine();
        String jenisTanaman = scanner.nextLine();

        if (benihDimiliki.get(jenisTanaman) > 0) {
            Tanaman tanaman = buatTanaman(jenisTanaman);
            tanamanDitanam.add(tanaman);
            benihDimiliki.put(jenisTanaman, benihDimiliki.get(jenisTanaman) - 1);
            System.out.println(jenisTanaman + " ditanam!");
        } else {
            System.out.println("Anda belum memiliki benih " + jenisTanaman + ".");
        }
    }

    private static Tanaman buatTanaman(String jenisTanaman) {
        switch (jenisTanaman) {
            case "Padi":
                return new Padi();
            case "Jagung":
                return new Jagung();
            case "Tomat":
                return new Tomat();
            case "Cabai":
                return new Cabai();
            default:
                return null;
        }
    }

    private static void rawatTanaman() {
        if (!cuaca.getCuaca().equals("Hujan")) { // Jika tidak hujan, rawat tanaman
            tanamanDirawat = true;
            for (Tanaman tanaman : tanamanDitanam) {
                tanaman.siram();  // Memanggil metode siram()
                tanaman.pupuk();  // Memanggil metode pupuk()
                tanaman.kendaliHama(); // Kendalikan hama
                System.out.println(tanaman.getNama() + " dirawat (disiram, dipupuk, dikendalikan hamanya).");
            }
        } else {
            System.out.println("Cuaca hujan, tanaman tidak perlu dirawat.");
        }
    }

    private static void ubahHari(int daysToSkip) {
        hariSekarang += daysToSkip;
        cuaca.ubahCuaca(hariSekarang); // Update weather based on the current day

        // Update each plant's growth days
        for (Tanaman tanaman : tanamanDitanam) {
            tanaman.hariTumbuh += daysToSkip; // Increment each plant's growth day
        }

        System.out.println("Hari diubah sebanyak " + daysToSkip + " hari, sekarang hari ke-" + hariSekarang + " Cuaca: " + cuaca.getCuaca());

        // Only reset the care flag without removing plants
        tanamanDirawat = false;
    }

    private static void panenTanaman() {
        Iterator<Tanaman> iterator = tanamanDitanam.iterator();
        while (iterator.hasNext()) {
            Tanaman tanaman = iterator.next();
            if (tanaman.hariTumbuh >= tanaman.getHariPanen()) { // Check if plant reached harvest day
                System.out.println(tanaman.getNama() + " Dipanen.");
                totalLv += tanaman.getLevel(); // Increase player level by plant's level
                uang += tanaman.getHargaJual(); // Add money from harvested plant
                iterator.remove(); // Remove harvested plant from list
            } else {
                System.out.println(tanaman.getNama() + " belum bisa dipanen.");
            }
        }
    }
}
