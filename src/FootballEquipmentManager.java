import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FootballEquipmentManager {
    private List<FootballEquipment> equipmentList;
    private static final String FILE_NAME = "equipment.json";
    private static final Gson gson = new Gson();

    public FootballEquipmentManager() {
        this.equipmentList = new ArrayList<>();
        loadFromFile(); // Завантаження при старті
    }

    public void addEquipment(FootballEquipment equipment) {
        equipmentList.add(equipment);
        saveToFile();
    }

    public void removeEquipment(String name) {
        equipmentList.removeIf(e -> e.getName().equalsIgnoreCase(name));
        saveToFile();
    }

    public void updateEquipment(String name, int newQuantity) {
        for (FootballEquipment equipment : equipmentList) {
            if (equipment.getName().equalsIgnoreCase(name)) {
                equipment.setQuantity(newQuantity);
                saveToFile();
                return;
            }
        }
    }

    public void readAllEquipment() {
        for (FootballEquipment equipment : equipmentList) {
            System.out.println(equipment);
        }
    }

    public void sortByPriceAscending() {
        equipmentList.sort(Comparator.comparingDouble(FootballEquipment::getPrice));
        saveToFile();
    }

    public void sortByPriceDescending() {
        equipmentList.sort((e1, e2) -> Double.compare(e2.getPrice(), e1.getPrice()));
        saveToFile();
    }

    public void sortByQuantityAscending() {
        equipmentList.sort(Comparator.comparingInt(FootballEquipment::getQuantity));
        saveToFile();
    }

    public void sortByQuantityDescending() {
        equipmentList.sort((e1, e2) -> Integer.compare(e2.getQuantity(), e1.getQuantity()));
        saveToFile();
    }

    private void saveToFile() {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(equipmentList, writer);
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (Reader reader = new FileReader(FILE_NAME)) {
            equipmentList = gson.fromJson(reader, new TypeToken<List<FootballEquipment>>() {}.getType());
            if (equipmentList == null) {
                equipmentList = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Помилка завантаження: " + e.getMessage());
        }
    }
    public void searchEquipmentByFields(String name, String size) {
        boolean found = false;
        for (FootballEquipment equipment : equipmentList) {
            if (equipment.getName().equalsIgnoreCase(name) && equipment.getSize().equalsIgnoreCase(size)) {
                System.out.println(equipment);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Не знайдено жодного елемента за цими критеріями.");
        }
    }
}