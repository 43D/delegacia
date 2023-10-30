package br.edu.utfpr.td.tsi.delegacia.util;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import br.edu.utfpr.td.tsi.delegacia.repository.BoletimRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class CSVFileReader implements iCSVFileReader {

    @Autowired
    BoletimRepository rep;

    @Override
    public void read() {
        Resource resource = new ClassPathResource("furtos.csv");
        try {
            InputStream is = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
          
            CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
            CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(csvParser).withSkipLines(1).build();
            String[] nextRecord;

            int i = 1;
            while ((nextRecord = csvReader.readNext()) != null) {
                DatabaseCretor.create(nextRecord, rep);
                System.out.println(i++ + ", " + ((double) i / 15968 * 100) + "%");
            }
            csvReader.close();
            System.out.println("Total de dados: " + rep.count());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
