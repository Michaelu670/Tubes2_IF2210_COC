package org.app.Report;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

import org.app.Inventory.Holder.FixedBill;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class AbstractReport implements ReportWriter {
    protected static final String DIR = "./report/";

    protected static final Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    protected static final Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    protected static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);
    protected static final Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    protected static final Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);
    protected static final Font normalBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    protected static final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);

    @Setter @Accessors(fluent = true)
    static List<FixedBill> listOfReport;

    protected static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    protected static void createDirectory(String pathDirectory)
            throws IOException {
        Path path = Paths.get(pathDirectory);
        Files.createDirectories(path);
    }
}
