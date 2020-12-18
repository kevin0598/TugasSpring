package id.wilayah.TugasSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.wilayah.TugasSpring.dto.KabupatenDto;
import id.wilayah.TugasSpring.dto.StatusMessageDto;
import id.wilayah.TugasSpring.entity.KabupatenEntity;
import id.wilayah.TugasSpring.repository.KabupatenRepository;
import id.wilayah.TugasSpring.repository.ProvinsiRepository;
import id.wilayah.TugasSpring.service.KabupatenService;

@RestController
@RequestMapping("/kabupaten")
public class KabupatenController {
	@Autowired
	ProvinsiRepository repo2;

	@Autowired
	KabupatenRepository repo;

	@Autowired
	KabupatenService service;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<KabupatenEntity> kabupatenEntities = service.getAll();
		return ResponseEntity.ok(kabupatenEntities);
	}

	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody KabupatenDto Dto) {
		String nama=repo.findNama(Dto.getNamaKabupaten());
		String kode = repo2.findByEntity(Dto.getKodeProvinsi());
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		if (Dto.getKodeKabupaten().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaKabupaten().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeProvinsi().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Provinsi Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (kode == null) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Provinsi Tidak ada di Database");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaKabupaten().equals(nama)) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kabupaten sudah ada");
			result.setData(null);
			return ResponseEntity.ok(result);
		}  else {
			KabupatenEntity kabupatenEntity = service.kabupatenEntity(Dto);
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Berhasil Insert");
			result.setData(kabupatenEntity);
			return ResponseEntity.ok(result);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KabupatenDto Dto) {
		String nama=repo.findNama(Dto.getNamaKabupaten());
		String kode = repo.findByEntity2(id);
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		if (Dto.getKodeKabupaten().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaKabupaten().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeProvinsi().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Provinsi Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (!kode.equals(Dto.getKodeProvinsi())) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Provinsi Berbeda");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaKabupaten().equals(nama)) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kabupaten sudah ada");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else {
			KabupatenEntity kabupatenEntity = service.updateKabupaten(id, Dto);
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Berhasil Update");
			result.setData(kabupatenEntity);
			return ResponseEntity.ok(result);
		}
	}

	@GetMapping("/getStatus/{status}")
	public ResponseEntity<?> getStatus(@PathVariable String status) {
		List<KabupatenEntity> kabupatenEntities = service.getStatus(status);
		return ResponseEntity.ok(kabupatenEntities);
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		KabupatenEntity kabupatenEntity = service.delete(id);
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Berhasil Hapus");
		result.setData(kabupatenEntity);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/getkode/{kodeProvinsi}")
	public ResponseEntity<?> getKode(@PathVariable String kodeProvinsi) {
		List<KabupatenEntity> kabupatenEntity = service.getbyid(kodeProvinsi);
		return ResponseEntity.ok(kabupatenEntity);
	}

	@GetMapping("/getkode2/{kodeKabupaten}")
	public ResponseEntity<?> getKode3(@PathVariable String kodeKabupaten) {
		KabupatenEntity kabupatenEntity = service.getbykode(kodeKabupaten);
		return ResponseEntity.ok(kabupatenEntity);
	}

	@GetMapping("/getId/{id}")
	public ResponseEntity<?> getKode2(@PathVariable Integer id) {
		KabupatenEntity kabupatenEntity = service.getId(id);
		return ResponseEntity.ok(kabupatenEntity);
	}

}
