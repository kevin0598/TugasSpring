package id.wilayah.TugasSpring.dto;

public class KabupatenDto {
	private String kodeKabupaten;
	private String namaKabupaten;
	private String kodeProvinsi;
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
	public String getKodeProvinsi() {
		return kodeProvinsi;
	}
	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
	public KabupatenDto(String kodeKabupaten, String namaKabupaten, String kodeProvinsi) {
		super();
		this.kodeKabupaten = kodeKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.kodeProvinsi = kodeProvinsi;
	}
	public KabupatenDto() {
		super();
	}
}

