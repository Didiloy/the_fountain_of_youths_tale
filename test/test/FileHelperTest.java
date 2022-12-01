package test;

import common.files.FileHelper;
import common.files.NotAllFilesException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static common.files.FileHelper.parseCsvFile;
import static org.junit.jupiter.api.Assertions.*;
class FileHelperTest {

    @BeforeEach
    void setUp() {
        File f = new File("./src/resource/Earth.csv");
        f.renameTo(new File("./src/resource/EarthTest.csv"));
    }

    @AfterEach
    void tearDown() {
        File f = new File("./src/resource/EarthTest.csv");
        f.renameTo(new File("./src/resource/Earth.csv"));
    }

    @Test
    void verifyFilesTest() {
        assertThrows(NotAllFilesException.class, FileHelper::verifyFiles);
    }

    @Test
    void parseCsvTest(){
        String fileName = "./src/resource/dummy.csv";
        assertEquals(0, parseCsvFile(fileName, "dummy").size());
    }

    @Test
    void parseCsvTest2(){
        String fileName = "./src/resource/Belli.csv";
        assertEquals(5, parseCsvFile(fileName, "dummy").size());
    }
}