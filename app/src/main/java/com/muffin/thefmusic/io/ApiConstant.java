package com.muffin.thefmusic.io;

/**
 * Created by StriderKeni on 8/30/16.
 */
public class ApiConstant {


    public static final String API_KEY = "9e8f0d769825953d892185bf85faeb1f";

    public static final String URL_BASE = "http://ws.audioscrobbler.com";

    public static final String PATH_VERSION = "2.0";

    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_API_KEY = "api_key";

    public static final String VALUE_HYPED_METHOD = "chart.gettopartists";
    public static final String VALUE_TOP_METHOD = "chart.gettopartists";
    public static final String VALUE_TYPE = "json";

    public static final String URL_HYPED_ARTIST = PATH_VERSION + "/?" + PARAM_FORMAT + "=" + VALUE_TYPE + "&" + PARAM_METHOD +
            "=" + VALUE_HYPED_METHOD + "&" + PARAM_API_KEY + "=" + API_KEY;


    public static final String URL_TOP_ARTIST = PATH_VERSION + "/?" + PARAM_METHOD + "=" + VALUE_TOP_METHOD + "&" +
            PARAM_API_KEY + "=" + API_KEY + "&" + PARAM_FORMAT + "=" + VALUE_TYPE;


                                 //2.0/?method=chart.gettopartists&api_key=9e8f0d769825953d892185bf85faeb1f&format=json

    //http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=YOUR_API_KEY&format=json//

    //http://ws.audioscrobbler.com/2.0?format=json&method=chart.gethypedartists&api_key= 9e8f0d769825953d892185bf85faeb1f

}
