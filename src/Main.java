import java.util.*;


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            FootballEquipmentManager manager = new FootballEquipmentManager();

            while (true) {
                System.out.println("Меню:");
                System.out.println("1. Додати нове екіпірування");
                System.out.println("2. Видалити екіпірування");
                System.out.println("3. Зчитати всі елементи");
                System.out.println("4. Оновити кількість");
                System.out.println("5. Пошук за назвою та розміром");
                System.out.println("6. Сортувати за ціною");
                System.out.println("7. Сортувати за кількістю");
                System.out.println("8. Вийти");
                System.out.print("Виберіть опцію: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Введіть назву екіпірування: ");
                        String name = scanner.nextLine();
                        System.out.print("Введіть розмір: ");
                        String size = scanner.nextLine();
                        System.out.print("Введіть кількість: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Введіть ціну: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();
                        Date purchaseDate = new Date();
                        FootballEquipment newEquipment = new FootballEquipment(name, size, quantity, price, purchaseDate);
                        manager.addEquipment(newEquipment);
                        break;

                    case 2:
                        System.out.print("Введіть назву екіпірування для видалення: ");
                        String removeName = scanner.nextLine();
                        manager.removeEquipment(removeName);
                        break;

                    case 3:
                        manager.readAllEquipment();
                        break;

                    case 4:
                        System.out.print("Введіть назву екіпірування для оновлення: ");
                        String updateName = scanner.nextLine();
                        System.out.print("Введіть нову кількість: ");
                        int newQuantity = scanner.nextInt();
                        manager.updateEquipment(updateName, newQuantity);
                        break;

                    case 5:
                        System.out.print("Введіть назву екіпірування для пошуку: ");
                        String searchName = scanner.nextLine();
                        System.out.print("Введіть розмір для пошуку: ");
                        String searchSize = scanner.nextLine();
                        manager.searchEquipmentByFields(searchName, searchSize);
                        break;

                    case 6:
                        System.out.println("1. За зростанням");
                        System.out.println("2. За спаданням");
                        System.out.print("Виберіть опцію сортування: ");
                        int sortByPriceChoice = scanner.nextInt();
                        if (sortByPriceChoice == 1) {
                            manager.sortByPriceAscending();
                        } else if (sortByPriceChoice == 2) {
                            manager.sortByPriceDescending();
                        }
                        manager.readAllEquipment();
                        break;

                    case 7:
                        System.out.println("1. За зростанням");
                        System.out.println("2. За спаданням");
                        System.out.print("Виберіть опцію сортування: ");
                        int sortByQuantityChoice = scanner.nextInt();
                        if (sortByQuantityChoice == 1) {
                            manager.sortByQuantityAscending();
                        } else if (sortByQuantityChoice == 2) {
                            manager.sortByQuantityDescending();
                        }
                        manager.readAllEquipment();
                        break;

                    case 8:
                        System.out.println("Вихід з програми.");
                        return;

                    default:
                        System.out.println("Невірний вибір! Спробуйте ще раз.");
                }
            }
        }
    }
}