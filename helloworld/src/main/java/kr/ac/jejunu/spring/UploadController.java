package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping(path="/spring/upload", method = RequestMethod.POST)
    public void upload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/webapp/WEB-INF/views/spring/resources/" + file.getOriginalFilename()));
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        outputStream.write(file.getBytes());
        outputStream.close();
        model.addAttribute("url", "/resources/" + file.getOriginalFilename());
    }

    @RequestMapping(path="/spring/upload", method=RequestMethod.GET)
    public void upload() {
    }
}
