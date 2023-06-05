package core.basesyntax.service.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportServiceImplTest {
    private ReportServiceImpl reportService;

    @BeforeEach
    void setUp() {
        reportService = new ReportServiceImpl();
    }

    @Test
    void generateReport_emptyStorage_ok() {
        String expected = "fruit,quantity";
        String actual = reportService.generateReport(Collections.emptyMap());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void generateReport_nonEmptyStorage_ok() {
        String expected = "fruit,quantity\n"
                          + "apple,10\n"
                          + "banana,50";
        Map<String, Integer> storage = new LinkedHashMap<>();
        storage.put("apple", 10);
        storage.put("banana", 50);
        String actual = reportService.generateReport(storage);
        expected = expected.replaceAll("\\R", System.lineSeparator());
        actual = actual.replaceAll("\\R", System.lineSeparator());
        Assertions.assertEquals(expected, actual);
    }
}
