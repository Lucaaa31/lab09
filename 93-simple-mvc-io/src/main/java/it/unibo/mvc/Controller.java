package it.unibo.mvc;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.io.*;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File file;


    public void currentFile(final File file){
        this.file = file;
    }

    public File getFile(){
        return this.file;
    }

    public String getPath(){
        return file.getAbsolutePath();
    }

    public void saveInFile(final String str) throws IOException{
        try(final PrintStream f = new PrintStream(file.getPath())){
            f.print(str);
        } 
    }
}
