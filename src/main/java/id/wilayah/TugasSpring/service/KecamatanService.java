package id.wilayah.TugasSpring.service;

import java.util.List;

import id.wilayah.TugasSpring.dto.KecamatanDto;
import id.wilayah.TugasSpring.entity.KecamatanEntity;

public interface KecamatanService {
	List<KecamatanEntity> getAll();

	KecamatanEntity insert(KecamatanDto Dto);

	KecamatanEntity update(Integer id, KecamatanDto Dto);

	KecamatanEntity delete(Integer id);

	List<KecamatanEntity> getKodeProvinsi(String kode);

	List<KecamatanEntity> getKodeKabupaten(String kode);

	KecamatanEntity getKodeKecamatan(String kode);

	KecamatanEntity getById(Integer id);

	List<KecamatanEntity> getStatus(String status);
}
