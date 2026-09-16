public class ComplexeMutable {
    private double reel;
    private double imaginaire;

    public static final ComplexeMutable ZERO = new ComplexeMutable(0, 0);
    public static final ComplexeMutable UN = new ComplexeMutable(1, 0);
    public static final ComplexeMutable I = new ComplexeMutable(0, 1);

    public ComplexeMutable(double reel, double imaginaire) {
        this.reel = reel;
        this.imaginaire = imaginaire;
    }

    public static ComplexeMutable fromPolarCoordinates(double rho, double theta) {
        return new ComplexeMutable(rho * Math.cos(theta), rho * Math.sin(theta));
    }

    // === ARTHMETIQUE USUELLES ===

    public void somme(ComplexeMutable c) {
        reel = this.reel + c.reel;
        imaginaire = this.imaginaire + c.imaginaire;
    }

    public void soustraction(ComplexeMutable c) {
        reel = this.reel - c.reel;
        imaginaire = this.imaginaire - c.imaginaire;
    }

    public void multiplication(ComplexeMutable c) {
        double multiplication_reel = (this.reel * c.reel) - (this.imaginaire * c.imaginaire);
        double multiplication_imaginaire = (this.reel * c.imaginaire) + (c.reel * this.imaginaire);
        reel = multiplication_reel;
        imaginaire = multiplication_imaginaire;
    }

    public void division(ComplexeMutable c) {
        double denominateur = (c.reel * c.reel) + (c.imaginaire * c.imaginaire);
        double division_reel = ((this.reel * c.reel) + (this.imaginaire * c.imaginaire)) / denominateur;
        double division_imaginaire = ((c.reel * this.imaginaire) - (this.reel * c.imaginaire)) / denominateur;
        reel = division_reel;
        imaginaire = division_imaginaire;
    }

    // === GETTERS ===

    public double getReel() {
        return reel;
    }

    public double getImaginaire() {
        return imaginaire;
    }

    public void setReel(double r) {
        reel = r;
    }

    public void setImaginaire(double i) {
        imaginaire = i;
    }

    public ComplexeMutable conjugaison() {
        return new ComplexeMutable(reel, -imaginaire);
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
        if (other instanceof ComplexeMutable) {
            ComplexeMutable c = (ComplexeMutable) other;
            return Double.compare(c.reel, this.reel) == 0 && Double.compare(c.imaginaire, this.imaginaire) == 0;
        }
        return false;
    }
}
