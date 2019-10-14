package apap.tugas.sidok.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "spesialisasi")
public class Spesialisasi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(255)
    @Column(name = "nama", nullable = false)
    private String gelar;

    @OneToMany(mappedBy = "spesialisasi_dokter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Spesialisasi_Dokter> listSpesialisasiDokter;

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
