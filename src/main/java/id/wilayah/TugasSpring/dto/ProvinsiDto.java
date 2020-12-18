package id.wilayah.TugasSpring.dto;

public class ProvinsiDto {
	private String kodeProvinsi;
	private String namaProvinsi;
	private String status;
	
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
	public ProvinsiDto(String kodeProvinsi, String namaProvinsi, String status) {
		super();
		this.kodeProvinsi = kodeProvinsi;
		this.namaProvinsi = namaProvinsi;
		this.status = status;
	}
	public ProvinsiDto() {
		super();
	}
}
