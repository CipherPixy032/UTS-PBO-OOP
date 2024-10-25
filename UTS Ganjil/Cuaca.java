public class Cuaca {
    private String cuaca;
    private int hariHujan; // To track how long it has been raining

    public Cuaca() {
        this.cuaca = "Cerah";
        this.hariHujan = 0; // Start with 0 days of rain
    }

    public void updateCuaca(int hari) {
        if (hari % 10 == 0) { // Change every 10 days
            cuaca = cuaca.equals("Cerah") ? "Hujan" : "Cerah";
            hariHujan = 0; // Reset rain day counter when the weather changes
        }
    }

    public String getCuaca() {
        return cuaca;
    }

    public void ubahCuaca(int hariSekarang) {
        // Check if it's raining and whether to switch back to "Cerah" after 5 days
        if (cuaca.equals("Hujan")) {
            hariHujan++;
            if (hariHujan >= 5) { // After 5 days of rain, switch back to "Cerah"
                cuaca = "Cerah";
                hariHujan = 0; // Reset the rain counter
            }
        } else {
            // Ensure that the weather is "Hujan" every 10 days
            updateCuaca(hariSekarang);
        }
    }
}
