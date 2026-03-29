package hwss1203;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Drink> list = new ArrayList<>();
    public static void main(String[] args) {
        while(true){
            System.out.println("============ COFFE AND FRUITS ============");
            System.out.println("1. Thêm món vào menu");
            System.out.println("2. Hiển thị menu");
            System.out.println("3. Áp dụng mã giảm giá");
            System.out.println("4. Xóa món");
            System.out.println("5. Thống kê");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    addMenu();
                    break;
                case 2:
                    showDrink();
                    break;
                case 3:
                    applyDiscount();
                    break;
                case 4:
                    deleteDrink();
                    break;
                case 5:
                    showStatistical();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private static void addMenu() {
        System.out.println("1. Coffe");
        System.out.println("2. Fruit");
        int choice1 = Integer.parseInt(sc.nextLine());
        switch(choice1){
            case 1:
                System.out.print("Coffe ID: ");
                String id1 = sc.nextLine();
                System.out.print("Coffe name: ");
                String name1 = sc.nextLine();
                System.out.print("Coffe price: ");
                double price1 = Double.parseDouble(sc.nextLine());
                list.add(new Coffe(id1, name1, price1));
                System.out.println("Added Coffe!");
                break;
            case 2:
                System.out.print("Fruit ID: ");
                String id2 = sc.nextLine();
                System.out.print("Fruit name: ");
                String name2 = sc.nextLine();
                System.out.print("Fruit price: ");
                double price2 = Double.parseDouble(sc.nextLine());
                list.add(new FruitTea(id2, name2, price2));
                System.out.println("Added Fruit!");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
    private static void showDrink() {
        System.out.println("============= Drink Menu ============");
        System.out.println("1. Coffe");
        for (Drink drink : list) {
            if (drink instanceof Coffe) {
                System.out.println(" - " + drink.getName() + " - " +  drink.getPrice());
            }
        }
        System.out.println("2. Fruit");
        for (Drink drink : list) {
            if (drink instanceof FruitTea) {
                System.out.println(" - " + drink.getName() + " - " +  drink.getPrice());
            }
        }
    }
    private static void applyDiscount() {
        double discount;
        do {
            System.out.print("Input your discount: ");
            discount = Double.parseDouble(sc.nextLine());
            if (discount < 0.0 || discount > 100.0) {
                System.out.println("Invalid input!");
            }
        }while(discount < 1.0 || discount > 100.0);
        for (Drink drink : list) {
            drink.setPrice(drink.getPrice() * (100.0 - discount) / 100.0);
        }
        System.out.println("Apllied discount!");
    }
    private static void deleteDrink() {
        System.out.print("Input drink ID to delete: ");
        String id = sc.nextLine().toLowerCase().trim();
        list.removeIf(drink -> drink.getId().toLowerCase().trim().equalsIgnoreCase(id));
        System.out.println("Deleted!");
    }
    private static void showStatistical() {
        double sum = 0;
        for (Drink drink : list) {
            sum += drink.getPrice();
        }
        System.out.println("Count Drinks: " + list.size());
        System.out.println("Average price: " + sum / list.size());
    }
}
