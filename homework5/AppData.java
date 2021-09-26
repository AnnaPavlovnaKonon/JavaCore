package homework5;

import java.io.*;
import java.util.ArrayList;

public class AppData {
    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }
    public void setHeader(String[] header) {
        this.header = header;
    }
    public Integer[][] getData() {
        return data;
    }
    public void setData(Integer[][] data) {
        this.data = data;
    }

    public AppData() {
        header = new String[]{"Value 1", "Value 2", "Value 3"};
        data = new Integer[][]{{100, 200, 123}, {300, 400, 500}};
        }

    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(dataTable(header));

            for (Integer[] row : data) {
                writer.write(dataTable(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> String dataTable(T[] row) {
        String result = "";

        for (int i = 0; i < row.length; i++) {
            result = result + row[i].toString();
            if (i != row.length - 1) {
                result += ";";
            }
        }
        result += "\n";
        return result;
    }

    public void load(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(";");
            ArrayList<Integer[]> dataList = new ArrayList<>();
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                dataList.add(dataRow(tempString));
            }
            data = dataList.toArray(new Integer[][]{{}});
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer[] dataRow(String str) {
        String[] strings = str.split(";");

        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }
}
