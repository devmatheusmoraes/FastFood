package br.edu.infnet.fastFood.repositories;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainRepository {

    public static void main(String[] args) {
        try {

            String directoryName = "temp";
            String fileName = "arquivo.txt";


            Path directoryPath = Paths.get(directoryName);
            if (Files.notExists(directoryPath)) {
                Files.createDirectory(directoryPath);
                System.out.println("Diretório criado: " + directoryPath.toAbsolutePath());
            }


            Path filePath = directoryPath.resolve(fileName);

            Files.deleteIfExists(filePath);


            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
                System.out.println("Arquivo criado: " + filePath.toAbsolutePath());


                long fileSize = Files.size(filePath);
                String fileType = Files.probeContentType(filePath);


                String content = "Nome do Arquivo: LogProjeto \n";
                content += "Data de criação: " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n";
                content += "Tamanho do arquivo: " + fileSize + " bytes\n";
                content += "Tipo do arquivo: " + fileType + "\n";


                Files.writeString(filePath, content, StandardOpenOption.WRITE);
                System.out.println("Informações inseridas no arquivo.");

            }


            String fileContent = Files.readString(filePath);


            System.out.println("\nConteúdo do arquivo:");
            System.out.println("Data de criação: " + buscaInfoPorChave(fileContent, "Data de criação"));
            System.out.println("Nome do Arquivo: " + buscaInfoPorChave(fileContent, "Nome do Arquivo"));
            System.out.println("Tamanho do arquivo: " + buscaInfoPorChave(fileContent, "Tamanho do arquivo"));
            System.out.println("Tipo do arquivo: " + buscaInfoPorChave(fileContent, "Tipo do arquivo"));

        } catch (FileAlreadyExistsException e) {
            System.err.println("Erro: O arquivo já existe.");
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        }
    }

    private static String buscaInfoPorChave(String content, String key) {
        int startIndex = content.indexOf(key);
        if (startIndex == -1) {
            return "Informação não encontrada";
        }

        startIndex += key.length() + 2;
        int endIndex = content.indexOf('\n', startIndex);

        if (endIndex == -1) {
            endIndex = content.length();
        }

        return content.substring(startIndex, endIndex).trim();
    }

}
