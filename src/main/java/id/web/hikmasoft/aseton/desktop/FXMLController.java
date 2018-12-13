package id.web.hikmasoft.aseton.desktop;

import id.web.hikmasoft.aseton.desktop.Model.Barang;
import id.web.hikmasoft.aseton.desktop.Service.BarangService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FXMLController {


    @FXML
    private Label label;

    public void initialize() {
        BarangService.getInstance()
                .barangAPI()
                .cekBarang((long) 1)
                .enqueue(new Callback<Barang>() {
                    @Override
                    public void onResponse(Call<Barang> call, Response<Barang> response) {
                        Barang barang = response.body();
                        Platform.runLater(() -> {
                            label.setText(barang.getKodeBarang() + ", " + barang.getNamaBarang());
                        });
                    }

                    @Override
                    public void onFailure(Call<Barang> call, Throwable t) {
                        Platform.runLater(() -> {
                            label.setText("An error occured");
                        });
                        t.printStackTrace();
                    }
        });
    }
}
