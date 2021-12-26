package com.chernyllexs.thymeleafe.controllers;

import com.chernyllexs.thymeleafe.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadFileController {
    private final String UPLOAD_DIR = "src\\main\\resources\\templates\\downloads\\";

    private final PersonDAO personDAO;

    @Autowired
    public UploadFileController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/people/";
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = null;

        try {
            byte[] bytes = file.getBytes();
            path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, bytes);

            attributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        personDAO.uploadPerson(path);
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "redirect:/people/";
    }
}
