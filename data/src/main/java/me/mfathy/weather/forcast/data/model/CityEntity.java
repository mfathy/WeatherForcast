package me.mfathy.weather.forcast.data.model;

public class CityEntity {

    private String key;
    private String localizedName;
    private Long rank;
    private String type;
    private Long version;

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

        public CityEntity.Builder withKey(String key) {
            this.key = key;
            return this;
        }

        public CityEntity.Builder withLocalizedName(String localizedName) {
            this.localizedName = localizedName;
            return this;
        }

        public CityEntity.Builder withRank(Long rank) {
            this.rank = rank;
            return this;
        }

        public CityEntity.Builder withType(String type) {
            this.type = type;
            return this;
        }

        public CityEntity.Builder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public CityEntity build() {
            CityEntity city = new CityEntity();
            city.key = key;
            city.localizedName = localizedName;
            city.rank = rank;
            city.type = type;
            city.version = version;
            return city;
        }

    }

}
