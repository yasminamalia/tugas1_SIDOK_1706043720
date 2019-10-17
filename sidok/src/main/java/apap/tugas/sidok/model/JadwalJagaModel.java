package apap.tugas.sidok.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "jadwalJaga")
public class JadwalJagaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJadwal;

    @NotNull
    @Size(max = 255)
    @Column(name = "hari", nullable = false)
    private String hari;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idPoli", referencedColumnName = "idPoli", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PoliModel listPoli;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idDokter", referencedColumnName = "idDokter", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DokterModel listDokter;

    //Setter dan Getter
    public Long getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(Long idJadwal) {
        this.idJadwal = idJadwal;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public PoliModel getListPoli() {
        return listPoli;
    }

    public void setListPoli(PoliModel listPoli) {
        this.listPoli = listPoli;
    }

    public DokterModel getListDokter() {
        return listDokter;
    }

    public void setListDokter(DokterModel listDokter) {
        this.listDokter = listDokter;
    }
}
