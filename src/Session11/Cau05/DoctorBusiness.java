package Session11.Cau05;

import java.util.List;
import java.util.Map;

public class DoctorBusiness {
    private final DoctorDAO doctorDAO;

    public DoctorBusiness() {
        doctorDAO = new DoctorDAO();
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.findAll();
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        validateDoctor(doctor);
        return doctorDAO.insertDoctor(doctor);
    }

    public Map<String, Integer> getDoctorStatisticsBySpecialty() {
        return doctorDAO.countBySpecialty();
    }

    private void validateDoctor(Doctor doctor) throws Exception {
        if (doctor.getDoctorId() == null || doctor.getDoctorId().trim().isEmpty()) {
            throw new Exception("Mã bác sĩ không được để trống.");
        }

        if (doctor.getFullName() == null || doctor.getFullName().trim().isEmpty()) {
            throw new Exception("Họ tên không được để trống.");
        }

        if (doctor.getSpecialty() == null || doctor.getSpecialty().trim().isEmpty()) {
            throw new Exception("Chuyên khoa không được để trống.");
        }

        if (doctor.getDoctorId().length() > 10) {
            throw new Exception("Mã bác sĩ không được vượt quá 10 ký tự.");
        }

        if (doctor.getFullName().length() > 100) {
            throw new Exception("Họ tên không được vượt quá 100 ký tự.");
        }

        if (doctor.getSpecialty().length() > 50) {
            throw new Exception("Chuyên khoa không được vượt quá 50 ký tự.");
        }
    }
}