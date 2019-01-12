package me.mfathy.weather.forcast.domain.model;

public class City {

    private String key;
    private String localizedName;
    private Long rank;
    private String type;
    private Long version;

    @Override
    public String toString() {
        return localizedName;
    }

    public String getKey() {
        return key;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public Long getRank() {
        return rank;
    }

    public String getType() {
        return type;
    }

    public Long getVersion() {
        return version;
    }

    public static class Builder {

        private String key;
        private String localizedName;
        private Long rank;
        private String type;
        private Long version;

        public City.Builder withKey(String key) {
            this.key = key;
            return this;
        }

        public City.Builder withLocalizedName(String localizedName) {
            this.localizedName = localizedName;
            return this;
        }

        public City.Builder withRank(Long rank) {
            this.rank = rank;
            return this;
        }

        public City.Builder withType(String type) {
            this.type = type;
            return this;
        }

        public City.Builder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public City build() {
            City city = new City();
            city.key = key;
            city.localizedName = localizedName;
            city.rank = rank;
            city.type = type;
            city.version = version;
            return city;
        }

    }

}
