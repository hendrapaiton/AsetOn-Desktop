package id.web.hikmasoft.aseton.desktop.API;

import id.web.hikmasoft.aseton.desktop.Model.Barang;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BarangAPI {

    @GET("/api/barang/{id}")
    public Call<Barang> cekBarang(@Path("id") Long id);

    @GET("/api/barang/")
    public Call<Barang> ambilBarang();

}
