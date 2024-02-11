package view;

import logic.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUIPlatform extends JFrame{
    private final Color PANELS_COLOR = new Color(41,20,20);
    private final Color BUTTONS_COLOR = new Color(20,32,41);
    private Controller control = new Controller();
    private JPanel panelOptions = new JPanel();
    private JPanel panelBtn = new JPanel();
    private JPanel panelInformationText = new JPanel();

    private JButton btnGenerate = new JButton("Generar ruta");

    String[] arrayCities = {"Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena", "Bucaramanga", "Cúcuta", "Santa Marta",
            "Pereira", "Villavicencio"};
    private JComboBox comboCityOrigin = new JComboBox(arrayCities);
    private JComboBox comboCityDestiny = new JComboBox(arrayCities);

    private JTextArea areaInformation = new JTextArea(8, 27);
    private JScrollPane scrollInformation = new JScrollPane(areaInformation, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public GUIPlatform() {
        super("Routes");
        setSize(600, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(PANELS_COLOR);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        launchPanels();
    }

    public void launchPanels() {
        optionsMenu();
        watchInformation();
    }

    private void optionsMenu() {
        configPanel(panelOptions, new FlowLayout());
        panelOptions.add(comboCityOrigin);
        panelOptions.add(comboCityDestiny);
        panelOptions.add(btnGenerate);

        configPanel(panelBtn, new GridLayout(1, 1));
        addButtonToPanel(btnGenerate, panelBtn, e -> {
            areaInformation.setText(control.showRoute(comboCityOrigin.getSelectedIndex(), comboCityDestiny.getSelectedIndex()));
        });

        this.add(panelBtn, BorderLayout.SOUTH);
        this.add(panelOptions, BorderLayout.NORTH);
    }

    private void watchInformation() {
        configPanel(panelInformationText, new FlowLayout());
        areaInformation.setText("");
        areaInformation.setLineWrap(true);
        areaInformation.setEditable(false);
        panelInformationText.add(scrollInformation);
        this.add(panelInformationText, BorderLayout.CENTER);
    }

    private void configPanel(JPanel panel, LayoutManager layout) {
        panel.setLayout(layout);
        panel.setBackground(PANELS_COLOR);
    }


    private void configButtons(JButton button) {
        button.setBackground(BUTTONS_COLOR);
        button.setForeground(Color.WHITE);
    }


    private void addButtonToPanel(JButton button, JPanel panel, ActionListener listener) {
        configButtons(button);
        button.addActionListener(listener);
        panel.add(button);
    }
}
