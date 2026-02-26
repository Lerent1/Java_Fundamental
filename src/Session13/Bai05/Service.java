package Session13.Bai05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Service {
    private ArrayList<Patient> patientList = new ArrayList<>();
    public boolean isDuplicateId(String id) {
        for (Patient p : patientList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    public Patient findById(String id) {
        for (Patient p : patientList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean dischargePatient(String id) {
        Patient p = findById(id);
        if (p != null) {
            patientList.remove(p);
            return true;
        }
        return false;
    }

    public void sortPatients() {
        Collections.sort(patientList, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                if (p2.getAge() != p1.getAge()) {
                    return p2.getAge() - p1.getAge();
                }

                return p1.getFullName().compareToIgnoreCase(p2.getFullName());
            }
        });
    }

    public void displayAll() {
        if (patientList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        for (int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);
            System.out.println(p);
        }
    }
}
