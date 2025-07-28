package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {

	private Autor a;
	@BeforeEach
	void setUp() throws Exception {
		a=new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a=null;
	}

	@Test
	void testAutor() {
		
		assertNotNull(a);
	}
	@Test
	void testAutorStringString() {
		
		a=new Autor("Mika","Mikic");
		
		assertNotNull(a);
		
		assertEquals("Mika", a.getIme());
		assertEquals("Mikic", a.getPrezime());
	}
	
	@Test
	void testSetIme() {
		
		a.setIme("Pera");
		
		assertEquals("Pera", a.getIme());
	}

	@Test
	void testSetImeNull() {
		
		assertThrows(java.lang.NullPointerException.class, 
				()-> a.setIme(null));
	}
	
	@Test
	void testSetImePrazno() {
		
		assertThrows(java.lang.IllegalArgumentException.class, 
				()-> a.setIme(""));
	}
	
	@Test
	void testSetPrezime() {
		
		a.setPrezime("Peric");
		
		assertEquals("Peric", a.getPrezime());
	}

	@Test
	void testSetPrezimeNull() {
		
		assertThrows(java.lang.NullPointerException.class, 
				()-> a.setPrezime(null));
	}
	
	@Test
	void testSetPrezimePrazno() {
		
		assertThrows(java.lang.IllegalArgumentException.class, 
				()-> a.setPrezime(""));
	}
	
	@Test
	//@Disabled  //-za preskakanje testa
	void testToString() {
		
		a.setIme("Pera");
		a.setPrezime("Mikic");
		assertTrue(a.toString().contains("Pera") && a.toString().contains("Mikic"));
	}
	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Peric, Mika, Peric, false",
		"Pera, Peric, Pera, Mikic, false",
		"Pera, Peric, Mika, Mikic, false",
	})
	void testEquals(String ime1,String prezime1,String ime2,String prezime2,boolean ocekivano) {
		a=new Autor(ime1,prezime1);
		Autor a2=new Autor(ime2,prezime2);
		assertEquals(ocekivano, a.equals(a2));
	}
}
