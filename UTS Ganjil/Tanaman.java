public abstract class Tanaman {
    protected String nama;
    protected int hariTumbuh;
    protected int hariPanen;

    public Tanaman(String nama, int hariPanen) {
        this.nama = nama;
        this.hariPanen = hariPanen;
        this.hariTumbuh = 0; // Awal hari tumbuh adalah 0
    }

    public String getNama() {
        return nama;
    }

    // Setiap tanaman punya metode untuk disiram
    public void siram() {
        System.out.println(nama + " disiram.");
    }

    // Setiap tanaman punya metode untuk dipupuk
    public void pupuk() {
        System.out.println(nama + " dipupuk.");
    }

    // Metode untuk kendali hama
    public void kendaliHama() {
        System.out.println(nama + " hama dikendalikan.");
    }

    // Mengembalikan hari kapan tanaman siap dipanen
    public int getHariPanen() {
        return hariPanen;
    }

    // Mengembalikan level yang didapat saat dipanen
    public abstract int getLevel();

    // Mengembalikan harga jual tanaman saat dipanen
    public abstract int getHargaJual(); // Set to abstract so subclasses must implement
}
