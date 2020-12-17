package id.wilayah.TugasSpring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="kecamatan")
public class KecamatanEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="kodeKecamatan",nullable = true)
	private String kodeKecamatan;
	
	@Column(name="namaKecamatan",nullable = true)
	private String namaKecamatan;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="kodeProvinsi",referencedColumnName = "kodeProvinsi")
	private ProvinsiEntity kodeProvinsi;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="kodeKabupaten",referencedColumnName = "kodeKabupaten")
	private KabupatenEntity kodeKabupaten;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKodeKecamatan() {
		return kodeKecamatan;
	}
	public void setKodeKecamatan(String kodeKecamatan) {
		this.kodeKecamatan = kodeKecamatan;
	}
	public String getNamaKecamatan() {
		return namaKecamatan;
	}
	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}
	public ProvinsiEntity getKodeProvinsi() {
		return kodeProvinsi;
	}
	public void setKodeProvinsi(ProvinsiEntity kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
	public KabupatenEntity getKodeKabupaten() {
		return kodeKabupaten;
	}
	public void setKodeKabupaten(KabupatenEntity kodeKabupaten) {
		this.kodeKabupaten = kodeKabupaten;
	}
	public KecamatanEntity(Integer id, String kodeKecamatan, String namaKecamatan, ProvinsiEntity kodeProvinsi,
			KabupatenEntity kodeKabupaten) {
		super();
		this.id = id;
		this.kodeKecamatan = kodeKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.kodeProvinsi = kodeProvinsi;
		this.kodeKabupaten = kodeKabupaten;
	}
	public KecamatanEntity() {
		super();
	}
	
}
