package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;



class BibliotekaTest extends BibliotekaInterfaceTest {


	@Override
	public BibliotekaInterface getInstance() {
		return new Biblioteka();
	}

}
