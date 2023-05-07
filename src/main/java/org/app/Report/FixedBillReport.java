package org.app.Report;

import com.itextpdf.text.*;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.IOException;

@AllArgsConstructor
public class FixedBillReport extends AbstractReport {
    private int billIdx;

    @Setter
    private static String fileName = "BillReports.pdf";
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
