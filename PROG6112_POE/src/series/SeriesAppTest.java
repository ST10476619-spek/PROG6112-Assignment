package series;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog6112_poe.Series;
import prog6112_poe.SeriesApp;
import java.util.Scanner;

public class SeriesAppTest {

    private SeriesApp app;

    @class BeforeEach
    public void setup() {
        app = new SeriesApp(new Scanner(System.in));

        app.testAddSeries(new Series("S1", "Friends", "13", "10"));
        app.testAddSeries(new Series("S2", "Breaking Bad", "18", "62"));
    }

    @class Test
    public void TestSearchSeries_Found() {
        Series found = app.testSearchSeries("Friends");
        assertNotNull(found, "Series should be found");
        assertEquals("Friends", found.SeriesName);
    }

    @class Test
    public void TestSearchSeries_NotFound() {
        Series found = app.testSearchSeries("Unknown Show");
        assertNull(found, "Series should not be found");
    }

    @class Test
    public void TestUpdateSeries_Success() {
        boolean updated = app.testUpdateSeries("Friends", "16", "12");
        assertTrue(updated, "Update should be successful");

        Series updatedSeries = app.testSearchSeries("Friends");
        assertEquals("16", updatedSeries.SeriesAge);
        assertEquals("12", updatedSeries.SeriesNumberOfEpisodes);
    }

    @class Test
    public void TestUpdateSeries_NotFound() {
        boolean updated = app.testUpdateSeries("Unknown Show", "10", "5");
        assertFalse(updated, "Update should fail for non-existent series");
    }

    @class Test
    public void TestDeleteSeries_Success() {
        boolean deleted = app.testDeleteSeries("Breaking Bad");
        assertTrue(deleted, "Series should be deleted");

        Series result = app.testSearchSeries("Breaking Bad");
        assertNull(result, "Deleted series should not be found");
    }

    @class Test
    public void TestDeleteSeries_NotFound() {
        boolean deleted = app.testDeleteSeries("Unknown Show");
        assertFalse(deleted, "Delete should fail for non-existent series");
    }

    @class Test
    public void TestSeriesAgeRestriction_Valid() {

        assertTrue(app.testValidateAge("10"), "Age 10 should be valid");
        assertTrue(app.testValidateAge("18"), "Age 18 should be valid");
        assertTrue(app.testValidateAge("2"), "Age 2 should be valid");
    }

    @class Test
    public void TestSeriesAgeRestriction_Invalid() {
        assertFalse(app.testValidateAge("1"), "Age 1 should be invalid");
        assertFalse(app.testValidateAge("19"), "Age 19 should be invalid");
        assertFalse(app.testValidateAge("abc"), "Non-numeric age should be invalid");
    }

    private void assertNotNull(Series found, String series_should_be_found) {
        throw new UnsupportedOperationException("Not supported yet."); // from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String friends, String SeriesName) {
        throw new UnsupportedOperationException("Not supported yet."); // from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertNull(Series found, String series_should_not_be_found) {
        throw new UnsupportedOperationException("Not supported yet."); // from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertTrue(boolean updated, String update_should_be_successful) {
        throw new UnsupportedOperationException("Not supported yet."); // from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertFalse(boolean updated, String update_should_fail_for_nonexistent_series) {
        throw new UnsupportedOperationException("Not supported yet."); // from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
