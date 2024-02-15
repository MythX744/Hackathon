package com.example.Project;

import com.example.Project.Controller.QRController;
import com.example.Project.DAO.UserDAO;
import com.example.Project.Service.IUserService;
import com.example.Project.Service.impl.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.io.File;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);

		QRController controller = new QRController();
        try {
            File outputfile = new File("./image.jpg");
            ImageIO.write(controller.zebraEAN13Barcode("4",400).getBody(), "jpg", outputfile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
