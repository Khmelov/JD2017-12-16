package by.it.patsko.jd02_04;

import java.io.File;
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
    FileReaderWriterCalc(File file, String mode) throws FileNotFoundException {
        file= new File(file,mode);
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
        if(file.length()!=0) {
            Parser parser = new Parser();
            String var;
//        StringBuilder All=new StringBuilder();
            String line, varNvalue[];
            while ((line = file.readLine()) != null) {
                parser.calc(line);
                line=new String();
//            var=(Variable)parser.calc(line);
            }
            file.close();

        }
    }
}
