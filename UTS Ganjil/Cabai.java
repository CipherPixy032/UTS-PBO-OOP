public class Cabai extends Tanaman {

    public Cabai() {
        super("Cabai", 12); // Tanaman Cabai siap dipanen setelah 12 hari
    }

    @Override
    public int getLevel() {
        return 3; // Level 3 saat dipanen
    }

    @Override
    public int getHargaJual() {
        return 2000; // Harga jual Cabai saat dipanen
    }
}
