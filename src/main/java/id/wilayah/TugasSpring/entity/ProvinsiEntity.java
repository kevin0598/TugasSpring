package id.wilayah.TugasSpring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "provinsi")
public class ProvinsiEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "kodeProvinsi",unique = true, nullable = true)
	private String kodeProvinsi;

	@Column(name = "namaProvinsi", nullable = true)
	private String namaProvinsi;

	@Column(name = "status", nullable = true)
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKodeProvinsi() {
		return kodeProvinsi;
	}

	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}

	public String getNamaProvinsi() {
		return namaProvinsi;
	}

	public void setNamaProvinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProvinsiEntity(Integer id, String kodeProvinsi, String namaProvinsi, String status) {
		super();
		this.id = id;
		this.kodeProvinsi = kodeProvinsi;
		this.namaProvinsi = namaProvinsi;
		this.status = status;
	}

	public ProvinsiEntity() {
		super();
	}
}
