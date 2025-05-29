import java.util.Date;

public class FootballEquipment {
    private String name;     // Назва екіпірування
    private String size;     // Розмір
    private int quantity;    // Кількість
    private double price;    // Ціна
    private Date purchaseDate; // Дата придбання

    // Конструктор класу
    public FootballEquipment(String name, String size, int quantity, double price, Date purchaseDate) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    // Геттери
    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    // Сеттер для оновлення кількості
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Кількість не може бути від'ємною!");
        } else {
            this.quantity = quantity;
        }
    }

    @Override
    public String toString() {
        return "FootballEquipment{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}