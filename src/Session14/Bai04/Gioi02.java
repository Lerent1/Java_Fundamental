package Session14.Bai04;

import java.util.*;

public class Gioi02 {
    public static void main(String[] args) {
        List<String> diseases = Arrays.asList("Cum A", "Sot suat huyet", "Cum A", "Covid-19", "Cum A", "Sot xuat huyet");
        TreeMap<String, Integer> report = new TreeMap<>();
        for (String disease : diseases) {
            if (report.containsKey(disease)) {
                report.put(disease, report.get(disease) + 1);
            } else {
                report.put(disease, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue() + " ca");
        }
    }
}
