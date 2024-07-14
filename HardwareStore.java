
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HardwareStore {
    public static void main(String[] args) {
        Set<LapTop> laptops = new HashSet<>(Arrays.asList(
                new LapTop("8GB", "1TB", "Windows", "Black"),
                new LapTop("16GB", "512GB", "MacOS", "Silver"),
                new LapTop("8GB", "256GB", "Linux", "Black"),
                new LapTop("32GB", "1TB", "Windows", "White")));

        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "RAM");
        criteria.put(2, "HDD");
        criteria.put(3, "OS");
        criteria.put(4, "Color");

        Map<String, String> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        while (true) {
            System.out.print("Введите критерий (или 0 для завершения): ");
            int criterion = scanner.nextInt();
            if (criterion == 0)
                break;
            if (criteria.containsKey(criterion)) {
                System.out.print("Введите минимальное значение для " + criteria.get(criterion) + ": ");
                String value = scanner.next();
                filters.put(criteria.get(criterion), value);
            } else {
                System.out.println("Неверный критерий.");
            }
        }
        scanner.close();

        Set<LapTop> filteredLaptops = filterLaptops(laptops, filters);
        System.out.println("Ноутбуки, соответствующие критериям:");
        for (LapTop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }

    public static Set<LapTop> filterLaptops(Set<LapTop> laptops, Map<String, String> filters) {
        Set<LapTop> filteredLaptops = new HashSet<>(laptops);
        for (Map.Entry<String, String> filter : filters.entrySet()) {
            filteredLaptops.removeIf(laptop -> {
                switch (filter.getKey()) {
                    case "RAM":
                        return !laptop.ram.equals(filter.getValue());
                    case "HDD":
                        return !laptop.hdd.equals(filter.getValue());
                    case "OS":
                        return !laptop.os.equals(filter.getValue());
                    case "Color":
                        return !laptop.color.equals(filter.getValue());
                    default:
                        return true;
                }
            });
        }
        return filteredLaptops;

    }
}