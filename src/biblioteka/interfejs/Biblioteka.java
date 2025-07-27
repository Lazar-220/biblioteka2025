package biblioteka.interfejs;

import java.util.ArrayList;
import java.util.List;

import biblioteka.Knjiga;

public class Biblioteka implements BibliotekaInterface {

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
			if(k.getNaslov().toLowerCase().contains(knjiga.getNaslov().toLowerCase())) {
				lista.add(k);
				return lista;
			}
		}
		return lista;
	}

}
