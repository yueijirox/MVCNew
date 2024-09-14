import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CowController {
    private CowModel model;
    private CowView view;
    private List<Cow> selectedCows = new ArrayList<>(); // เก็บวัวที่กรอกรหัสแล้ว

    public CowController(CowModel model, CowView view) {
        this.model = model;
        this.view = view;

        // Listener สำหรับการเพิ่มรหัสวัว
        this.view.addCowListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddCow();
            }
        });

        // Listener สำหรับการผลิตน้ำนม
        this.view.calculateMilkListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCalculateMilk();
            }
        });
    }

    // ฟังก์ชันเมื่อผู้ใช้กดเพิ่มรหัสวัว
    private void handleAddCow() {
        String cowId = view.getCowId();
        if (isValidCowId(cowId)) {
            Cow cow = model.findCowById(cowId);
            if (cow != null) {
                selectedCows.add(cow);
                view.setResult("Added Cow ID: " + cowId);
            } else {
                view.setResult("Error: Cow ID not found.");
            }
        } else {
            view.setResult("Error: Invalid Cow ID. Please enter an 8-digit number that does not start with 0.");
        }
    }

    // ฟังก์ชันเมื่อผู้ใช้กดผลิตน้ำนม
    private void handleCalculateMilk() {
        double totalMilk = 0;
        for (Cow cow : selectedCows) {
            switch (cow.getBreed()) {
                case "White":
                    totalMilk += PlainMilk.calculateMilk(cow);
                    break;
                case "Brown":
                    totalMilk += ChocolateMilk.calculateMilk(cow);
                    break;
                case "Pink":
                    totalMilk += StrawberryMilk.calculateMilk(cow);
                    break;
            }
        }
        view.setResult("Total Milk Produced: " + totalMilk + " liters");
        selectedCows.clear(); // รีเซ็ตลิสต์วัวหลังคำนวณเสร็จ
    }

    // ฟังก์ชันตรวจสอบรหัสวัว
    private boolean isValidCowId(String cowId) {
        return cowId.matches("^[1-9][0-9]{7}$");
    }
}
