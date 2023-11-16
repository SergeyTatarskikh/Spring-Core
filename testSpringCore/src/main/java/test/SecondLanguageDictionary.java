package test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SecondLanguageDictionary implements Dictionary {
    private Dictionary dict2;

    Map<String, String> dictionary;
    private String filepath;

    public SecondLanguageDictionary() throws IOException {
        dictionary = new HashMap<>();

    }

    @Override
    public void setFilePath(String filepath) throws IOException {
        this.filepath = filepath;
        loadDictionaryFromFile();
    }

    @Override
    public void loadDictionaryFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" - ");
            if (parts.length >= 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                dictionary.put(key, value);
            }
        }
        br.close();
    }

    @Override
    public void printDictionary() {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @Override
    public void addItem(String key, String value) throws IOException {
        if (isValidWord(value)){
            dictionary.put(key, value);
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true));
            writer.write(key + " - " + value + "\n");
            writer.close();
        }
        else {
            System.out.println("Not correct value");
        }

    }

    @Override
    public void removeItem(String key) throws IOException {
        dictionary.remove(key);
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filepath + ".tmp"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" - ");
            if (parts.length >= 2) {
                String currentKey = parts[0].trim();
                if (!currentKey.equals(key)) {
                    writer.write(line + "\n");
                }
            }
        }
        reader.close();
        writer.close();
        File oldFile = new File(filepath);
        File newFile = new File(filepath + ".tmp");
        if (oldFile.delete()) {
            newFile.renameTo(oldFile);
        }
    }

    @Override
    public void searchItem(String key) {
        String result = dictionary.get(key);
        System.out.println(Objects.requireNonNullElse(result, "Not found"));
    }

    @Override
    public boolean isValidWord(String word) {
        return word.matches("\\d{5}");
    }

}
