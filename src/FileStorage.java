
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileStorage {

    public static void writeNewFile(String fileName, String[] headers) throws IOException {
        FileWriter fw = new FileWriter(fileName + ".txt");

        for (String header : headers) {
            fw.append(header);
            if (! headers[headers.length - 1 ].equals(header)){
                fw.append(",");
            }else fw.append("\n");
        }
        fw.flush();
        fw.close();
    }

    public static void addRecord(String fileName, String[] fields) throws IOException {
        FileWriter fw = new FileWriter(fileName + ".txt", true);

        for (String field : fields) {
            fw.append(field);
            if (! fields[fields.length - 1 ].equals(field)){
                fw.append(",");
            }else fw.append("\n");
        }
        fw.flush();
        fw.close();
    }
    public static void addRecordcsv(String fileName, String[] fields) throws IOException {
        FileWriter fw = new FileWriter(fileName + ".csv", true);

        for (String field : fields) {
            fw.append(field);
            if (! fields[fields.length - 1 ].equals(field)){
                fw.append(",");
            }else fw.append("\n");
        }
        fw.flush();
        fw.close();
    }

    public static ArrayList<String[]> readData(String fileName) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(fileName + ".txt"));
        ArrayList<String[]> data = new ArrayList<>();
        String row = "";
        while ((row = fr.readLine()) != null) {

            String[] rowdata = row.split(",");
            data.add(rowdata);
        }
        fr.close();
        return data;
    }

    public static String getLastId(String fileName) throws IOException {
        ArrayList<String[]> data = readData(fileName);
        return data.get(data.size() - 1)[0];
    }

    public static boolean deleteRecord(String fileName, String id) throws IOException{
        File inputFile = new File(fileName + ".txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = "bbb";
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String[] data = currentLine.split(",");
            if (data[0].equals(id)){
                lineToRemove = currentLine;
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        if (inputFile.delete()){
            tempFile.renameTo(new File(fileName + ".txt"));
            return true;
        }else {
            return false;
        }

    }

    public static boolean updateRecord(String fileName, String id, String[] updatedRows) throws IOException{
        File inputFile = new File(fileName + ".txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String[] data = currentLine.split(",");
            if (data[0].equals(id)){
                currentLine = Arrays.toString(updatedRows);
                currentLine = currentLine.substring(1, currentLine.length() - 1);
                currentLine = currentLine.replaceAll("\\s+", "");
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        if (inputFile.delete()){
            tempFile.renameTo(new File(fileName + ".txt"));
            return true;
        }else {
            return false;
        }

    }
    public static boolean updateTrip(String fileName, String id,String date,String time, String[] updatedRows) throws IOException{
        File inputFile = new File(fileName + ".txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String[] data = currentLine.split(",");
            if (data[0].equals(id) && data[1].equals(date) && data[2].equals(time)){
                currentLine = Arrays.toString(updatedRows);
                currentLine = currentLine.substring(1, currentLine.length() - 1);
                currentLine = currentLine.replaceAll("\\s+", "");
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        if (inputFile.delete()){
            tempFile.renameTo(new File(fileName + ".txt"));
            return true;
        }else {
            return false;
        }

    }
}