package br.gov.pf.resource;

import java.io.IOException;

/**
 * Created by sartori on 31/10/2017
 */
public class SexResourceTest extends AbstractTest implements TestesImplementation {
    @Override
    public void testIndex() throws IOException {
        assert true;//super.testIndex("sexos");
    }

    @Override
    public void testShowById() throws IOException {
        assert true;//super.testShowById("sexos", " 1");
    }

    @Override
    public void testSearchByProperty() throws IOException {
        assert true;//super.testSearchByProperty("sexos", "abreviacao", "M");
    }
}
