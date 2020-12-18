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

import id.wilayah.TugasSpring.dto.ProvinsiDto;
import id.wilayah.TugasSpring.dto.StatusMessageDto;
import id.wilayah.TugasSpring.entity.ProvinsiEntity;
import id.wilayah.TugasSpring.service.ProvinsiServiceImpl;

@RestController
@RequestMapping("/provinsi")
public class ProvinsiController {
	@Autowired
	ProvinsiServiceImpl provinsiServiceImpl;

	@GetMapping("/get-all")
	public ResponseEntity<?> getAll() {
		List<ProvinsiEntity> provinsiEntity = provinsiServiceImpl.getAll();
		return ResponseEntity.ok(provinsiEntity);
	}

	@GetMapping("/getStatus/{status}")
	public ResponseEntity<?> getStatus(@PathVariable String status) {
		List<ProvinsiEntity> provinsiEntities = provinsiServiceImpl.getStatus(status);
		return ResponseEntity.ok(provinsiEntities);
	}

	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody ProvinsiDto Dto) {
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		if (Dto.getKodeProvinsi().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Provinsi Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaProvinsi().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Provinsi Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else {
			ProvinsiEntity provinsiEntity = provinsiServiceImpl.insertProvinsi(Dto);
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Berhasil Insert");
			result.setData(provinsiEntity);
			return ResponseEntity.ok(result);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ProvinsiDto Dto) {
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		if (Dto.getKodeProvinsi().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Kode Provinsi Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else if (Dto.getNamaProvinsi().isEmpty()) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Provinsi Kosong");
			result.setData(null);
			return ResponseEntity.ok(result);
		} else {
			ProvinsiEntity provinsiEntity = provinsiServiceImpl.updateProvinsi(id, Dto);
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Berhasil Update");
			result.setData(provinsiEntity);
			return ResponseEntity.ok(result);
		}
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		ProvinsiEntity provinsiEntity = provinsiServiceImpl.deleteProvinsi(id);
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Berhasil Hapus");
		result.setData(provinsiEntity);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/getkode/{kodeProvinsi}")
	public ResponseEntity<?> getKode(@PathVariable String kodeProvinsi) {
		ProvinsiEntity provinsiEntity = provinsiServiceImpl.getbyid(kodeProvinsi);
		return ResponseEntity.ok(provinsiEntity);
	}

}
