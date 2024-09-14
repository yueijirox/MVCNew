import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class CowModel {
    private List<Cow> cows;

    public CowModel() {
        cows = new ArrayList<>();
        loadCowData();
    }

    private void loadCowData() {
        try (BufferedReader br = new BufferedReader(new FileReader("cows.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String breed = data[1];
                int ageYears = Integer.parseInt(data[2]);
                int ageMonths = Integer.parseInt(data[3]);
                cows.add(new Cow(id, breed, ageYears, ageMonths));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cow findCowById(String id) {
        for (Cow cow : cows) {
            if (cow.getId().equals(id)) {
                return cow;
            }
        }
        return null;
    }
}
