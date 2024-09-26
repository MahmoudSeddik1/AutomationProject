package enums;

public class Enums {

    public enum Country{

        KSA("KSA"),
        Kuwait("Kuwait"),
        Bahrain("Bahrain");

        String value;
        Country(String value) {
            this.value =value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Subscription {
        Lite,
        Classic,
        Premium
    }
}
