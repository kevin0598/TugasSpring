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

import id.wilayah.TugasSpring.dto.KecamatanDto;
import id.wilayah.TugasSpring.dto.StatusMessageDto;
import id.wilayah.TugasSpring.entity.KecamatanEntity;
import id.wilayah.TugasSpring.repository.KabupatenRepository;
import id.wilayah.TugasSpring.repository.KecamatanRepository;
import id.wilayah.TugasSpring.service.KecamatanService;

@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {
	@Autowired
	KecamatanRepository repo2;

	@Autowired
	KabupatenRepository repo;

	@Autowired
	KecamatanService service;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<KecamatanEntity> kecamatanEntity = service.getAll();
		return ResponseEntity.ok(kecamatanEntity);
	}

	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody KecamatanDto Dto) {
		String nama=repo2.findNama(Dto.getNamaKecamatan());
		String kode = repo.findByEntity(Dto.getKodeKabupaten());
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		if (Dto.getKodeKabupaten().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaKecamatan().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeProvinsi().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Provinsi Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeKecamatan().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Kecamatan Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (!Dto.getKodeProvinsi().equals(kode)) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Salah Kode Provinsi atau Kode Kabupaten");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaKecamatan().equals(nama)) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kecamatan sudah ada");
			result.setData(null);
			return ResponseEntity.ok(result);
		}  else {
			KecamatanEntity kecamatanEntity = service.insert(Dto);
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Berhasil Insert");
			result.setData(kecamatanEntity);
			return ResponseEntity.ok(result);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> post(@PathVariable Integer id, @RequestBody KecamatanDto Dto) {
		String nama=repo2.findNama(Dto.getNamaKecamatan());
		String kode = repo2.findKabupaten(id);
		String kode2 = repo2.findProvinsi(id);
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		if (Dto.getKodeKecamatan().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaKecamatan().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeKabupaten().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeProvinsi().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (!kode.equals(Dto.getKodeKabupaten())) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Berbeda Kode Kabupaten");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (!kode2.equals(Dto.getKodeProvinsi())) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Berbeda Kode Provinsi");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaKecamatan().equals(nama)) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kecamatan sudah ada");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else {
			KecamatanEntity kecamatanEntity = service.update(id, Dto);
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Berhasil Update");
			result.setData(kecamatanEntity);
			return ResponseEntity.ok(result);
		}
	}

	@GetMapping("/getStatus/{status}")
	public ResponseEntity<?> getStatus(@PathVariable String status) {
		List<KecamatanEntity> kecamatanEntities = service.getStatus(status);
		return ResponseEntity.ok(kecamatanEntities);
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		KecamatanEntity kecamatanEntity = service.delete(id);
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Berhasil Hapus");
		result.setData(kecamatanEntity);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/getkode/{kodeKecamatan}")
	public ResponseEntity<?> getKode(@PathVariable String kodeKecamatan) {
		KecamatanEntity kecamatanEntity = service.getKodeKecamatan(kodeKecamatan);
		return ResponseEntity.ok(kecamatanEntity);
	}

	@GetMapping("/getkode2/{kodeKabupaten}")
	public ResponseEntity<?> getKode2(@PathVariable String kodeKabupaten) {
		List<KecamatanEntity> kecamatanEntity = service.getKodeKabupaten(kodeKabupaten);
		return ResponseEntity.ok(kecamatanEntity);
	}

	@GetMapping("/getkode3/{kodeProvinsi}")
	public ResponseEntity<?> getKode3(@PathVariable String kodeProvinsi) {
		List<KecamatanEntity> kecamatanEntity = service.getKodeProvinsi(kodeProvinsi);
		return ResponseEntity.ok(kecamatanEntity);
	}

	@GetMapping("/getkode4/{id}")
	public ResponseEntity<?> getKode4(@PathVariable Integer id) {
		KecamatanEntity kecamatanEntity = service.getById(id);
		return ResponseEntity.ok(kecamatanEntity);
	}
}
