package Session14.Bai03;

import java.util.HashSet;
import java.util.Set;

public class Gioi01 {
    public static void main(String[] args) {
        Set<String> drug = new HashSet<>();
        drug.add("Aspirin");
        drug.add("Caffeine");
        drug.add("Paracetamol");

        Set<String> allergy = new HashSet<>();
        allergy.add("Penicillin");
        allergy.add("Aspirin");

        Set<String> warning = new HashSet<>(drug);
        warning.retainAll(allergy);

        Set<String> safe = new HashSet<>(drug);
        safe.removeAll(allergy);

        System.out.println("Canh bao di ung: " + warning);
        System.out.println("Thanh phan an toan: " + safe);
    }
}
