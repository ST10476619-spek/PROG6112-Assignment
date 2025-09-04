package prog6112_poe;

public class Series {
    public String SeriesID;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;

    public Series(String seriesID, String seriesName, String seriesAge, String seriesNumberOfEpisodes) {
        this.SeriesID = seriesID;
        this.SeriesName = seriesName;
        this.SeriesAge = seriesAge;
        this.SeriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    public String getSeriesID() {
        return SeriesID;
    }

    public void setSeriesID(String SeriesID) {
        this.SeriesID = SeriesID;
    }

    public String getSeriesName() {
        return SeriesName;
    }

    public void setSeriesName(String SeriesName) {
        this.SeriesName = SeriesName;
    }

    public String getSeriesAge() {
        return SeriesAge;
    }

    public void setSeriesAge(String SeriesAge) {
        this.SeriesAge = SeriesAge;
    }

    public String getSeriesNumberOfEpisodes() {
        return SeriesNumberOfEpisodes;
    }

    public void setSeriesNumberOfEpisodes(String SeriesNumberOfEpisodes) {
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
    
    

    @Override
    public String toString() {
        return "Series ID: " + SeriesID +
                "\nSeries Name: " + SeriesName +
                "\nAge Restriction: " + SeriesAge +
                "\nNumber of Episodes: " + SeriesNumberOfEpisodes + "\n";
    }
    
}