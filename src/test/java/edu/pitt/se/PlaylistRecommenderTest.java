package edu.pitt.se;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PlaylistRecommenderTest {

    // Tests for classifyEnergy()
    @Test
    public void testClassifyEnergyHigh() {
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(Arrays.asList(150, 145, 160)));
    }

    @Test
    public void testClassifyEnergyMedium() {
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(Arrays.asList(100, 110, 120)));
    }

    @Test
    public void testClassifyEnergyLow() {
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(Arrays.asList(60, 80, 90)));
    }

    @Test
    public void testClassifyEnergyNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(null));
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(Collections.emptyList()));
    }

    // Tests for isValidTrackTitle()
    @Test
    public void testIsValidTrackTitleValid() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("My Song Title"));
    }

    @Test
    public void testIsValidTrackTitleInvalidChars() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Title!245gb50"));
    }

    @Test
    public void testIsValidTrackTitleNullOrEmptyOrTooLong() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
        assertFalse(PlaylistRecommender.isValidTrackTitle(""));
        assertFalse(PlaylistRecommender.isValidTrackTitle("This title is definitely way too long for our limit"));
    }

    // Tests for normalizeVolume()
    @Test
    public void testNormalizeVolumeWithinRange() {
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
    }

    @Test
    public void testNormalizeVolumeBelowZero() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-10));
    }

    @Test
    public void testNormalizeVolumeAboveHundred() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
    }
}
