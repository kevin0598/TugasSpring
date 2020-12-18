package id.wilayah.TugasSpring.dto;

public class KabupatenDto {
	private String kodeKabupaten;
	private String namaKabupaten;
	private String kodeProvinsi;
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public KabupatenDto(String kodeKabupaten, String namaKabupaten, String kodeProvinsi, String status) {
		super();
		this.kodeKabupaten = kodeKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.kodeProvinsi = kodeProvinsi;
		this.status = status;
	}

	public KabupatenDto() {
		super();
	}
}
