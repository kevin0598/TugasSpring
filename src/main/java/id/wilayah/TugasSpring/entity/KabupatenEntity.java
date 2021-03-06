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
@Table(name = "kabupaten")
public class KabupatenEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "kodeKabupaten", unique = true,nullable = true)
	private String kodeKabupaten;

	@Column(name = "namaKabupaten", nullable = true)
	private String namaKabupaten;

	@Column(name = "status", nullable = true)
	private String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "kodeProvinsi")
	private ProvinsiEntity entity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKodeKabupaten() {
		return kodeKabupaten;
	}

	public void setKodeKabupaten(String kodeKabupaten) {
		this.kodeKabupaten = kodeKabupaten;
	}

	public String getNamaKabupaten() {
		return namaKabupaten;
	}

	public void setNamaKabupaten(String namaKabupaten) {
		this.namaKabupaten = namaKabupaten;
	}

	public ProvinsiEntity getEntity() {
		return entity;
	}

	public void setEntity(ProvinsiEntity entity) {
		this.entity = entity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public KabupatenEntity(Integer id, String kodeKabupaten, String namaKabupaten, String status,
			ProvinsiEntity entity) {
		super();
		this.id = id;
		this.kodeKabupaten = kodeKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.status = status;
		this.entity = entity;
	}

	public KabupatenEntity() {
		super();
	}

}
