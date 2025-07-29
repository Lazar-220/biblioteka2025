package biblioteka.interfejs;

import java.util.List;

import biblioteka.Knjiga;
/**
 * Predstavlja biblioteku u kojoj mogu da se dodaju nove knjige, brišu i pretražuju knjige.
 * 
 * @author Lazar Milosavljević
 */
public interface BibliotekaInterface {

	/**
	 * Dodaje novu knjigu u biblioteku, ta knjiga ne sme biti null niti duplikat (da već postoji u biblioteci).
	 * 
	 * @param knjiga Knjiga koju treba dodati u biblioteku
	 * 
	 * @throws java.lang.NullPointerException ako je uneta knjiga null
	 * @throws java.lang.IllegalArgumentException ako uneta knjiga vec postoji u biblioteci
	 */
	public void dodajKnjigu(Knjiga knjiga) ;
	
	/**
	 * Briše postojeću knjigu iz biblioteke, ta knjiga ne sme biti null i mora postojati u biblioteci.
	 * 
	 * @param knjiga Knjiga koju treba obrisati iz biblioteke
	 * 
	 * @throws java.lang.NullPointerException ako je uneta knjiga null
	 * @throws java.lang.IllegalArgumentException ako uneta knjiga ne postoji u biblioteci
	 */
	public void obrisiKnjigu(Knjiga knjiga);
	/**
	 * Vraća sve knjige iz biblioteke.
	 * 
	 * @return Listu sa svim knjigama iz biblioteke
	 * 
	 * @see java.util.List
	 */
	public List<Knjiga> vratiListuKnjiga();
	/**
	 * Vraća knjige iz biblioteke koje imaju isti naslov kao uneta knjiga.
	 * 
	 * @param knjiga Knjiga koja bi trebalo da se nalazi u biblioteci, 
	 * objekat klase Knjiga mora da sadrži bar podatak o naslovu (dovoljan je deo naslova i nebitna je veličina slova),
	 * može da sadrži i podatke o <ul><li>autoru</li><li>izdavaču</li><li>isbn-u (identifikatoru knjige)</li><li>izdanju</li></ul>
	 * 
	 * @return Listu sa knjigama iz biblioteke sa naslovom koji sadrži naslov unete knjige,
	 *  ili praznu listu ako nema ni jedne takve knjige
	 * 
	 * @throws java.lang.IllegalArgumentException ako uneta knjiga ne sadrži podatke ni o jednom od 
	 * <ul><li>autora</li><li>izdavača</li><li>isbn-a (identifikatora knjige)</li><li>izdanja</li><li>naslova</li></ul>
	 * 
	 * @see java.util.List
	 */
	public List<Knjiga> pronadjiKnjigu(Knjiga knjiga);
}
