public class Tomat extends Tanaman {

    public Tomat() {
        super("Tomat", 10); // Tanaman Tomat akan siap dipanen setelah 10 hari
    }

    @Override
    public int getLevel() {
        return 2; // Level 2 saat dipanen
    }

    @Override
    public int getHargaJual() {
        return 1000; // Harga jual Tomat saat dipanen
    }
}
