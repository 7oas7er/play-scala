package persist;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;
import models.Karte;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CsvDao {

    private final static String PATH_TO_CSV_FILE = "/catalog.csv";
    private ObjectMapper mapper;

    public CsvDao(){
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public List<Karte> generateCardlist() {
        try {
            return convertToPOJO(convertToJSON(parseCSV()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Karte> convertToPOJO(ByteArrayOutputStream bas) throws IOException {
        ObjectReader reader = mapper.readerFor(mapper.getTypeFactory().constructCollectionType(List.class, Karte.class));
        return reader.with(DeserializationFeature.READ_ENUMS_USING_TO_STRING).readValue(bas.toByteArray());
    }

    private ByteArrayOutputStream convertToJSON(List<Map<String, String>> list) throws IOException {
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        mapper.writeValue(bas, list);
        return bas;
    }

    private List<Map<String, String>> parseCSV() throws IOException {
        InputStream fis = null;
        try {
            fis = CsvDao.class.getResourceAsStream(PATH_TO_CSV_FILE);
            CSV csv = new CSV(true, ';', fis);

            List<String> fieldNames = null;
            if (csv.hasNext()) fieldNames = new ArrayList<>(csv.next());
            List<Map<String, String>> list = new ArrayList<>();
            while (csv.hasNext()) {
                List<String> x = csv.next();
                Map<String, String> obj = new LinkedHashMap<>();
                for (int i = 0; i < fieldNames.size(); i++) {
                    obj.put(fieldNames.get(i), x.get(i));
                }
                list.add(obj);
            }
            return list;
        } finally {
            if(fis != null) {
                fis.close();
            }
        }
    }
}


