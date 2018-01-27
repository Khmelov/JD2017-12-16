package by.it.patsko.calc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

class FileReaderWriterCalc {
    String path;
    String fileName;
    String mode;
    RandomAccessFile file;

    FileReaderWriterCalc(String path, String fileName, String mode) throws FileNotFoundException {
        this.path = path;
        this.fileName = fileName;
        this.mode = mode;
        file = new RandomAccessFile(path + fileName, mode);
    }

    void writeFileCalc() throws IOException {
        for (Map.Entry<String, Var> element : Variable.map.entrySet()) {
            try {
                file.writeBytes(element.toString());
                file.write("\n".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        file.close();

    }

    void readFileCalc() throws CalcException, IOException {
        Parser parser=new Parser();
        Variable var;
//        StringBuilder All=new StringBuilder();
        String line, varNvalue[];
        while ((line = file.readLine()) != null) {
//            varNvalue = line.split("=");
            var=(Variable)parser.calc(line);
//            var=(Variable)parser.calc(line);
//            Variable.map.put(var.getKey(), var.getValue());
        }
        file.close();
    }
}
