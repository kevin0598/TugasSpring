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
@Table(name="provinsi")
public class ProvinsiEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="kodeProvinsi",nullable = true)
	private String kodeProvinsi;
	
	@Column(name="namaProvinsi",nullable = true)
	private String namaProvinsi;
		
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
	public ProvinsiEntity(Integer id, String kodeProvinsi, String namaProvinsi) {
		super();
		this.id = id;
		this.kodeProvinsi = kodeProvinsi;
		this.namaProvinsi = namaProvinsi;
	}
	public ProvinsiEntity() {
		super();
	}
}
