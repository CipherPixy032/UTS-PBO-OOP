public class Lahan {
    private String jenisTanah;
    private int ukuran; // dalam meter persegi

    public Lahan(String jenisTanah, int ukuran) {
        this.jenisTanah = jenisTanah;
        this.ukuran = ukuran;
    }

    public void tanam(Tanaman tanaman) {
        System.out.println(tanaman.nama + " ditanam di lahan jenis " + jenisTanah);
    }

    public void siram(Tanaman tanaman) {
        System.out.println(tanaman.nama + " disiram.");
    }

    public void pupuk(Tanaman tanaman) {
        System.out.println(tanaman.nama + " dipupuk.");
    }
}
