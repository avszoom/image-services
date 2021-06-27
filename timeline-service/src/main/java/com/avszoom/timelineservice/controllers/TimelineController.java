package com.avszoom.timelineservice.controllers;

import com.avszoom.timelineservice.models.ImageList;
import com.avszoom.timelineservice.services.TimelineService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class TimelineController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TimelineService timelineService;

    @GetMapping("/images/{user}")
    public ImageList getImages(@PathVariable("user") String user){
        LOG.info("Fetching timeline.....");
        return timelineService.getImages(user);
    }

    @GetMapping("/image/{uuid}")
    public void getImage(@PathVariable("uuid") String uuid,  HttpServletResponse response) throws IOException {
        LOG.info("Fetching Image....." + uuid);
        byte[] image = timelineService.getImage(uuid);
        response.setContentType("image/jpeg");
        InputStream is = new ByteArrayInputStream(image);
        IOUtils.copy(is, response.getOutputStream());
    }
}
