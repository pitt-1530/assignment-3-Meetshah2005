package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms)
    {
        if (bpms == null || bpms.isEmpty())
        {
            throw new IllegalArgumentException("BPM list cannot be null or empty");
        }

        double total = 0;
        for (int bpm : bpms)
        {
            total += bpm;
        }
        double avg = total / bpms.size();

        if (avg >= 140)
        {
            return "HIGH";
        }
        // 100-139
        else if (avg >= 100)
        { 
            return "MEDIUM";
        }
        else 
        {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title)
    {
        if (title == null || title.isEmpty() || title.length() > 30)
        {
            return false;
        }
        //Return true if normal characters and spaces
        return title.matches("[A-Za-z ]+");
    }

    public static int normalizeVolume(int volumeDb)
    {
        if (volumeDb < 0)
        {
            return 0;
        }
        if (volumeDb > 100)
        {
            return 100;
        }
        return volumeDb;
    }
}
