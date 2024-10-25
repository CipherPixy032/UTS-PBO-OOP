public class Waktu {
    private int hari;

    public Waktu() {
        this.hari = 0;
    }

    public void tambahHari(int jumlahHari) {
        hari += jumlahHari;
        System.out.println("Waktu berlalu: " + hari + " hari.");
    }

    public int getHari() {
        return hari;
    }
}
