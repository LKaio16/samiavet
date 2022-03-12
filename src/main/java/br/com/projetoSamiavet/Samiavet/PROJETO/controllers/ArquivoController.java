package br.com.projetoSamiavet.Samiavet.PROJETO.controllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ArquivoController {

	
@RequestMapping(value="/uploadTeste" , method = RequestMethod.POST)
public void upload(@RequestParam(name="upload") MultipartFile upload) throws IOException {
Arquivo arquivo = new Arquivo();
 arquivo.upload("src/main/webapp/resources/comprovantes/", upload.getOriginalFilename(), upload);


}
}
