package org.app.GUI.Component;

import org.app.Customer.CustomerSelector;
import org.app.Customer.Member;
import org.app.Customer.VIP;
import org.app.GUI.Component.Features.GUIUtil;
import org.app.GUI.MainGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class MemberList extends JPanel {
    private final int columnSize = 6;
    private JPanel memberPanel;
    private int memberSize;
    private Component components[][];
    private String values[][];
    private ArrayList<JButton> editButtons;
    private boolean isEditing;
    private MainGUI mainGUI;
    public MemberList(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
        memberPanel = new JPanel();
        this.setName("Member List");

        CustomerSelector customerSelector = new CustomerSelector(mainGUI.dataStore.customers());
        ArrayList<Member> members = (ArrayList<Member>)(customerSelector.addMember().addVIP().getAsMember());

        memberSize = members.size();
        components = new Component[memberSize][columnSize - 1];
        values = new String[memberSize][columnSize - 1];

        for(int i=0;i<memberSize;i++){
            values[i][0] = String.valueOf(members.get(i).getId());
            values[i][1] = members.get(i).getName();
            values[i][2] = members.get(i).getTelephoneNumber();
            values[i][3] = members.get(i).isActive() ? "Active" : "Deactive";
            values[i][4] = members.get(i).getClass().equals(VIP.class) ? "VIP" : "Member";
        }

        editButtons = new ArrayList<>();
        for(int i=0;i<memberSize;i++){
            for(int j=0;j<columnSize - 1;j++) {
                components[i][j] = new JLabel(values[i][j]);
            }
            editButtons.add(new JButton("Edit"));
            editButtons.get(i).addActionListener(editAction());
        }

        JScrollPane scrollPane = new JScrollPane(memberPanel);
        memberPanel.setLayout(new GridLayout(memberSize + 1, 6));

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.setLayout(new BorderLayout());
        this.add(scrollPane);
        isEditing = false;
        refresh();
    }

    private void toggleEditing(int index) {
        isEditing = !isEditing;
        if(isEditing) {
            components[index][1] = new JTextField(values[index][1]);
            JTextField numberField = new JTextField(values[index][2]);
            numberField.addKeyListener(GUIUtil.numericTextFieldListener());
            components[index][2] = numberField;
            String[] actives = {"Active", "Deactive"};
            JComboBox<String> activeComboBox = new JComboBox<String>(actives);
            activeComboBox.setSelectedItem(values[index][4]);
            components[index][3] = activeComboBox;
            String[] memberType = {"Member", "VIP"};
            JComboBox<String> VIPComboBox = new JComboBox<String>(memberType);
            VIPComboBox.setSelectedItem(values[index][4]);
            components[index][4] = VIPComboBox;

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(saveAction(index));
            editButtons.set(index, saveButton);
        }else {
            for(int i=0;i<memberSize;i++){
                for(int j=0;j<columnSize - 1;j++) {
                    components[i][j] = new JLabel(values[i][j]);
                }
            }

            JButton editButton = new JButton("Edit");
            editButton.addActionListener(editAction());
            editButtons.set(index, editButton);
        }
        for(int i=0;i<memberSize;i++){
            if(i != index){
                editButtons.get(i).setEnabled(!isEditing);
            }
        }
        refresh();
    }


    private ActionListener editAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = editButtons.indexOf(e.getSource());
                toggleEditing(index);
            }
        };
    }
    private ActionListener saveAction(int index) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(values[index][0]);
                values[index][1] = ((JTextField) components[index][1]).getText();
                values[index][2] = ((JTextField) components[index][2]).getText();
                values[index][3] = ((JComboBox<String>) components[index][3]).getSelectedItem().toString();
                values[index][4] = ((JComboBox<String>) components[index][4]).getSelectedItem().toString();
                double point = ((Member) mainGUI.dataStore.customers().getCustomerFromID(id)).getPoint();


                if(values[index][4].equals("Member")) {
                    mainGUI.dataStore.customers().turnToMember(
                            id,
                            values[index][1],
                            values[index][2],
                            point,
                            values[index][3].equals("Active")
                    );
                }else {
                    mainGUI.dataStore.customers().turnToVIP(
                            id,
                            values[index][1],
                            values[index][2],
                            point,
                            values[index][3].equals("Active")
                    );
                }
                toggleEditing(index);
            }
        };
    }


    private void refresh() {
        memberPanel.removeAll();
        memberPanel.revalidate();
        memberPanel.repaint();

        memberPanel.add(new JLabel("ID"));
        memberPanel.add(new JLabel("Name"));
        memberPanel.add(new JLabel("Number"));
        memberPanel.add(new JLabel("Status"));
        memberPanel.add(new JLabel("Type"));
        memberPanel.add(new JLabel("Edit"));

        for(int i=0;i<memberSize;i++) {
            for(int j=0;j<columnSize - 1;j++){
                memberPanel.add(components[i][j]);
            }
            memberPanel.add(editButtons.get(i));
        }
    }

}
