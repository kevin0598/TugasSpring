package id.wilayah.TugasSpring.service;

import java.util.List;

import id.wilayah.TugasSpring.dto.KabupatenDto;
import id.wilayah.TugasSpring.entity.KabupatenEntity;

public interface KabupatenService {
	List<KabupatenEntity> getAll();

	KabupatenEntity kabupatenEntity(KabupatenDto Dto);

	KabupatenEntity updateKabupaten(Integer id, KabupatenDto Dto);

	KabupatenEntity delete(Integer id);

	List<KabupatenEntity> getbyid(String kodeString);

	KabupatenEntity getId(Integer id);

	KabupatenEntity getbykode(String kodeString);

	List<KabupatenEntity> getStatus(String status);
}
