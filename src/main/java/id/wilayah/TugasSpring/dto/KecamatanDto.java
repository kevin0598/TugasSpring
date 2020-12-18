package id.wilayah.TugasSpring.dto;

public class KecamatanDto {
	private String kodeKecamatan;
	private String namaKecamatan;
	private String kodeProvinsi;
	private String status;

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

	public String getKodeProvinsi() {
		return kodeProvinsi;
	}

	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}

	public String getKodeKabupaten() {
		return kodeKabupaten;
	}

	public void setKodeKabupaten(String kodeKabupaten) {
		this.kodeKabupaten = kodeKabupaten;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public KecamatanDto(String kodeKecamatan, String namaKecamatan, String kodeProvinsi, String status,
			String kodeKabupaten) {
		super();
		this.kodeKecamatan = kodeKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.kodeProvinsi = kodeProvinsi;
		this.status = status;
		this.kodeKabupaten = kodeKabupaten;
	}

	public KecamatanDto() {
		super();
	}

	private String kodeKabupaten;

}
