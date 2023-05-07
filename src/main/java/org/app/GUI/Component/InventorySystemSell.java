package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.app.GUI.Component.Features.GUIUtil;
import org.app.GUI.MainGUI;
import org.app.Inventory.Item.Item;
import org.app.money.MoneyDecorator;
import org.app.money.MoneyHolder;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class InventorySystemSell extends JPanel {
    private JButton editButton;
    private JButton cancelButton;
    private JButton saveButton;
    private JButton deleteButton;

    private JButton tambahButton;
    private JList<String> list1;
    private boolean isEditing;
    private boolean isAdding;
    private JComponent itemDescriptions[];
    private MainGUI mainGUI;
    private String inputImagePath;
    private JButton inputImageButton;
    private int listSelectedIndex;
    public InventorySystemSell(MainGUI mainGUI) {
        this.setLayout(new GridLayoutManager(8, 4, new Insets(0, 0, 0, 0), -1, -1));
        editButton = new JButton();
        editButton.setText("Edit");
        tambahButton = new JButton();
        tambahButton.setText("Tambah");

        this.mainGUI = mainGUI;
        userDefinedConfig();
        refresh();
    }

    public void userDefinedConfig() {
        this.setName("Inventory System Sell");

        isEditing = false;
        isAdding = false;

        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        saveButton = new JButton();
        saveButton.setText("Save");
        inputImageButton = new JButton();
        inputImageButton.setText("Select");

        itemDescriptions = new JComponent[6];
        for(int i=0;i<6;i++){
            itemDescriptions[i] = new JLabel();
        }

        editButton.addActionListener(editButtonAction());
        tambahButton.addActionListener(tambahButtonAction());
        cancelButton.addActionListener(cancelButtonAction());
        saveButton.addActionListener(saveButtonAction());
        deleteButton.addActionListener(deleteButtonAction());
        inputImageButton.addActionListener(inputImageButtonAction());
    }

    private ActionListener editButtonAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(listSelectedIndex != -1) {
                    toggleEditing();
                }
            }
        };
    }

    private ActionListener deleteButtonAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.dataStore.inventory().removeItem(
                mainGUI.dataStore.inventory().getItem(listSelectedIndex));
                listSelectedIndex = -1;
                refresh();
            }
        };
    }

    private ListSelectionListener listAction() {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int index = list1.getSelectedIndex();
                    Item item = mainGUI.dataStore.inventory().getItem(index);
                    itemDescriptions[0] = new JLabel(item.itemName());
                    itemDescriptions[1] = new JLabel(item.category());
                    itemDescriptions[2] = new JLabel(String.valueOf(item.sellingPrice()));
                    itemDescriptions[3] = new JLabel(String.valueOf(item.purchasePrice()));
                    itemDescriptions[4] = new JLabel(String.valueOf(item.stock()));
                    listSelectedIndex = index;
                    refresh();
                }
            }
        };
    }

    private ActionListener tambahButtonAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isAdding = true;
                toggleEditing();
            }
        };
    }

    private ActionListener cancelButtonAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleEditing();
                isAdding = false;
            }
        };
    }

    private ActionListener saveButtonAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try{
                    MoneyHolder sellPrice = MoneyDecorator.money.cloneMoney();
                    sellPrice.setMoney(Double.valueOf(((JTextField) itemDescriptions[2]).getText()));
                    MoneyHolder purchasePrice = MoneyDecorator.money.cloneMoney();
                    purchasePrice.setMoney(Double.valueOf(((JTextField) itemDescriptions[3]).getText()));
                    if(isAdding) {
                        mainGUI.dataStore.inventory().addItem(
                                Item.builder()
                                        .itemName(((JTextField) itemDescriptions[0]).getText())
                                        .category(((JTextField) itemDescriptions[1]).getText())
                                        .sellingPrice(sellPrice)
                                        .purchasePrice(purchasePrice)
                                        .stock(Integer.valueOf(((JTextField) itemDescriptions[4]).getText()))
                                        .imagePath(inputImagePath)
                                        .build()
                        );
                        isAdding = false;
                    }else {
                        Item item = mainGUI.dataStore.inventory().getItem(listSelectedIndex);
                        item.itemName(((JTextField) itemDescriptions[0]).getText())
                            .category(((JTextField) itemDescriptions[1]).getText())
                            .sellingPrice(sellPrice)
                            .imagePath(inputImagePath);
                        item.purchasePrice(purchasePrice)
                            .stock(Integer.valueOf(((JTextField) itemDescriptions[4]).getText()));
                    }
                    toggleEditing();
                }catch(Exception e) {
                    System.out.println("Input cannot be empty");
                }
            }
        };
    }

    private void toggleEditing() {
        isEditing = !isEditing;
        if(isEditing) {
            itemDescriptions[0] = new JTextField(((JLabel)itemDescriptions[0]).getText());
            itemDescriptions[1] = new JTextField(((JLabel)itemDescriptions[1]).getText());
            itemDescriptions[2] = new JTextField(0);
            itemDescriptions[2].addKeyListener(GUIUtil.numericTextFieldListener());
            itemDescriptions[3] = new JTextField(0);
            itemDescriptions[3].addKeyListener(GUIUtil.numericTextFieldListener());
            itemDescriptions[4] = new JTextField(0);
            itemDescriptions[4].addKeyListener(GUIUtil.numericTextFieldListener());
        }else {
            itemDescriptions[0] = new JLabel();
            itemDescriptions[1] = new JLabel();
            itemDescriptions[2] = new JLabel();
            itemDescriptions[3] = new JLabel();
            itemDescriptions[4] = new JLabel();
            itemDescriptions[5] = new JLabel();
        }
        refresh();
        list1.setEnabled(!isEditing);
        tambahButton.setEnabled(!isEditing);
    }

    private ActionListener inputImageButtonAction() {
        return new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser dialog = new JFileChooser();
                dialog.setCurrentDirectory(new File(System.getProperty("user.dir")));

                int choice = dialog.showSaveDialog(null);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    String filepath = dialog.getSelectedFile().getAbsolutePath();
                    inputImagePath = filepath;
                }
            }
        };
    }

    private void refresh() {
        this.removeAll();
        this.revalidate();
        this.repaint();
        final JLabel label1 = new JLabel();
        label1.setText("Jual Barang");
        this.add(label1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Nama Barang");
        this.add(label2, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Kategori");
        this.add(label4, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Harga Jual");
        this.add(label5, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Harga Beli");
        this.add(label6, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Stock");
        this.add(label7, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Gambar");
        this.add(label8, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        this.add(tambahButton, new GridConstraints(0, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        this.add(scrollPane1, new GridConstraints(1, 0, 7, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        ArrayList<Item> items = (ArrayList<Item>) mainGUI.dataStore.inventory().itemList();
        String[] data = new String[items.size()];
        String[] imagePaths = new String[items.size()];
        for(int i=0;i<items.size();i++){
            data[i] = items.get(i).itemName();
            imagePaths[i] = items.get(i).imagePath();
        }
        list1 = new JList<>(data);

        list1.setSelectedIndex(listSelectedIndex);
        list1.setCellRenderer(GUIUtil.imageListRenderer(imagePaths));
        scrollPane1.setViewportView(list1);
        list1.addListSelectionListener(listAction());

        for(int i=0;i<5;i++){
            this.add(itemDescriptions[i], new GridConstraints(i+1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        }

        if(isEditing){
            this.add(inputImageButton, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
            this.add(cancelButton, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
            this.add(saveButton, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        }else{
            this.add(itemDescriptions[5], new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
            this.add(editButton, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
            this.add(deleteButton, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        }
    }
}
