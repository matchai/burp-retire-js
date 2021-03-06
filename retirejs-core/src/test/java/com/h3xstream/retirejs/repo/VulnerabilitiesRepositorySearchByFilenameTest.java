package com.h3xstream.retirejs.repo;

import com.esotericsoftware.minlog.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.h3xstream.retirejs.repo.PrettyDisplay.displayResults;
import static org.testng.Assert.assertEquals;

public class VulnerabilitiesRepositorySearchByFilenameTest {
    @BeforeClass
    public void setUp() {
        Log.DEBUG();
    }

    @Test
    public void findJqueryByFilename() throws IOException {
        VulnerabilitiesRepositoryLoader.syncWithOnlineRepository = false;

        VulnerabilitiesRepository repo = new VulnerabilitiesRepositoryLoader().load();

        List<JsLibraryResult> res = repo.findByFilename("/jquery-1.6.2.js");
        displayResults(res);
        assertEquals(res.size(), 2, "Jquery not found (/jquery-1.6.2.js)");

        res = repo.findByFilename("/jquery-1.6.3.js");
        displayResults(res);
        assertEquals(res.size(), 1, "Jquery not found (/jquery-1.6.3.js)");

        res = repo.findByFilename("/trolololol/jquery-1.8.9.min.js");
        displayResults(res);
        assertEquals(res.size(), 1, "Jquery not found (/jquery-1.8.9.min.js)");
    }
}
