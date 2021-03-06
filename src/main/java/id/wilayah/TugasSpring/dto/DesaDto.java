package id.wilayah.TugasSpring.dto;

public class DesaDto {
	private String kodeDesa;
	private String namaDesa;
	private String kodeKecamatan;
	private String kodeKabupaten;
	private String kodeProvinsi;
	private String status;

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

	public String getKodeKecamatan() {
		return kodeKecamatan;
	}

	public void setKodeKecamatan(String kodeKecamatan) {
		this.kodeKecamatan = kodeKecamatan;
	}

	public String getKodeKabupaten() {
		return kodeKabupaten;
	}

	public void setKodeKabupaten(String kodeKabupaten) {
		this.kodeKabupaten = kodeKabupaten;
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

	public DesaDto(String kodeDesa, String namaDesa, String kodeKecamatan, String kodeKabupaten, String kodeProvinsi,
			String status) {
		super();
		this.kodeDesa = kodeDesa;
		this.namaDesa = namaDesa;
		this.kodeKecamatan = kodeKecamatan;
		this.kodeKabupaten = kodeKabupaten;
		this.kodeProvinsi = kodeProvinsi;
		this.status = status;
	}

	public DesaDto() {
		super();
	}
}
