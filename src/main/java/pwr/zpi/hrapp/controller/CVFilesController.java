package pwr.zpi.hrapp.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(RestMappings.CV_FILES)
public class CVFilesController {

  @GetMapping(RestMappings.ID)
  public ResponseEntity<Resource> CVFileDownload(@PathVariable int id) {

    File file = new File("localResources/CV_files/" + "cv_" + id + ".pdf");

    if(!file.exists()){
      return ResponseEntity.status(404).body(null);
    }
    Resource resource = new FileSystemResource(file);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    return new ResponseEntity<>(resource, headers, HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<String> CVFileUpload(
      @RequestParam MultipartFile file, @RequestParam int id) {

    Path path = Paths.get("CV_files/" + "cv_" + id + ".pdf");
    File newFile = new File("localResources/CV_files/" + "cv_" + id + ".pdf");
    try {
      FileOutputStream outputStream = new FileOutputStream(newFile);
      outputStream.close();
      Files.copy(file.getInputStream(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
      newFile.delete();
      return ResponseEntity.status(406).body("Cannot upload file");
    }

    return ResponseEntity.ok(path.toString());
  }

  @DeleteMapping(RestMappings.ID)
  public ResponseEntity<Boolean> CVFileDelete(@PathVariable int id) {

    File file = new File("localResources/CV_files/" + "cv_" + id + ".pdf");
    if (file.delete()) {
      return ResponseEntity.ok(true);
    } else {
      return ResponseEntity.ok(false);
    }
  }
}
