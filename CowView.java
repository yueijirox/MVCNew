import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CowView extends JFrame {
    private JTextField cowIdField = new JTextField(10);
    private JButton addCowButton = new JButton("Add ID");
    private JButton calculateMilkButton = new JButton("Produced Milk");
    private JTextArea resultArea = new JTextArea(10, 35);

    public CowView() {
        // จัด Layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Cows ID:"));
        panel.add(cowIdField);
        panel.add(addCowButton);
        panel.add(calculateMilkButton);

        resultArea.setEditable(false);
        panel.add(new JScrollPane(resultArea));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 300);
        this.add(panel);
    }

    // รับรหัสวัวจากผู้ใช้
    public String getCowId() {
        return cowIdField.getText();
    }

    // เพิ่ม Listener สำหรับปุ่มเพิ่มรหัสวัว
    public void addCowListener(ActionListener listener) {
        addCowButton.addActionListener(listener);
    }

    // เพิ่ม Listener สำหรับปุ่มคำนวณน้ำนม
    public void calculateMilkListener(ActionListener listener) {
        calculateMilkButton.addActionListener(listener);
    }

    // แสดงผลใน TextArea
    public void setResult(String result) {
        resultArea.setText(result);
    }
}
