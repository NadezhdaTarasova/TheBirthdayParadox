import java.util.*;

public class Solution {
    public static void main(String[] args) {
        experiment(10000);
    }

    public static ArrayList<Integer> generateNumbers(int quantity){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            int newNumber = (int) ((Math.random() * (365 - 1)) + 1);
            numbers.add(newNumber);
        }
        return numbers;
    }

    public static void printNumbers(ArrayList<Integer> numbers){
        int order = 1;
        for (Integer number: numbers) {
            System.out.print(order + ")" + number + "\t");
            order++;
        }
    }

    public static boolean isSimular(ArrayList<Integer> numbers){
        boolean areIdenticalNumbers = false;
        Map<Integer, Integer> identicalNumbers = new HashMap();
        for (int i = 0; i < numbers.size() ; i++) {
            if(Collections.frequency(numbers, numbers.get(i)) > 1){
                areIdenticalNumbers = true;
                identicalNumbers.put(i + 1, numbers.get(i));
            }
        }
        System.out.print("\nОдинаковые номера: ");
        for (Map.Entry<Integer, Integer> pair: identicalNumbers.entrySet()) {
            System.out.print(pair.getValue() + "(на позиции " + pair.getKey() + ")   ");
        }
        return areIdenticalNumbers;
    }

    public static void experiment(int quantity){
        int successfulAttempts = 0;
        for (int i = 0; i < quantity; i++) {
            ArrayList list = generateNumbers(23);
            printNumbers(list);
            boolean isSimularNumbers = isSimular(list);
            System.out.println("\nВ этом наборе есть одинаковые числа:\t" + isSimularNumbers);
            if(isSimularNumbers == true) successfulAttempts++;
        }
        double percent = (double)successfulAttempts/quantity;
        System.out.println("Среди " + quantity + " попыток " + successfulAttempts + " из них удачные. В процентах это составляет: " + percent*100 + "%");
    }
}
