import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppView extends JFrame {
    private static final long serialVersionUID = 1L;
    int width, height;
    JPanel mainPanel, titlePanel, finePanel, textPanel, radioPanel;
    JLabel titleLabel, speedLimitLabel, speedTestLabel, zoneLabel, fineLabel;
    JTextField speedLimitTextField, speedTestTextField = null;
    JRadioButton zoneRadioButtonYes, zoneRadioButtonNo;
    ButtonGroup zoneButtonGroup;
    public String titleString;
    public String speedLimitString;
    public String speedTestString;
    public String zoneString = "Zone:";
    public String fineString = "Fine: $0";
    public ActionListener zoneListener;
    public ActionListener textSpeedListener;
    public ActionListener textLimitListener;

    Calculations calc;

    public AppView(String title, ActionListener zListener, ActionListener t1Listener, ActionListener t2Listener, String limString, String testString) {
        super(title);
        this.titleString = title;
        this.zoneListener = zListener;
        this.textSpeedListener = t1Listener;
        this.textLimitListener = t2Listener;
        this.speedLimitString = limString;
        this.speedTestString = testString;

        setResizable(false);
        width = 800;
        height = 800;
        setBounds(400,400,width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLayout(new GridLayout(4,0));

        initComponents();
        // BorderLayout.CENTER
        mainPanel.add(titlePanel);
        mainPanel.add(textPanel);
        mainPanel.add(radioPanel);
        mainPanel.add(finePanel);
        add(mainPanel, BorderLayout.CENTER);

        calc = new Calculations();
        updateFineLabel();
        setVisible(true);
    }

    public int getSpeed(){
        String s = speedTestTextField.getText();
        int num = Integer.parseInt(s);
        return num;
    }

    public int getLimit(){
        String s = speedLimitTextField.getText();
        int num = Integer.parseInt(s);
        return num;
    }

    public boolean getZone(){
        if (zoneRadioButtonYes.isSelected())
            return true;
        else
            return false;
    }

    public void initComponents(){
        // PANELS
        // instantiate panels
        mainPanel = new JPanel(new GridLayout(4,0));
        titlePanel = new JPanel();
        textPanel = new JPanel(new GridLayout(2,2, 1, 1));
        radioPanel = new JPanel(new GridLayout(0,3));
        finePanel = new JPanel();

        // LABELS
        // instantiate labels
        titleLabel = new JLabel(titleString, JLabel.CENTER);
        speedLimitLabel = new JLabel(speedLimitString, JLabel.RIGHT);
        speedTestLabel = new JLabel(speedTestString, JLabel.LEFT);
        zoneLabel = new JLabel(zoneString, JLabel.LEFT);
        fineLabel = new JLabel(fineString, JLabel.LEFT);

        // RADIO BUTTONS & GROUP
        // instantiate radio button
        zoneRadioButtonYes = new JRadioButton("Yes");
        zoneRadioButtonYes.setActionCommand("zoneRadioButtonYes");
        zoneRadioButtonYes.addActionListener(zoneListener);
        zoneRadioButtonNo = new JRadioButton("No");
        zoneRadioButtonNo.setSelected(true);
        zoneRadioButtonNo.setActionCommand("zoneRadioButtonNo");
        zoneRadioButtonNo.addActionListener(zoneListener);
        // instantiate radio group
        zoneButtonGroup = new ButtonGroup();
        // add buttons to group
        zoneButtonGroup.add(zoneRadioButtonYes);
        zoneButtonGroup.add(zoneRadioButtonNo);

        // TEXT FIELDS
        // instantiate text fields
        speedLimitTextField = new JTextField(1);
        speedLimitTextField.setText("0");
        speedLimitTextField.setActionCommand(speedLimitString);
        speedLimitTextField.addActionListener(textSpeedListener);
        speedTestTextField = new JTextField(1);
        speedTestTextField.setText("0");
        speedTestTextField.setActionCommand(speedTestString);
        speedTestTextField.addActionListener(textLimitListener);

        // add components to panels
        titlePanel.add(titleLabel);
        finePanel.add(fineLabel);
        textPanel.add(speedLimitLabel);
        textPanel.add(speedLimitTextField);
        textPanel.add(speedTestLabel);
        textPanel.add(speedTestTextField);
        radioPanel.add(zoneLabel);
        radioPanel.add(zoneRadioButtonYes);
        radioPanel.add(zoneRadioButtonNo);
        finePanel.add(fineLabel);
        // set borders
        // titlePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        // finePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        // textPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        // radioPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void updateSpeed(){
        System.out.println("Speed: " + getSpeed());
       calc.updateSpeed(getSpeed());
        updateFineLabel();
    }
    public void updateLimit(){
        System.out.println("Limit: " + getLimit());
        calc.updateLimit(getLimit());
        updateFineLabel();
    }

    public void updateZone(boolean value) {
        // calc.updateZone(getZone());
        System.out.println("Zone: " + getZone());
        calc.updateZone(value);
        updateFineLabel();
    }

    /**
     * Updates fine label string based on fine if string or int
     */
    public void updateFineLabel(){
        int num = calc.runCalculations();
        System.out.println(num);
        if (num > -1)
            updateFineLabel(num);
        else
            updateFineLabel(calc.OVER_30_STRING);
    }

    /**
     * Updates Fine Label with amount of fine with inputted amount
     * @param amount
     */
    public void updateFineLabel(int amount) {
        fineString = "Fine: $" + amount + "";
        fineLabel.setText(fineString);
    }
    /**
     * Updates Fine Label with string message
     * @param msg
     */
    public void updateFineLabel(String msg) {
        fineString = "Fine: $" + msg + "";
        fineLabel.setText(fineString);
    }


}
