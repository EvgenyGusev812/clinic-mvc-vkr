package spbpu.vrk.clinic.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class PhotoController {

    @GetMapping("/photo/show/{url}")
    public void getImageAsByteArray(@PathVariable(name = "url") String url, HttpServletResponse response) throws IOException {
        url = "/Users/evgenygusev/Desktop/university/personal_photos/" + url;
        File file = new File(url);
        InputStream in = new FileInputStream(file);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }


}
