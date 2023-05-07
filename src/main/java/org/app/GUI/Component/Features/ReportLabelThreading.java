package org.app.GUI.Component.Features;

import org.app.GUI.Component.Report;
import org.app.Report.ReportWriter;

import javax.swing.*;
import java.awt.*;

public class ReportLabelThreading extends JLabel implements Runnable{
    private Thread thread;
    private boolean isRunning = false;
    private Report parent;
    public ReportLabelThreading(Report parent) {
        this.setVisible(false);
        this.setOpaque(true);
        this.parent = parent;
    }
    public void writeReport(ReportWriter writer) {
        try{
            this.setText("Sedang Mencetak...");
            this.setBackground(Color.YELLOW);
            writer.writeReport();
            this.setVisible(true);
            isRunning = true;
            parent.toggleButtonEnabled(false);
            thread = new Thread(this);
            thread.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        try{
            thread.sleep(10000);
            synchronized (this) {
                while (!isRunning) {
                    wait();
                }
            }
            this.setText("Selesai Mencetak");
            this.setBackground(Color.GREEN);
            isRunning = false;
            parent.toggleButtonEnabled(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
