package pl.mberkan.codekata.kata1;

import com.google.common.base.Preconditions;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

class FileReaderUtil {

    List<String> readFileFromResource(String fileName) throws IOException {
        URL resource = FootballCheck.class.getClassLoader().getResource(fileName);
        Preconditions.checkNotNull(resource, "resource " + fileName + " is null");
        File file = new File(resource.getFile());
        Preconditions.checkNotNull(file, "file " + file.toString() + " is null");
        return Files.readAllLines(
                file.toPath(),
                Charset.defaultCharset());
    }
}
