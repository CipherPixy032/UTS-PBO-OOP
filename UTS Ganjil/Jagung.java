public class Jagung extends Tanaman {

    public Jagung() {
        super("Jagung", 18); // Jagung siap dipanen setelah 18 hari
    }

    @Override
    public int getLevel() {
        return 5; // Level 5 saat dipanen
    }

    @Override
    public int getHargaJual() {
        return 1000; // Harga jual Jagung saat dipanen
    }
}
