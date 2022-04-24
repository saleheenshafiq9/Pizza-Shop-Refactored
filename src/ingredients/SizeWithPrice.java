package ingredients;

public class SizeWithPrice {
    static int SizeWithPrice(String size, int result) {
        switch (size) {
            case "large" -> result = 14;
            case "medium" -> result = 12;
            case "small" -> result = 10;
        }
        return result;
    }
}