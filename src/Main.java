import java.util.*;

class PBook {
    private final Map<String, List<String>> phoneBook;
    public PBook() {
        this.phoneBook = new HashMap<>();
    }
    public void add(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }
    public List<String> getPhone(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }
    public String getKey() {

        return phoneBook.keySet().toString();
    }

    public static void main(String[] args) {
        PBook phoneBook = new PBook();
        phoneBook.add("Иванов", "+1233435490");
        phoneBook.add("Иванов", "+1234567890");
        phoneBook.add("Иванов", "+0987654321");
        phoneBook.add("Сидоров", "+1111222233");
        phoneBook.add("Петров", "+1495222233");
        phoneBook.add("Петров", "+1495222547");

        ArrayList <Integer> arraylist = new ArrayList<>();
        String[] split_str = phoneBook.getKey().replaceAll("[\\[\\]]","").split(", ");
        for (String s : split_str) {
            arraylist.add(phoneBook.getPhone(s).size());
        }
        Collections.sort(arraylist);
        Collections.reverse(arraylist);
        for (Integer integer : arraylist) {
            for (String s : split_str) {
                if (phoneBook.getPhone(s).size() == integer) {
                    System.out.println("Фамилия: " + s + ", телефон: " + phoneBook.getPhone(s));
                }
            }
        }
    }
}
