package id.web.hikmasoft.aseton.desktop.Service;

import id.web.hikmasoft.aseton.desktop.API.BarangAPI;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class BarangService {

    private static BarangService dInstance;
    private static final String BASE_URL = "https://aseton.herokuapp.com/";
    private Retrofit dRetrofit;

    public BarangService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        dRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public static BarangService getInstance() {
        if (dInstance == null) {
            dInstance = new BarangService();
        }
        return dInstance;
    }

    public BarangAPI barangAPI() {
        return dRetrofit.create(BarangAPI.class);
    }

}
