import serviceLoadQuestions.CsvLoadServiceImpl;

import java.io.IOException;

public class LoaderTests {

    @org.junit.Test
    public void laodTEst() throws IOException {
        new CsvLoadServiceImpl().load();
    }

}
