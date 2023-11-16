package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface Dictionary {

    void setFilePath(String filepath) throws IOException;
    void loadDictionaryFromFile() throws IOException;
    void printDictionary();
    void addItem(String key, String value) throws IOException;
    void removeItem(String key) throws IOException;
    void searchItem(String key);

    boolean isValidWord(String word);
}
