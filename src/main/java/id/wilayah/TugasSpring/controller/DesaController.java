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

import id.wilayah.TugasSpring.dto.DesaDto;
import id.wilayah.TugasSpring.dto.StatusMessageDto;
import id.wilayah.TugasSpring.entity.DesaEntity;
import id.wilayah.TugasSpring.repository.DesaRepository;
import id.wilayah.TugasSpring.repository.KabupatenRepository;
import id.wilayah.TugasSpring.repository.KecamatanRepository;
import id.wilayah.TugasSpring.service.DesaService;

@RestController
@RequestMapping("/desa")
public class DesaController {
	@Autowired
	DesaRepository repo3;

	@Autowired
	KecamatanRepository repo2;

	@Autowired
	KabupatenRepository repo;

	@Autowired
	DesaService service;

	@GetMapping("/getAll")
	public ResponseEntity<?> get() {
		List<DesaEntity> desaEntities = service.getAll();
		return ResponseEntity.ok(desaEntities);
	}

	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody DesaDto Dto) {
		String nama=repo3.findNama(Dto.getNamaDesa());
		String kode3 = repo2.findKecamatan(Dto.getKodeKecamatan());
		String kode2 = repo2.findByEntity(Dto.getKodeKecamatan());
		String kode = repo.findByEntity(Dto.getKodeKabupaten());
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		if (Dto.getKodeKabupaten().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaDesa().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeDesa().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Desa Kosong");
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
		} else if (!Dto.getKodeKecamatan().equals(kode2)) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Salah Kode Kecamatan");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (!Dto.getKodeKabupaten().equals(kode3)) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Salah Kode Kabupaten");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaDesa().equals(nama)) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Desa sudah ada");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else {
			DesaEntity desaEntity = service.post(Dto);
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Berhasil Insert");
			result.setData(desaEntity);
			return ResponseEntity.ok(result);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> post(@PathVariable Integer id, @RequestBody DesaDto Dto) {
		String nama=repo3.findNama(Dto.getNamaDesa());
		String kode3 = repo3.findKecamatan(id);
		String kode = repo3.findKabupaten(id);
		String kode2 = repo3.findProvinsi(id);
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		if (Dto.getKodeKecamatan().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Kecamatan Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaDesa().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Desa Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeKabupaten().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Kabupaten Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeProvinsi().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Provinsi Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getKodeDesa().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Desa Kosong");
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
		} else if (!kode3.equals(Dto.getKodeKecamatan())) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Berbeda Kode Kecamatan");
			result.setData(null);
			return ResponseEntity.ok(result);
		}else if (Dto.getNamaDesa().equals(nama)) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Desa sudah ada");
			result.setData(null);
			return ResponseEntity.ok(result);
		}  else {
			DesaEntity desaEntity = service.update(id, Dto);
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Berhasil Update");
			result.setData(desaEntity);
			return ResponseEntity.ok(result);
		}
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		DesaEntity desaEntity = service.delete(id);
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Berhasil Hapus");
		result.setData(desaEntity);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/getkode5/{kodeDesa}")
	public ResponseEntity<?> getKode5(@PathVariable String kodeDesa) {
		DesaEntity desaEntity = service.getByKodeDesa(kodeDesa);
		return ResponseEntity.ok(desaEntity);
	}

	@GetMapping("/getkode/{kodeKecamatan}")
	public ResponseEntity<?> getKode(@PathVariable String kodeKecamatan) {
		List<DesaEntity> desaEntity = service.getByKodeKecamatan(kodeKecamatan);
		return ResponseEntity.ok(desaEntity);
	}

	@GetMapping("/getkode2/{kodeKabupaten}")
	public ResponseEntity<?> getKode2(@PathVariable String kodeKabupaten) {
		List<DesaEntity> desaEntity = service.getByKodeKabupaten(kodeKabupaten);
		return ResponseEntity.ok(desaEntity);
	}

	@GetMapping("/getkode3/{kodeProvinsi}")
	public ResponseEntity<?> getKode3(@PathVariable String kodeProvinsi) {
		List<DesaEntity> desaEntity = service.getByKodeProvinsi(kodeProvinsi);
		return ResponseEntity.ok(desaEntity);
	}

	@GetMapping("/getkode4/{id}")
	public ResponseEntity<?> getKode4(@PathVariable Integer id) {
		DesaEntity desaEntity = service.getById(id);
		return ResponseEntity.ok(desaEntity);
	}

	@GetMapping("/getStatus/{status}")
	public ResponseEntity<?> getStatus(@PathVariable String status) {
		List<DesaEntity> desaEntities = service.getStatus(status);
		return ResponseEntity.ok(desaEntities);
	}

}
