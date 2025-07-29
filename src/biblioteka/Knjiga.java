package biblioteka;

import java.util.List;
import java.util.Objects;
/**
 * Predstavlja knjigu sa osnovnim informacijama kao što su naslov, ISBN broj, 
 * lista autora, izdavač i broj izdanja.
 * 
 * <p>Jedinstvena identifikacija knjige vrši se preko ISBN broja.</p>
 * 
 * @author Lazar Milosavljević
 */
public class Knjiga {

	/**
     * Naslov knjige.
     */
    private String naslov;

    /**
     * Jedinstveni ISBN broj knjige.
     */
    private long isbn;

    /**
     * Lista autora koji su napisali knjigu.
     */
    private List<Autor> autori;

    /**
     * Izdavač knjige.
     */
    private String izdavac;

    /**
     * Redni broj izdanja knjige. 
     */
    private int izdanje;
    /**
     * Vraća naslov knjige.
     * 
     * @return naslov knjige kao String
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Postavlja naslov knjige.
     * 
     * @param naslov Naslov knjige koji se unosi u objekat. Naslov ne sme biti null niti prazan.
     * @throws java.lang.NullPointerException ako je {@code naslov} {@code null}
     * @throws java.lang.IllegalArgumentException ako je {@code naslov} prazan string
     */
    public void setNaslov(String naslov) {
        if (naslov == null) {
            throw new NullPointerException("Naslov ne sme biti null");
        } else if (naslov.isEmpty()) {
            throw new IllegalArgumentException("Naslov ne sme biti prazan");
        }
        this.naslov = naslov;
    }

    /**
     * Vraća ISBN broj knjige.
     * 
     * @return ISBN broj
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * Postavlja ISBN broj knjige.
     * 
     * @param isbn ISBN broj
     * @throws java.lang.IllegalArgumentException ako je {@code isbn} manji ili jednak nuli
     */
    public void setIsbn(long isbn) {
        if (isbn <= 0) {
            throw new IllegalArgumentException("Isbn mora biti veci od nule");
        }
        this.isbn = isbn;
    }

    /**
     * Vraća listu autora knjige.
     * 
     * @return lista autora
     */
    public List<Autor> getAutori() {
        return autori;
    }

    /**
     * Postavlja listu autora knjige.
     * 
     * @param autori lista autora
     */
    public void setAutori(List<Autor> autori) {
        this.autori = autori;
    }

    /**
     * Vraća naziv izdavača.
     * 
     * @return izdavač knjige
     */
    public String getIzdavac() {
        return izdavac;
    }

    /**
     * Postavlja izdavača knjige.
     * 
     * @param izdavac izdavač knjige
     * @throws java.lang.NullPointerException ako je {@code izdavac} {@code null}
     * @throws java.lang.IllegalArgumentException ako je {@code izdavac} prazan string
     */
    public void setIzdavac(String izdavac) {
        if (izdavac == null) {
            throw new NullPointerException("Izdavac ne sme biti null");
        } else if (izdavac.isEmpty()) {
            throw new IllegalArgumentException("Izdavac ne sme biti prazan");
        }
        this.izdavac = izdavac;
    }

    /**
     * Vraća broj izdanja knjige.
     * 
     * @return izdanje knjige
     */
    public int getIzdanje() {
        return izdanje;
    }

    /**
     * Postavlja broj izdanja knjige.
     * 
     * @param izdanje broj izdanja
     * @throws java.lang.IllegalArgumentException ako je {@code izdanje} manje od 1
     */
    public void setIzdanje(int izdanje) {
        if (izdanje <= 0) {
            throw new IllegalArgumentException("Izdanje mora biti 1 ili vece");
        }
        this.izdanje = izdanje;
    }

    /**
     * Vraća String sa svim podacima o knjizi
     * 
     * @return String sa podacima o knjizi u formatu
     * <p>"Knjiga [naslov=####, isbn=####, autori=####, izdavac=####, izdanje=####]"</p>
     */
    @Override
    public String toString() {
        return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
                + ", izdanje=" + izdanje + "]";
    }

    /**
     * Računa hash kod na osnovu ISBN broja.
     * 
     * @return hash kod knjige
     */
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    /**
     * Poredi dve knjige na osnovu ISBN broja.
     * 
     * @param obj objekat za poređenje
     * @return {@code true} ako su ISBN brojevi jednaki, inače {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Knjiga other = (Knjiga) obj;
        return isbn == other.isbn;
    }
}
