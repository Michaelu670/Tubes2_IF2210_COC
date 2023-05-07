package org.app.GUI.Component;

import javax.swing.*;
import java.awt.*;

public class MemberList extends JPanel {
    private final int columnSize = 6;
    private JPanel memberPanel;
    private int memberSize;
    private Component components[][];
    public MemberList() {
        memberSize = 5; // TODO
        components = new Component[memberSize][columnSize];
        JScrollPane scrollPane = new JScrollPane(memberPanel);
        memberPanel.setLayout(new GridLayout(memberSize + 1, 6));

        // TODO get data from member

        this.add(scrollPane);
    }

    private void toggleEditing(int index) {

    }

    private void refresh() {
        removeAll();
        revalidate();
        repaint();

        add(new JLabel("ID"));
        add(new JLabel("Name"));
        add(new JLabel("Number"));
        add(new JLabel("Status"));
        add(new JLabel("Type"));
        add(new JLabel("Edit"));

        for(int i=0;i<memberSize;i++) {
            for(int j=0;j<columnSize;j++){
                add(components[i][j]);
            }
        }
    }


}
