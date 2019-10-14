package apap.tugas.sidok.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "poli")
public class Poli implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(255)
    @Column(name = "nama")
    private String nama;

    @NotNull
    @Size(255)
    @Column(name = "lokasi")
    private String lokasi;

    @OneToMany(mappedBy = "jadwal_jaga", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Jadwal_Jaga> listJadwalJaga;

    //Getter and Setter
    public Long getIdPoli() {
        return id;
    }

    public void setIdPoli(Long idPoli) {
        this.id = idPoli;
    }

    public String getNamaPoli() {
        return nama;
    }

    public void setNamaPoli(String namaPoli) {
        this.nama = namaPoli;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
