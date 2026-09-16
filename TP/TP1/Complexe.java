public class Complexe {
    private final double reel;
    private final double imaginaire;

    public static final Complexe ZERO = new Complexe(0, 0);
    public static final Complexe UN = new Complexe(1, 0);
    public static final Complexe I = new Complexe(0, 1);

    public Complexe(double reel, double imaginaire) {
        this.reel = reel;
        this.imaginaire = imaginaire;
    }

    public static Complexe fromPolarCoordinates(double rho, double theta) {
        return new Complexe(rho * Math.cos(theta), rho * Math.sin(theta));
    }

    // === ARTHMETIQUE USUELLES ===

    public Complexe somme(Complexe c) {
        double somme_reel = this.reel + c.reel;
        double somme_imaginaire = this.imaginaire + c.imaginaire;
        return new Complexe(somme_reel, somme_imaginaire);
    }

    public Complexe soustraction(Complexe c) {
        double soustraction_reel = this.reel - c.reel;
        double soustraction_imaginaire = this.imaginaire - c.imaginaire;
        return new Complexe(soustraction_reel, soustraction_imaginaire);
    }

    public Complexe multiplication(Complexe c) {
        double multiplication_reel = (this.reel * c.reel) - (this.imaginaire * c.imaginaire);
        double multiplication_imaginaire = (this.reel * c.imaginaire) + (c.reel * this.imaginaire);
        return new Complexe(multiplication_reel, multiplication_imaginaire);
    }

    public Complexe division(Complexe c) {
        double denominateur = (c.reel * c.reel) + (c.imaginaire * c.imaginaire);
        double division_reel = ((this.reel * c.reel) + (this.imaginaire * c.imaginaire)) / denominateur;
        double division_imaginaire = ((c.reel * this.imaginaire) - (this.reel * c.imaginaire)) / denominateur;
        return new Complexe(division_reel, division_imaginaire);
    }

    // === GETTERS ===

    public double getReel() {
        return reel;
    }

    public double getImaginaire() {
        return imaginaire;
    }

    public Complexe conjugaison() {
        return new Complexe(reel, -imaginaire);
    }

    public double module() {
        return Math.sqrt((reel * reel) + (imaginaire * imaginaire));
    }

    public double argument() {
        return Math.atan2(imaginaire, reel);
    }

    public String toString() {
        String signe = imaginaire > 0 ? " + " : " - ";
        return reel + signe + Math.abs(imaginaire) + "i";
    }

    public boolean equals(Object other) {
        if (other instanceof Complexe) {
            Complexe c = (Complexe) other;
            return Double.compare(c.reel, this.reel) == 0 && Double.compare(c.imaginaire, this.imaginaire) == 0;
        }
        return false;
    }
}
