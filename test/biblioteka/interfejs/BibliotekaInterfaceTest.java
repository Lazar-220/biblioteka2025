package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;

public abstract class BibliotekaInterfaceTest {

	protected BibliotekaInterface biblioteka;
	public abstract BibliotekaInterface getInstance();
	
	private Knjiga k1;
	private Knjiga k2;
	
	@BeforeEach
	void setUp() throws Exception {
		biblioteka=getInstance();
		k1=new Knjiga();
		k1.setIsbn(111);
		k2=new Knjiga();
		k2.setIsbn(222);
	}

	@AfterEach
	void tearDown() throws Exception {
		biblioteka=null;
		k1=null;
		k2=null;
	}

	@Test
	void testDodajKnjigu() {
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga>lista=biblioteka.vratiListuKnjiga();
		assertEquals(lista.size(), 2);
		assertTrue(lista.contains(k1));
		assertTrue(lista.contains(k2));
	}
	@Test
	void testDodajKnjiguNull() {
		
		assertThrows(java.lang.NullPointerException.class, 
				()->biblioteka.dodajKnjigu(null));
	}
	@Test
	void testDodajKnjiguDuplikat() {
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		assertThrows(java.lang.IllegalArgumentException.class, 
				()->biblioteka.dodajKnjigu(k2));
	}

	@Test
	void testObrisiKnjigu() {
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		biblioteka.obrisiKnjigu(k1);
		
		List<Knjiga>lista=biblioteka.vratiListuKnjiga();
		
		assertEquals(lista.size(), 1);
		assertFalse(lista.contains(k1));
		assertTrue(lista.contains(k2));
	}

	@Test
	void testObrisiKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class, 
				()-> biblioteka.obrisiKnjigu(null));
	}
	@Test
	void testObrisiKnjiguNePostoji() {
		biblioteka.dodajKnjigu(k1);
		
		assertThrows(java.lang.IllegalArgumentException.class, 
				()-> biblioteka.obrisiKnjigu(new Knjiga()));
	}

	@Test
	void testVratiListuKnjiga() {
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga>lista=biblioteka.vratiListuKnjiga();
		assertEquals(lista.size(), 2);
		assertTrue(lista.contains(k1));
		assertTrue(lista.contains(k2));
	}

	@Test
	void testPronadjiKnjiguNema() {
		k1.setNaslov("Naslov 1");
		biblioteka.dodajKnjigu(k1);
		k2.setNaslov("Naslov 2");
		biblioteka.dodajKnjigu(k2);
		
		Knjiga k3=new Knjiga();
		k3.setNaslov("Naslov 3");
		List<Knjiga>lista=biblioteka.pronadjiKnjigu(k3);
		assertEquals(lista.size(), 0);
	}
	@Test
	void testPronadjiKnjiguJedanRez() {
		k1.setNaslov("Naslov 1");
		biblioteka.dodajKnjigu(k1);
		k2.setNaslov("Naslov 2");
		biblioteka.dodajKnjigu(k2);
		
		Knjiga k3=new Knjiga();
		k3.setNaslov("v 1");
		List<Knjiga>lista=biblioteka.pronadjiKnjigu(k3);
		assertEquals(lista.size(), 1);
		assertEquals(lista.get(0), k1);
	}
	
	@Test
	void testPronadjiKnjiguViseRez() {
		k1.setNaslov("Naslov 1");
		biblioteka.dodajKnjigu(k1);
		k2.setNaslov("Naslov 2");
		biblioteka.dodajKnjigu(k2);
		
		Knjiga k3=new Knjiga();
		k3.setNaslov("NAS");
		List<Knjiga>lista=biblioteka.pronadjiKnjigu(k3);
		assertEquals(lista.size(), 2);
		assertTrue(lista.contains(k1));
		assertTrue(lista.contains(k2));
	}
	
	@Test
	void testPronadjiKnjiguNemaParametara() {
		assertThrows(java.lang.IllegalArgumentException.class, 
				()->biblioteka.pronadjiKnjigu(new Knjiga()));
	}
	

}
