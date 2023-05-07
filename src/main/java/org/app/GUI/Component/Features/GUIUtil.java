package org.app.GUI.Component.Features;

import org.app.Inventory.Item.BillItem;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;


public class GUIUtil {
    public static KeyAdapter numericTextFieldListener(){
        return new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9'))
                        && (c != '\b')) {
                    e.consume();
                }
            }
        };
    }

    public static ListCellRenderer<? super String> imageListRenderer(String imagePaths[]){
        return (list2, value, index, isSelected, cellHasFocus) -> {
            JLabel label = new JLabel(value);

            label.setIcon(getImage(imagePaths[index]));
            label.setVerticalTextPosition(JLabel.CENTER);
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(Color.RED);
            label.setOpaque(true);
            if (isSelected) {
                label.setBackground(list2.getSelectionBackground());
                label.setForeground(list2.getSelectionForeground());
            } else {
                label.setBackground(list2.getBackground());
                label.setForeground(list2.getForeground());
            }

            return label;
        };
    }

    public static ImageIcon getImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    public static class ItemCellRenderer implements ListCellRenderer<BillItem> {
        private JPanel panel;
        private JLabel nameLabel;
        private JLabel quantityLabel;

        public ItemCellRenderer() {
            panel = new JPanel(new BorderLayout());
            nameLabel = new JLabel();
            quantityLabel = new JLabel();
            panel.add(nameLabel, BorderLayout.WEST);
            panel.add(quantityLabel, BorderLayout.EAST);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends BillItem> list, BillItem item, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            nameLabel.setText(item.itemName());
            if(item.quantity() == 0){
                quantityLabel.setText("Quantity");
            }else{
                quantityLabel.setText(String.valueOf(item.quantity()));
            }
            panel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            return panel;
        }
    }

    public static class ImageFilter extends FileFilter {
        public final static String JPEG = "jpeg";
        public final static String JPG = "jpg";
        public final static String GIF = "gif";
        public final static String TIFF = "tiff";
        public final static String TIF = "tif";
        public final static String PNG = "png";
        
        @Override
        public boolean accept(File f) {
           if (f.isDirectory()) {
              return true;
           }
     
           String extension = getExtension(f);
           if (extension != null) {
              if (extension.equals(TIFF) ||
                 extension.equals(TIF) ||
                 extension.equals(GIF) ||
                 extension.equals(JPEG) ||
                 extension.equals(JPG) ||
                 extension.equals(PNG)) {
                 return true;
              } else {
                 return false;
              }
           }
           return false;
        }
     
        @Override
        public String getDescription() {
           return "Image Only";
        }
     
        String getExtension(File f) {
           String ext = null;
           String s = f.getName();
           int i = s.lastIndexOf('.');
        
           if (i > 0 &&  i < s.length() - 1) {
              ext = s.substring(i+1).toLowerCase();
           }
           return ext;
        } 
     }
}
