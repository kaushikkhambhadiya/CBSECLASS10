package com.omeducation.cbscclass10board;

import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.net.URL;



 class SimpleYouTubeHelper {

//    static String getTitleQuietly(String youtubeUrl) {
//        try {
//            if (youtubeUrl != null) {
//                URL embededURL = new URL("http://www.youtube.com/oembed?url=" + "https://www.youtube.com/watch?v=" +
//                        youtubeUrl + "&format=json"
//                );
//                String title = IOUtils.toString(embededURL);
//                return new JSONObject(IOUtils.toString(embededURL)).getString("title");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static String getTitleQuietly(String youtubeUrl) {
        try {
            if (youtubeUrl != null) {
                URL embededURL = new URL("http://www.youtube.com/oembed?url=" +
                        youtubeUrl + "&format=json"
                );

                return new JSONObject(IOUtils.toString(embededURL)).getString("title");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    static String getThumblain(String youtubeUrl){
        try {
            if (youtubeUrl != null) {
                URL embededURL = new URL("http://www.youtube.com/oembed?url=" +
                        youtubeUrl + "&format=json"
                );
                String thumblainvideo = "http://img.youtube.com/vi/"+youtubeUrl+"/0.jpg";;
                Log.i("response",thumblainvideo);
                return thumblainvideo;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
