package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KnjigaTest {

	private Knjiga knjiga;

    @BeforeEach
    void setUp() {
        knjiga = new Knjiga();
    }
    @AfterEach
    void tearDown() {
        knjiga=null;
    }

    @Test
    void testSetNaslovValidan() {
        knjiga.setNaslov("Na Drini cuprija");
        assertEquals("Na Drini cuprija", knjiga.getNaslov());
    }

    @Test
    void testSetNaslovNull() {
        assertThrows(NullPointerException.class, () -> knjiga.setNaslov(null));
    }

    @Test
    void testSetNaslovPrazan() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setNaslov(""));
    }

    @Test
    void testSetIsbnValidan() {
        knjiga.setIsbn(1234567890123L);
        assertEquals(1234567890123L, knjiga.getIsbn());
    }

    @Test
    void testSetIsbnNula() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIsbn(0));
    }

    @Test
    void testSetIsbnManjeOdNule() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIsbn(-5));
    }

    @Test
    void testSetIzdavacValidan() {
        knjiga.setIzdavac("Laguna");
        assertEquals("Laguna", knjiga.getIzdavac());
    }

    @Test
    void testSetIzdavacNull() {
        assertThrows(NullPointerException.class, () -> knjiga.setIzdavac(null));
    }

    @Test
    void testSetIzdavacPrazan() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIzdavac(""));
    }

    @Test
    void testSetIzdanjeValidno() {
        knjiga.setIzdanje(1);
        assertEquals(1, knjiga.getIzdanje());
    }

    @Test
    void testSetIzdanjeNula() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIzdanje(0));
    }

    @Test
    void testSetIzdanjeNegativno() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIzdanje(-2));
    }

    @Test
    void testSetAutori() {
        Autor a1 = new Autor("Ivo", "Andric");
        Autor a2 = new Autor("Branko", "Copic");
        List<Autor> lista = Arrays.asList(a1, a2);
        knjiga.setAutori(lista);
        assertEquals(lista, knjiga.getAutori());
    }

    @ParameterizedTest
    @CsvSource({
        "1234567890123,1234567890123,true",       //
        "1234567890123,9999999999999,false",      // dovoljna samo dva slucaja
        
    })
    @DisplayName("Test equals sa razlicitim ISBN-ovima")
    void testEqualsRazniISBN(long isbn1, long isbn2, boolean expected) {
        Knjiga k1 = new Knjiga();
        k1.setIsbn(isbn1);
        Knjiga k2 = new Knjiga();
        k2.setIsbn(isbn2);
        assertEquals(expected, k1.equals(k2));
    }

    @Test
    void testEqualsIstiObjekat() {
        assertTrue(knjiga.equals(knjiga));
    }

    @Test
    void testEqualsNull() {
        assertFalse(knjiga.equals(null));
    }

    @Test
    void testEqualsDrugaKlasa() {
        assertFalse(knjiga.equals("neka string vrednost"));
    }

    @Test
    void testToString() {
        knjiga.setNaslov("Prokleta avlija");
        knjiga.setIsbn(1234L);
        knjiga.setIzdavac("Prosveta");
        knjiga.setIzdanje(3);

        Autor a = new Autor("Ivo", "Andric");
        knjiga.setAutori(List.of(a));

        String s = knjiga.toString();
        assertTrue(s.contains("Prokleta avlija"));
        assertTrue(s.contains("1234"));
        assertTrue(s.contains("Prosveta"));
        assertTrue(s.contains("3"));
        assertTrue(s.contains("Ivo"));
        assertTrue(s.contains("Andric"));
    }
}
