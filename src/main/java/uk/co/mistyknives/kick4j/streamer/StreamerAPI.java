package uk.co.mistyknives.kick4j.streamer;

import uk.co.mistyknives.kick4j.util.HttpConnection;
import uk.co.mistyknives.kick4j.util.KickEndpoints;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright MistyKnives © 2022-2023
 * <br>
 * ---------------------------------------
 * <br>
 * All Projects are located on my GitHub
 * <br>
 * Please provide credit where due :)
 * <br>
 * ---------------------------------------
 * <br>
 * https://github.com/MistyKnives
 */
public class StreamerAPI {

    /**
     * Get the JSON Data from the Kick API then transfer it into "Streamer" class for easy access
     * @param s Streamer's Username
     * @return Streamer
     * @see uk.co.mistyknives.kick4j.streamer.Streamer
     */
    public Streamer getStreamer(String s) {
        return (Streamer) HttpConnection.getRawResponse(KickEndpoints.CHANNELS.url + "/%s".formatted(s), Streamer.class);
    }

    /**
     * Get the JSON Data for Multiple Streamers from the Kick API then transfer it into an array using StreamerList to separate each "Streamer" class for easy access
     * @param s Array of Usernames
     * @return StreamerList
     * @see uk.co.mistyknives.kick4j.streamer.StreamerList
     */
    public StreamerList getStreamers(String... s) {
        List<Streamer> streamers = new ArrayList<>();
        for (String username : s) {
            streamers.add(this.getStreamer(username));
        }

        return (StreamerList) streamers;
    }
}
