public class Main {
    public static void main(String[] args) {
        CowModel model = new CowModel();
        CowView view = new CowView();
        CowController controller = new CowController(model, view);
        view.setVisible(true);
    }
}
