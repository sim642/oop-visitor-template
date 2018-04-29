package task2;

import org.junit.Test;
import sample.TestImages;

import java.util.List;

import static org.junit.Assert.*;

public class TextExtractorTest {

    @Test
    public void testDemoImage() {
        assertEquals(List.of("Some text", "My cool image"), TextExtractor.extractTexts(TestImages.DEMO_IMAGE));
    }
}
