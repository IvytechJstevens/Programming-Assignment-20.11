public class Conversion {

    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        // Display table heading
        System.out.println("Feet    Meters    |    Meters    Feet");
        System.out.println("----------------------------------------");

        // Display conversion table
        for (double feet = 1.0, meters = 20.0; feet <= 10.0 && meters <= 65.0; feet++, meters += 5.0) {
            System.out.printf("%4.1f    %6.3f    |    %6.1f    %6.3f\n",
                              feet, footToMeter(feet), meters, meterToFoot(meters));
        }
    }
}
