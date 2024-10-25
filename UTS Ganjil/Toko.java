import java.util.HashMap;

public class Toko {
    private HashMap<String, Integer> stok;
    private HashMap<String, Integer> hargaBenih;

    public Toko() {
        stok = new HashMap<>();
        stok.put("Benih Padi", 10);
        stok.put("Benih Jagung", 10);
        stok.put("Benih Tomat", 10);
        stok.put("Benih Cabai", 10);

        hargaBenih = new HashMap<>();
        hargaBenih.put("Padi", 2000);
        hargaBenih.put("Jagung", 1500);
        hargaBenih.put("Tomat", 500);
        hargaBenih.put("Cabai", 1000);
    }

    public void beliBarang(String barang, int jumlah) {
        if (stok.containsKey(barang) && stok.get(barang) >= jumlah) {
            stok.put(barang, stok.get(barang) - jumlah);
            System.out.println("Anda membeli " + jumlah + " " + barang);
        } else {
            System.out.println("Stok tidak mencukupi.");
        }
    }

    public int hargaBenih(String benih) {
        return hargaBenih.getOrDefault(benih, 0);
    }

    public void tampilkanStok() {
        System.out.println("Stok di toko:");
        for (String barang : stok.keySet()) {
            System.out.println(barang + ": " + stok.get(barang));
        }
    }

    // Fixed: Implementing the missing return statement in getHargaBenih
    public int getHargaBenih(String benih) {
        return hargaBenih.getOrDefault(benih, 0); // Return price, default to 0 if not found
    }
}
