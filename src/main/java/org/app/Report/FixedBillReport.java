package org.app.Report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@AllArgsConstructor
public class FixedBillReport extends AbstractReport {
    private int billIdx;
    private final static String fileName = "BillReports.pdf";
    private final static String title = "Bill Report";

    public void writeReport()
            throws DocumentException, IOException {
        Document billReport = initFile(fileName);
        billReport.open();
        addMetaData(billReport,title);
        initTitle(billReport,title);
        addBill(billReport,billIdx);
        billReport.close();
    }

}
