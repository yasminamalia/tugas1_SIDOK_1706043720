package apap.tugas.sidok.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "spesialisasi")
public class SpesialisasiModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpesialisasi;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "gelar", nullable = false)
    private String gelar;

    @ManyToMany(mappedBy = "listSpesialisasi")
    private List<DokterModel> dokterList;

    //Setter dan Getter
    public Long getIdSpesialisasi() {
        return idSpesialisasi;
    }

    public void setIdSpesialisasi(Long idSpesialisasi) {
        this.idSpesialisasi = idSpesialisasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    public List<DokterModel> getDokterList() {
        return dokterList;
    }

    public void setDokterList(List<DokterModel> dokterList) {
        this.dokterList = dokterList;
    }
}
