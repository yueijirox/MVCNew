public class PlainMilk {
    public static double calculateMilk(Cow cow) {
        int totalMonths = cow.getTotalMonths();
        return 120 - totalMonths;
    }
}
