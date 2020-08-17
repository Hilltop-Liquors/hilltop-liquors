package com.codeup.hilltopliquors.helper;

import com.codeup.hilltopliquors.models.Product;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "id", "products", "size", "price_in_cents", "in_store_count" };

    public static boolean hasCSVFormat(MultipartFile file) {

        if(!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Product> csvToProducts(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Product> products = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords) {
                Product product = new Product(
                        Long.parseLong(csvRecord.get("id")),
                        csvRecord.get("products"),
                        csvRecord.get("size"),
                        Double.parseDouble(csvRecord.get("price_in_cents")),
                        Integer.parseInt(csvRecord.get("in_store_count"))
                );

                products.add(product);
            }

            return products;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream productsToCSV(List<Product> products) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Product product : products) {
                List<String> data = Arrays.asList(
                        String.valueOf(product.getId()),
                        product.getProducts(),
                        product.getSize(),
                        String.valueOf(product.getPrice_in_cents()),
                        String.valueOf(product.getIn_store_count())
                );

                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch(IOException e) {
            throw new RuntimeException("fail to import data to CSV file " + e.getMessage());
        }
    }
}
