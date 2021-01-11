package Chat.RecordingMessage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InOutMessage {
   static File file = new File("C:\\Users\\Stas\\Desktop\\JavaCore\\level3\\HW2\\src\\Chat\\RecordingMessage\\messages.txt");


    public static void doWriterMessages(String value,Boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,append ) ) ) {
           // bw.newLine();
            bw.write(value);
            bw.flush();
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public static String doReaderMessages() {
        RandomAccessFile fileHandler = null;
        try {
            fileHandler =
                    new RandomAccessFile( file, "r" );
            long fileLength = fileHandler.length() - 1;
            StringBuilder sb = new StringBuilder();
            int line = 0;

            for(long filePointer = fileLength; filePointer != -1; filePointer--){
                fileHandler.seek( filePointer );
                int readByte = fileHandler.readByte();

                if( readByte == 0xA ) {
                    if (filePointer < fileLength) {
                        line = line + 1;
                    }
                } else if( readByte == 0xD ) {
                    if (filePointer < fileLength-1) {
                        line = line + 1;
                    }
                }
                if (line >=100 ) {
                    doWriterMessages("null",false);
                    break;
                }
                sb.append( ( char ) readByte );
            }

            String lastLine = sb.reverse().toString();
            return lastLine;
        } catch( java.io.FileNotFoundException e ) {
            e.printStackTrace();
            return null;
        } catch( java.io.IOException e ) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (fileHandler != null )
                try {
                    fileHandler.close();
                } catch (IOException e) {
                }
        }
    }
}

