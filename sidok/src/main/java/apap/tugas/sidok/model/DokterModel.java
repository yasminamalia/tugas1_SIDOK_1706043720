package apap.tugas.sidok.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dokter")
public class DokterModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDokter;

    @NotNull
    @Size(max=255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max=255)
    @Column(name = "nip", nullable = false)
    private String nip;

    @NotNull
    @Size(max=255)
    @Column(name = "nik", nullable = false)
    private String nik;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggalLahir", nullable = false)
    private LocalDate tanggal_lahir;

    @NotNull
    @Size(max=255)
    @Column(name = "tempatLahir", nullable = false)
    private String tempat_lahir;

    @NotNull
    @Column(name = "jenisKelamin", nullable = false)
    private Integer jenis_kelamin;

    @OneToMany(mappedBy = "listDokter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JadwalJagaModel> listJadwalJaga;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "spesialisasiDokter",
            joinColumns = @JoinColumn(name = "idDokter"),
            inverseJoinColumns = @JoinColumn(name = "idSpesialisasi")
    )
    private List<SpesialisasiModel> listSpesialisasi;

    //Setter dan Getter
    public Long getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(Long idDokter) {
        this.idDokter = idDokter;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public LocalDate getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(LocalDate tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public Integer getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(Integer jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public List<JadwalJagaModel> getListJadwalJaga() {
        return listJadwalJaga;
    }

    public void setListJadwalJaga(List<JadwalJagaModel> listJadwalJaga) {
        this.listJadwalJaga = listJadwalJaga;
    }

    public List<SpesialisasiModel> getListSpesialisasi() {
        return listSpesialisasi;
    }

    public void setListSpesialisasi(List<SpesialisasiModel> listSpesialisasi) {
        this.listSpesialisasi = listSpesialisasi;
    }
}
