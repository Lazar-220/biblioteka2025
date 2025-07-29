package biblioteka.interfejs;

import java.util.ArrayList;
import java.util.List;

import biblioteka.Knjiga;

/**
 * Imlementira BibliotekaInterface tako što čuva knjige u listi u memoriji (ArrayList implementacija).
 * @see java.util.ArrayList
 */
public class Biblioteka implements BibliotekaInterface {

	//ova lista je implementirana kao arraylist zbog cestog dodavanja i pretrage 
	/**
	 * Knjige se čuvaju u listi u memoriji preko ArrayList zbog čestog dodavanja i pretrage.
	 * @see java.util.ArrayList
	 */
	List<Knjiga>knjige=new ArrayList<>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null!");
		}if(knjige.contains(knjiga)) {
			throw new IllegalArgumentException("Ta knjiga vec postoji u biblioteci!");
		}
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null!");
		}if(!knjige.contains(knjiga)) {
			throw new IllegalArgumentException("Ta knjiga ne postoji u biblioteci!");
		}
		knjige.remove(knjiga);
	}

	
	@Override
	public List<Knjiga> vratiListuKnjiga() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Knjiga knjiga) {

		if(knjiga.getAutori()==null&&knjiga.getIsbn()<=0&&knjiga.getNaslov()==null&&knjiga.getIzdavac()==null) {
			throw new IllegalArgumentException("Morate uneti bar neki kriterijum za pretragu!");

		}
		List<Knjiga>lista=new ArrayList<Knjiga>();
		for(Knjiga k: knjige) {
			if(k.getNaslov().toUpperCase().contains(knjiga.getNaslov().toUpperCase())) {
				lista.add(k);
				
			}
		}
		return lista;
	}

}
