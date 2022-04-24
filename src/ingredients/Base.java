package ingredients;

public interface Base {
    public default String ThinCrust() {
        return "Thin Crust";
    };
    public default String CheeseCrust() {
        return "Cheese Crust";
    }
    public default String DeepPan() {
        return "Deep Pan";
    }
}
