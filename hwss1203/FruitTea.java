package hwss1203;

public class FruitTea extends Drink implements IPromotion {
    public FruitTea(String id, String name, double price) {
        super(id, name, price);
    }
    @Override
    String prepare() {
        return "Lắc với đá và trái cây tươi";
    }

    @Override
    public void applyDiscount(double percentage) {
    }
}
