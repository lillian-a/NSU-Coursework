import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    AppView view;
    public String speedLimitString = "Speed Limit:";
    public String speedTestString = "Speed:";
    public String zoneRadioNoString = "zoneRadioButtonNo";
    public String zoneRadioYesString = "zoneRadioButtonYes";


    public Controller() {

        super();

        java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				view = new AppView("Speed Tester & Fine Calculator", new ZoneListener(), new TextFieldListener(), new TextFieldListener(), speedLimitString, speedTestString);
				view.setVisible(true);

			}
		});
    }

    // Listener used to process click on New Game Button
    class ZoneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Zone radio button changed...");
            if(zoneRadioYesString.equals(event.getActionCommand())) {
                view.updateZone(true);
            } else {
                view.updateZone(false);
            }
            // gameView.newGame(threshold);
        }

    }
    // Listener used to process click on New Game Button
    class TextFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Text field changed...");
            if (speedLimitString.equals(event.getActionCommand())){
                view.updateLimit();
            }
            else {
                view.updateSpeed();
            }
        }

    }
}
