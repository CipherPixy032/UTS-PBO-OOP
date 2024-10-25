public class Padi extends Tanaman {

    public Padi() {
        super("Padi", 15); // Padi siap dipanen setelah 15 hari
    }

    @Override
    public int getLevel() {
        return 4; // Level 4 saat dipanen
    }

    @Override
    public int getHargaJual() {
        return 4000; // Harga jual Padi saat dipanen
    }
}
