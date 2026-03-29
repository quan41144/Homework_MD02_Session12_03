package hwss1203;

public class Coffe extends Drink implements IPromotion {
    public Coffe(String id, String name, double price) {
        super(id, name, price);
    }
    @Override
    String prepare() {
        return "Pha bằng máy";
    }

    @Override
    public void applyDiscount(double percentage) {
    }
}
