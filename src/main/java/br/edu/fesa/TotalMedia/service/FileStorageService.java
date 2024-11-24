package br.edu.fesa.TotalMedia.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    // Método para salvar o arquivo
    public String saveFile(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        // Cria o diretório, se não existir
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Define o caminho completo para o arquivo
        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        // Salva o arquivo no caminho especificado
        file.transferTo(filePath.toFile());

        return fileName; // Retorna apenas o nome do arquivo para salvar no banco, se necessário
    }

    // Método para recuperar o caminho completo de um arquivo
    public Path getFilePath(String fileName) {
        return Paths.get(uploadDir).resolve(fileName);
    }
}
