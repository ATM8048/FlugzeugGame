package ch.bbw.cardgame;

/**
 * Car
 *    Fachklasse für ein Auto
 * @author Martin Atanasov
 * @date 26.08.2021
 */
public class Flugzeug {
    private String imageUrl;
    private String tradeName;
    private double laenge;
    private double geschwindigkeit;

    public Flugzeug(String imageUrl, String tradeName, double laenge, double geschwindigkeit) {
        this.imageUrl = imageUrl;
        this.tradeName = tradeName;
        this.laenge = laenge;
        this.geschwindigkeit = geschwindigkeit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(int jahr) {
        this.laenge = laenge;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
}
