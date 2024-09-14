public class StrawberryMilk {
    public static double calculateMilk(Cow cow) {
        int ageMonths = cow.getAgeMonths();
        return 30 - ageMonths;
    }
}
