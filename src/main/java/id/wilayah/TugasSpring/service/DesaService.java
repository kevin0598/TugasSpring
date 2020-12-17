package id.wilayah.TugasSpring.service;

import java.util.List;

import id.wilayah.TugasSpring.dto.DesaDto;
import id.wilayah.TugasSpring.entity.DesaEntity;

public interface DesaService {
	List<DesaEntity> getAll();
	DesaEntity post(DesaDto Dto);
	DesaEntity update(Integer id,DesaDto Dto);
	DesaEntity delete(Integer id);
	DesaEntity getById(Integer id);
	DesaEntity getByKodeDesa(String kode);
	List<DesaEntity> getByKodeKecamatan(String kode);
	List<DesaEntity> getByKodeKabupaten(String kode);
	List<DesaEntity> getByKodeProvinsi(String kode);
}
