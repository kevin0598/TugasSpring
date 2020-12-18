package id.wilayah.TugasSpring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "desa")
public class DesaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "kodeDesa", nullable = true)
	private String kodeDesa;

	@Column(name = "namaDesa", nullable = true)
	private String namaDesa;

	@Column(name = "status", nullable = true)
	private String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "kodeKecamatan", referencedColumnName = "kodeKecamatan")
	private KecamatanEntity kodeKecamatan;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "kodeKabupaten", referencedColumnName = "kodeKabupaten")
	private KabupatenEntity kodeKabupaten;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "kodeProvinsi", referencedColumnName = "kodeProvinsi")
	private ProvinsiEntity kodeProvinsi;

	public String getKodeDesa() {
		return kodeDesa;
	}

	public void setKodeDesa(String kodeDesa) {
		this.kodeDesa = kodeDesa;
	}

	public String getNamaDesa() {
		return namaDesa;
	}

	public void setNamaDesa(String namaDesa) {
		this.namaDesa = namaDesa;
	}

	public KecamatanEntity getKodeKecamatan() {
		return kodeKecamatan;
	}

	public void setKodeKecamatan(KecamatanEntity kodeKecamatan) {
		this.kodeKecamatan = kodeKecamatan;
	}

	public KabupatenEntity getKodeKabupaten() {
		return kodeKabupaten;
	}

	public void setKodeKabupaten(KabupatenEntity kodeKabupaten) {
		this.kodeKabupaten = kodeKabupaten;
	}

	public ProvinsiEntity getKodeProvinsi() {
		return kodeProvinsi;
	}

	public void setKodeProvinsi(ProvinsiEntity kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DesaEntity(Integer id, String kodeDesa, String namaDesa, String status, KecamatanEntity kodeKecamatan,
			KabupatenEntity kodeKabupaten, ProvinsiEntity kodeProvinsi) {
		super();
		this.id = id;
		this.kodeDesa = kodeDesa;
		this.namaDesa = namaDesa;
		this.status = status;
		this.kodeKecamatan = kodeKecamatan;
		this.kodeKabupaten = kodeKabupaten;
		this.kodeProvinsi = kodeProvinsi;
	}

	public DesaEntity() {
		super();
	}

}
