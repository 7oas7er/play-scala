package persist;

import models.Karte;
import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.*;

public class CsvDaoTest {

    @Test
    public void parseCSV_shallParse580Cards() throws IOException {
        assertEquals(580, new CsvDao().generateCardlist().size());
    }

    @Test
    public void parseCSV_firstCardIsCorporation() throws IOException {
        assertEquals(Karte.Alignment.CORPORATION, new CsvDao().generateCardlist().get(0).alignment);
    }

    @Test
    public void parseCSV_firstCardIsLimited() throws IOException {
        assertEquals(Karte.Edition.LIMITED, new CsvDao().generateCardlist().get(0).edition);
    }

    @Test
    public void parseCSV_firstCardIsOperation() throws IOException {
        assertEquals(Karte.Type.OPERATION, new CsvDao().generateCardlist().get(0).cardType);
    }

    @Test
    public void parseCSV_firstCardHasCorrectFlavourText() throws IOException {
        assertEquals("If we don't receive payment in full by tomorrow, we'll be ogliged to repossess. But ... But the equipment's already been installed in our employees.", new CsvDao().generateCardlist().get(0).flavourText);
    }

    @Test
    public void parseCSV_firstCardHasCorrectIllustrator() throws IOException {
        assertEquals("Zak Plucinski", new CsvDao().generateCardlist().get(0).illustrator);
    }

    @Test
    public void parseCSV_firstCardHasCorrectText() throws IOException {
        assertEquals("Gain ➒.", new CsvDao().generateCardlist().get(0).text);
    }

    @Test
    public void parseCSV_firstCardHasCorrectName() throws IOException {
        assertEquals("Accounts Receivable", new CsvDao().generateCardlist().get(0).name);
    }

    @Test
    public void parseCSV_firstCardIsCommon() throws IOException {
        assertEquals(Karte.Rarity.COMMON, new CsvDao().generateCardlist().get(0).rarity);
    }

}
