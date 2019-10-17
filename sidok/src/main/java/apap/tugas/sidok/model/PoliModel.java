package apap.tugas.sidok.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "poli")
public class PoliModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPoli;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama")
    private String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "lokasi")
    private String lokasi;

    @OneToMany(mappedBy = "listPoli", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JadwalJagaModel> listJadwalJaga;

    //Setter dan Getter
    public Long getIdPoli() {
        return idPoli;
    }

    public void setIdPoli(Long idPoli) {
        this.idPoli = idPoli;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public List<JadwalJagaModel> getListJadwalJaga() {
        return listJadwalJaga;
    }

    public void setListJadwalJaga(List<JadwalJagaModel> listJadwalJaga) {
        this.listJadwalJaga = listJadwalJaga;
    }
}
